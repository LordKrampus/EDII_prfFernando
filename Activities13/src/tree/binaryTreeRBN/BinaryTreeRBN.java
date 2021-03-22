package tree.binaryTreeRBN;

public class BinaryTreeRBN implements BinaryTreeRBN_Interface {
    private BinaryTreeNodeRBN root;
    private int size;

    public BinaryTreeRBN(){
        this.root = null;
        this.size = 0;
    }

    @Override
    public void lose(){
        if(size > 0) {
            this.root = null;
            this.size = 0;
        }
    }

    @Override
    public BinaryTreeNodeRBN getRoot(){
        return this.root;
    }

    @Override
    public void setRoot(BinaryTreeNodeRBN root, int size){
        this.root = root;
        this.size = size;
    }

    @Override
    public int getSize(){
        return this.size;
    }

    @Override
    public int getHeight(){
        return this.calcHeight(this.root);
    }

    // specífic functional for get Height method
    public int calcHeight(BinaryTreeNodeRBN root){
        if(root == null) return 0;

        int leftLevel, rightLevel;
        leftLevel = this.calcHeight(root.leftBranch);
        rightLevel = this.calcHeight(root.rightBranch);
        return leftLevel > rightLevel? leftLevel + 1: rightLevel + 1;
    }

    public int calcMinHeight(BinaryTreeNodeRBN root){
        if(root == null) return 0;
        if(root.leftBranch == null || root.rightBranch == null) return 1;

        int leftLevel, rightLevel;
        leftLevel = this.calcMinHeight(root.leftBranch);
        rightLevel = this.calcMinHeight(root.rightBranch);

        return leftLevel < rightLevel? leftLevel + 1: rightLevel + 1;
    }

    @Override
    public boolean hasElement(int value){
        return (this.searchIterate(this.root, value) != null);
    }

    @Override
    public BinaryTreeNodeRBN search(int value){
        return this.searchIterate(this.root, value);
    }

    private BinaryTreeNodeRBN searchIterate(BinaryTreeNodeRBN root, int value){
        if(root == null || root.value == value) return root;
        return (root.value > value?
                this.searchIterate(root.leftBranch, value):
                this.searchIterate(root.rightBranch, value));
    }

    @Override
    public int getBalance(){
        if (root == null)
            return 0;
        else
            return this.calcHeight(root.leftBranch) - this.calcHeight(root.rightBranch);
    }

    @Override
    public void insert(int value){
        if(this.root == null){
            size++;
            this.root = new BinaryTreeNodeRBN(value);
        }
        else{
            if(value < root.value)
                this.root = this.insert(root, root.leftBranch, root.rightBranch, value, false);
            else
                this.root = this.insert(root, root.rightBranch, root.leftBranch, value, true);
        }

        if (!root.color) // vermelho
            root.color = true; //preto
    }

    private BinaryTreeNodeRBN insert(BinaryTreeNodeRBN avo, BinaryTreeNodeRBN pai, BinaryTreeNodeRBN tio, int value, boolean direction){
        if(pai == null){
            size++;
            // em razão da sintonia com as diferentes condições onde pai é igual a null (relativo a raiz geral)
            if (!direction)
                avo.leftBranch = new BinaryTreeNodeRBN(value);
            else
                avo.rightBranch = new BinaryTreeNodeRBN(value);
            return avo;
        }

        boolean rotate = false; // auxiliar ao proximo, este é o pai ou tio de alguem
        if(value < pai.value){
            pai = this.insert(pai, pai.leftBranch, pai.rightBranch, value, false);

            //Caso1
            if(!pai.leftBranch.color && !pai.color){
                if(!(tio != null? tio.color: true)) {
                    pai.color = true;
                    tio.color = true;
                    avo.color = false; // vermelho
                }else{
                    //pai a esquerda do avo
                    if(!direction) {
                        avo = this.rotateRight(avo);
                        avo.color = true; // preto
                        avo.rightBranch.color = false; // vermelho
                    }
                    else {
                        avo = this.rotateDoubleLeft(avo);
                        avo.color = true; // preto
                        avo.leftBranch.color = false; // vermelho
                    }
                    rotate = true;
                }
            }
        } else {
            pai = this.insert(pai, pai.rightBranch, pai.leftBranch, value, true);

            //Caso 1
            if(!pai.rightBranch.color && !pai.color){
                if(!(tio != null? tio.color: true)) {
                    pai.color = true;
                    tio.color = true;
                    avo.color = false; // vermelho
                } else{
                    //pai a direita do avo
                    if(direction) {
                        avo = this.rotateLeft(avo);
                        avo.color = true; // preto
                        avo.leftBranch.color = false; // vermelho
                    } else {
                        avo = this.rotateDoubleRight(avo);
                        avo.color = true; // preto
                        avo.rightBranch.color = false; // vermelho
                    }
                    rotate = true;
                }
            }
        }

        //generalizando sincronia das atualizações para a recursão
        if(!rotate) {
            if (!direction)
                avo.leftBranch = pai;
            else
                avo.rightBranch = pai;
        }

        return avo;
    }

    //private BinaryTreeNodeRBN rotate(BinaryTreeNodeRBN root, int fb){
    //    return null;
    //}

