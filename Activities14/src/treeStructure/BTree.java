package treeStructure;

public class BTree implements BTree_Interface{
    private int ordem;
    private BTreePage root;
    private boolean correctness; //quantidade de pontos de disnível; um nó ramifica para uma página que quebra a relação de nivelamento da arvore

    public BTree(int ordem){
        this.ordem = ordem;
        this.root = null;

        correctness = true;
    }

    //é necessário verificar a altura para sincronizar estado
    @Override
    public boolean getCorrectness(){
        return this.correctness;
    }

    @Override
    public int getHeight(){
        return this.getHeight(this.root);
    }

    private int getHeight(BTreePage root){
        if(root == null) return 0;

        BTreeNode auxNode;
        auxNode = root.nodesStructure;

        int bigger = 0; // height
        int []levels = new int[root.n];
        int e = -1; // contar a quantidade de ramificações com niveis diferentes
        for(int i = 0; i < levels.length - 1; i++) {
            levels[i] = getHeight(auxNode.leftBranch);
            if (levels[i] > bigger) {
                bigger = levels[i];
                e++; // se existir ramificacao e existe nivel
            }

            auxNode = auxNode.rightBranch;
        }
        levels[root.n - 1] = getHeight(root.rightBranch);
        if (levels[root.n - 1] > bigger)
            bigger = levels[root.n - 1];

        if(e > 0)
            correctness = false;
        else
            correctness = true;

        return bigger + 1;
    }

    @Override
    public BTreeNode search(int value){
        if(this.root == null) return null;
        //verificar no - igual, menor ou maior é o valor que ele (o nó atual)
        //se igual encontroe
        //se menor -> buscar na página à esquerda
        //se maior -> buscar na página à direita - se direita do nó é null, verificar direita da página

        BTreePage auxPage;
        BTreeNode auxNode;
        auxPage = this.root;
        auxNode = auxPage.nodesStructure;
        while(auxPage != null){
            //existe pelo menos um movimento a cada volta; e o retorno é garantido,
            //se achar ou não o elemento na arvore.
            // se auxNode é null, sempre é consultada a pagina alternativa a direita de auxPAge,
            // que pode ser null e condicionar não existencia do elemento na estrutura como todo.
            if(auxNode.value == value){
                //encontrou
                return auxNode;
            } else if(auxNode.value > value){
                //menor -> ir a esquerda (left page)
                auxPage = auxNode.leftBranch;
                if(auxPage == null)
                    continue; // parar laco

                auxNode = auxPage.nodesStructure;
                // ou retorna null, ou continua pela, nova página agora
                continue; // assumindo em sub pagina
            } else{
                //maior -> ir a direita (right page)
                auxNode = auxNode.rightBranch;
                if(auxNode == null){
                    auxPage = auxPage.rightBranch;
                    if(auxPage == null)
                        continue;

                    auxNode = auxPage.nodesStructure;
                    continue; // assumindo em sub pagina
                }
                //else turn the loop to check if finds the node there
            }
        }

        return null; // não encontrou
    }

    @Override
    public boolean hasElement(int value){
        return this.search(value) != null; // verdade -> tem o elemento
    }

    @Override
    public void insert(int value){
        if(this.root == null){
            this.root = new BTreePage();
            this.root.nodesStructure = new BTreeNode(value);
            this.root.n++;
        }else {
            this.root = this.insert(this.root, value);
            if(this.root.n > this.ordem * 2)
                this.root = deslocarRaiz(this.root);
        }
    }

    private BTreePage deslocarRaiz(BTreePage pageRoot){
        BTreePage newPage = new BTreePage();
        BTreePage newRoot = new BTreePage();

        //encontrar centro na pagina ramificada
        BTreeNode lastMid = null;
        BTreeNode midNode = pageRoot.nodesStructure;
        int midIndex = (pageRoot.n / 2) + 1;
        for(int i = 1; i < midIndex; i++){
            lastMid = midNode;
            midNode = midNode.rightBranch;
        }

        // rearranjo pos mid - newRoot -> newPage
        newPage.nodesStructure = midNode.rightBranch;
        newPage.rightBranch = pageRoot.rightBranch;
        midNode.rightBranch = null; // structure of new root // referencia vai para resp da pagina

        // rearranjo ante mid - rootpage <- newRoot
        lastMid.rightBranch = null; // esquece referencia
        pageRoot.rightBranch = midNode.leftBranch;
        midNode.leftBranch = pageRoot; // structure of new root

        newRoot.nodesStructure = midNode; // com left para pageRot
        newRoot.rightBranch = newPage; // e com right da pagina para nova pagina

        //correção de n
        newRoot.n++;
        newPage.n = pageRoot.n - midIndex;
        pageRoot.n = midIndex - 1;

        return newRoot;
    }

    //rearranjar elementos na pagina da pagina ramificada insconsistente
    private BTreePage deslocar(BTreePage pageRoot, BTreeNode lastNode, BTreePage branch){
        BTreePage newPage = new BTreePage();

        //encontrar centro na pagina ramificada
        BTreeNode lastMid = null;
        BTreeNode midNode = branch.nodesStructure;
        int midIndex = (branch.n / 2) + 1;
        for(int i = 1; i < midIndex; i++){
            lastMid = midNode;
            midNode = midNode.rightBranch;
        }

        //parte maior a direita para a direita; nova pagina
        newPage.nodesStructure = midNode.rightBranch;
        //corrige referencia a direita
        lastMid.rightBranch = null; // esquecendo referencia
        if(pageRoot.rightBranch == branch){
            midNode.rightBranch = null; // extremo limite da estrutura

            midNode.leftBranch = pageRoot.rightBranch; // troca
            pageRoot.rightBranch = newPage; // nova reponsabilidade

            lastNode.rightBranch = midNode;
        }else {
            // apenas ramificações do tipo a esquerda de nó
            if (lastNode != null) {
                midNode.rightBranch = lastNode.rightBranch; //tem?

                midNode.leftBranch = lastNode.rightBranch.leftBranch;
                lastNode.rightBranch.leftBranch = newPage;

                lastNode.rightBranch = midNode;
            }else{
                midNode.rightBranch = pageRoot.nodesStructure;

                midNode.leftBranch = pageRoot.nodesStructure.leftBranch;
                pageRoot.nodesStructure.leftBranch = newPage;

                pageRoot.nodesStructure = midNode;
            }
        }

        //correção de n
        pageRoot.n++;
        newPage.n = branch.n - midIndex;
        branch.n = midIndex - 1;

        return pageRoot;
    }

    //inserir direto
    public BTreePage insert(BTreePage pageRoot, BTreeNode lastNode, int value){
        BTreeNode newNode = new BTreeNode(value);

        //inserir no primario da estrutura
        if(lastNode == null){
            newNode.rightBranch = pageRoot.nodesStructure;
            pageRoot.nodesStructure = newNode;
        }else {
            //inserir consequente
            newNode.rightBranch = lastNode.rightBranch;
            lastNode.rightBranch = newNode;
        }

        pageRoot.n++;
        return pageRoot;
    }

    //iterar
    public BTreePage insert(BTreePage pageRoot, int value){
        BTreeNode lastNode = null;
        BTreeNode node = pageRoot.nodesStructure;

        int limite = pageRoot.n;
        int i = 0;
        while(i < limite) {
            if (node.value > value) {
                //inserir na pagina ramificada
                if (node.leftBranch != null) {
                    node.leftBranch = insert(node.leftBranch, value); // trocando de pagina
                    if(node.leftBranch.n > ordem * 2)
                        pageRoot = deslocar(pageRoot, lastNode, node.leftBranch);
                } else {
                    //else, inserir na pagina atual
                    pageRoot = this.insert(pageRoot, lastNode, value);
                }

                break;
            } else {
                if (node.rightBranch == null) {
                    //inserir na pagina ramificada
                    if (pageRoot.rightBranch != null) {
                        pageRoot.rightBranch = insert(pageRoot.rightBranch, value); // trocando de pagina
                        if(pageRoot.rightBranch.n > ordem * 2)
                            pageRoot = deslocar(pageRoot, node, pageRoot.rightBranch);
                    } else {
                        //else, inserir na pagina atual; a direita
                        pageRoot = insert(pageRoot, node, value);
                    }

                    break;
                } else {
                    //else, avancar no no da pagina
                    lastNode = node;
                    node = node.rightBranch;
                }
            }

            i++;
        }

        return pageRoot;
    }

    @Override
    public void remove(int value){
        this.root = remove(this.root, value);
    }