    @Override
    public void remove(int value){
        this.root = this.remove(this.root, this.root, value);
    }

    private BinaryTreeNodeRBN remove(BinaryTreeNodeRBN lastRoot, BinaryTreeNodeRBN root, int value) throws NullPointerException {
        if (root == null) return null;

        int nextColor;
        if (root.value > value) {
            root.leftBranch = this.remove(root, root.leftBranch, value);
        } else if (root.value < value) {
            root.rightBranch = this.remove(root, root.rightBranch, value);
        } else {
            if (root.leftBranch == null && root.rightBranch == null) {
                root = null;
                this.size--;
            } else if (root.leftBranch == null) {
                root = root.rightBranch;
                this.size--;
            } else if (root.rightBranch == null) {
                root = root.leftBranch;
                this.size--;
            } else {
                root = this.configPathRemove(root, value);
            }
        }
        return root;
    }

    private BinaryTreeNodeRBN configPathRemove(BinaryTreeNodeRBN V, int value){
        BinaryTreeNodeRBN x; // x
        BinaryTreeNodeRBN p; // p; p->right (w - irmão de x);
        x = V.leftBranch;
        p = V;
        while (x.rightBranch != null) {
            p = x;
            x = x.rightBranch;
        }

        //caso 1
        //  V->vermelho e x->vermelho
        if(!V.color && !x.color);
            //return V;
        //caso 2
        // V->preto e x->vermelho
        else if(V.color && !x.color){
            V.color = true; // futuro x->preto
            //return V;
        }
        //caso 3
        // V->preto e x->preto
        else if(V.color && x.color){
            BinaryTreeNodeRBN w = p.rightBranch;
            // w->vermelho
            if(w != null && !w.color){
                w = this.rotateLeft(V);
                w.color = true; // w->preto
                V.color = false; // V->vermelho, futuro x
                //return w;
            }
            // w->preto
            else{
                // p->preto e w->preto, com w-left->preto e w-right->preto
                if(w == null && p.color || (w.leftBranch == null? true: w.leftBranch.color) &&
                                (w.rightBranch == null? true: w.rightBranch.color) && p.color) {
                    if(w != null)
                        w.color = false; // w->vermelho
                    //return V;
                }
                // p->vermelho e w->preto
                else if(!p.color){
                    if(w != null)
                        w.color = false; // w->vermelho
                    p.color = true; // p->preto
                    //return V;
                }
                // w->preto com w-left->vermelho e w-right->preto
                else if(w != null && w.leftBranch != null && !w.leftBranch.color &&
                        (w.rightBranch == null? true: w.rightBranch.color)){
                    w.color = false; // w->vermelho
                    w.leftBranch.color = true; // w-left->preto
                    p.rightBranch = rotateRight(w); //w-rotate
                    //return w; // !!!
                }
                // w->preto e w-riht->vermelho
                else if(w != null && w.rightBranch != null && !w.rightBranch.color){
                    w.rightBranch.color = false; // w-right->vermelho
                    w.color = p.color; // w->p->color
                    p.color = true; // p->preto
                    p = rotateLeft(p);
                    //return p;
                }
            }
        }
        // caso 4
        // V->vermelho e x->preto
        else if(!V.color && x.color){
            //V.color = false; // x->vermelho
            //return V;
        }

        V.value = x.value;
        x.value = value;
        V.leftBranch = this.remove(p, V.leftBranch, value); // remoção está no final

        return V;
    }

    private BinaryTreeNodeRBN rotateRight(BinaryTreeNodeRBN root){
        BinaryTreeNodeRBN leftRoot;
        leftRoot = root.leftBranch;

        root.leftBranch = leftRoot.rightBranch;
        leftRoot.rightBranch = root;

        return leftRoot;
    }

    private BinaryTreeNodeRBN rotateLeft(BinaryTreeNodeRBN root){
        BinaryTreeNodeRBN rightRoot;
        rightRoot = root.rightBranch;

        root.rightBranch = rightRoot.leftBranch;
        rightRoot.leftBranch = root;

        return rightRoot;
    }

    private BinaryTreeNodeRBN rotateDoubleRight(BinaryTreeNodeRBN root){
        root.leftBranch = this.rotateLeft(root.leftBranch);
        return this.rotateRight(root);
    }

    private BinaryTreeNodeRBN rotateDoubleLeft(BinaryTreeNodeRBN root){
        root.rightBranch = this.rotateRight(root.rightBranch);
        return this.rotateLeft(root);
    }

    @Override
    public String printPre(){
        return this.printPre(this.root);
    }

    private String printPre(BinaryTreeNodeRBN root){
        return (root != null?
                String.valueOf(root.value) + ", " + printPre(root.leftBranch) + printPre(root.rightBranch) :
                "");
    }

    @Override
    public String printIn(){
        return this.printIn(this.root);
    }

    private String printIn(BinaryTreeNodeRBN root){
        return (root != null?
                printIn(root.leftBranch) + String.valueOf(root.value) + ", " + printIn(root.rightBranch) :
                "");
    }

    @Override
    public String printPos(){
        return this.printPos(this.root);
    }

    private String printPos(BinaryTreeNodeRBN root){
        return (root != null?
                printPos(root.rightBranch) + printPos(root.leftBranch) + root.value + ", ":
                "");
    }
}