    public BTreePage replaceSub(BTreePage pageRoot, BTreeNode node){
        BTreePage auxPage;
        BTreeNode auxNode;
        int value;

        auxPage = node.leftBranch;
        while(auxPage.rightBranch != null){
            //deslocando para pagina com maiores avalores
            auxPage = auxPage.rightBranch;
        }

        auxNode = auxPage.nodesStructure;
        while(auxNode.rightBranch != null){
            //deslocando para nodo com maior valor;
            auxNode = auxNode.rightBranch;
        }

        value = node.value;
        //substituindo apenas valor de resitro
        node.value = auxNode.value;;
        auxNode.value = value;

        return pageRoot;
    }

    private BTreePage resolverOrdemBasicaRemocao(BTreePage pageRoot, BTreeNode afterNode){
        BTreePage auxPageLeft, auxPageRight;
        BTreeNode auxNodeLeft;
        BTreeNode node;
        if(afterNode != null){
            node = afterNode.rightBranch;
        }else{
            node = pageRoot.nodesStructure;
        }

        BTreeNode lastAuxNodeLeft;
        auxPageLeft = node.leftBranch;
        lastAuxNodeLeft = null;
        auxNodeLeft = auxPageLeft.nodesStructure;
        while(auxNodeLeft.rightBranch != null){
            lastAuxNodeLeft = auxNodeLeft;
            auxNodeLeft = auxNodeLeft.rightBranch;
        }
        auxNodeLeft.rightBranch = node.rightBranch;
        auxNodeLeft.leftBranch = node.leftBranch;
        if(afterNode != null){
            afterNode.rightBranch = auxNodeLeft;
        }else{
            pageRoot.nodesStructure = auxNodeLeft;
        }
        lastAuxNodeLeft.rightBranch = null;
        auxPageLeft.n--;


        if(node.rightBranch != null){
            auxPageRight = node.rightBranch.leftBranch;
        }else{
            auxPageRight = pageRoot.rightBranch;
        }
        node.rightBranch = auxPageRight.nodesStructure;
        node.leftBranch = null;
        auxPageRight.nodesStructure = node;
        auxPageRight.n++;

        return pageRoot;
    }

    public BTreePage remove(BTreePage pageRoot, int value){
        if(pageRoot == null) return null;

        // itera as camadas da pagina
        BTreeNode lastNode;
        BTreeNode node;
        lastNode = null;
        node = pageRoot.nodesStructure;
        while(node != null){
            // busca, suboperacoes apenas a ramificacoes à esquerda
            if(node.value > value){
                node.leftBranch = this.remove(node.leftBranch, value);

                // desordem de uma ramificação esquerda
                if(node.leftBranch.n < this.ordem){

                }
            }else if(node.value < value){
                //proximo nó
                lastNode = node;
                node = node.rightBranch;
                continue; // continuacao do laco
            }else{
                //considerando que se existe uma ramificação de qualquer nó na pagina então
                // existirá de todos estes inclusive da página
                if(node.leftBranch == null){
                    // não existe ramificações na página
                    if(lastNode == null)
                        pageRoot.nodesStructure = node.rightBranch;
                    else
                        lastNode.rightBranch = node.rightBranch;
                    // nota -> elemento é ignorado da estrutura
                    node.rightBranch = null; // não necessário, acredito
                    return pageRoot; // fez remocao
                } else{
                    //encontrar maior dos menores - antecessor indireto do nó
                    pageRoot = this.replaceSub(pageRoot, node); // na verdade não é necessário o retorno
                    node.leftBranch = remove(node.leftBranch, value); // remocao na pagina

                    if(node.leftBranch.n < this.ordem){

                    }
                }

                pageRoot.n--;
            }
            //limite do laco;
            break;
        }
        //não está antes então ir a depois
        if(pageRoot.rightBranch != null) {
            pageRoot.rightBranch = this.remove(pageRoot.rightBranch, value);
        }


        return pageRoot;
    }

    @Override
    public String print(){
          return this.printIterate(this.root);
    }

    private String printIterate(BTreePage root){
        StringBuilder sb = new StringBuilder();

        BTreeNode auxNode = root.nodesStructure;
        while(auxNode != null){
            if(auxNode.leftBranch != null)
                sb.append(printIterate(auxNode.leftBranch));

            sb.append( auxNode.value + ", ");

            auxNode = auxNode.rightBranch;
        }
        if(root.rightBranch != null)
            sb.append(printIterate(root.rightBranch));

        return sb.toString();
    }
}
