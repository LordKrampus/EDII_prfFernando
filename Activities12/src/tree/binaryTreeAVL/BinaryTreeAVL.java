package tree.binaryTreeAVL;

public class BinaryTreeAVL implements BinaryTreeAVL_Interface{
    private BinaryTreeNodeAVL root;
    private int size;

    public BinaryTreeAVL(){
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
    public BinaryTreeNodeAVL getRoot(){
        return this.root;
    }

    @Override
    public void setRoot(BinaryTreeNodeAVL root, int size){
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
    public int calcHeight(BinaryTreeNodeAVL root){
        if(root == null) return 0;

        int leftLevel, rightLevel;
        leftLevel = this.calcHeight(root.leftBranch);
        rightLevel = this.calcHeight(root.rightBranch);
        return leftLevel > rightLevel? leftLevel + 1: rightLevel + 1;
    }

    public int calcMinHeight(BinaryTreeNodeAVL root){
        if(root == null || root.leftBranch == null || root.rightBranch == null) return 0;

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
    public BinaryTreeNodeAVL search(int value){
        return this.searchIterate(this.root, value);
    }

    private BinaryTreeNodeAVL searchIterate(BinaryTreeNodeAVL root, int value){
        if(root == null || root.value == value) return root;
        return (root.value > value?
                this.searchIterate(root.leftBranch, value):
                this.searchIterate(root.rightBranch, value));
    }

    @Override
    public int getBalance(int height){
        return height - this.calcMinHeight(this.root);
    }

    @Override
    public void insert(int value){
        this.root = this.insert(this.root, value);
    }

    //inserir recursivo
    //root não pode ser null
    private BinaryTreeNodeAVL insert(BinaryTreeNodeAVL root, int value){
        if (root == null) {
            this.size++;
            return new BinaryTreeNodeAVL(value);
        }

        int nextfb = 0; //coringa
        boolean auxIsLeaf = false;
        if (root.value > value) {
            if (root.leftBranch == null)
                auxIsLeaf = true; // coringa
            else
                nextfb = root.leftBranch.balancingFactor;

            root.leftBranch = this.insert(root.leftBranch, value);

            if (auxIsLeaf || nextfb != root.leftBranch.balancingFactor && root.leftBranch.balancingFactor != 0) // se o fator de balanceamento do ramo a esq. for 0, não houve alteração de nível ou ele é uma nova folha para um novo nível
                root.balancingFactor += 1;
        } else {
            if (root.rightBranch == null)
                auxIsLeaf = true; // coringa
            else
                nextfb = root.rightBranch.balancingFactor;

            root.rightBranch = this.insert(root.rightBranch, value);

            if (auxIsLeaf || nextfb != root.rightBranch.balancingFactor && root.rightBranch.balancingFactor != 0) // se o fator de balanceamento do ramo a dir. for 0, não houve alteração de nível, ou ele é uma nova folha para um novo nível
                root.balancingFactor -= 1;
        }

        //root.balancingFactor = this.calcHeight(root.leftBranch) - this.calcHeight(root.rightBranch);

        // se módulo do fator de balanceamento; se fb está em ]...,-2] ou [2,...[.
        if (Math.sqrt(Math.pow(root.balancingFactor, 2)) >= 2) {
            root = this.rotate(root, root.balancingFactor); // não existe a rotação geral e simples
        }

        return root;
    }

    private BinaryTreeNodeAVL rotate(BinaryTreeNodeAVL root, int fb){
        if(fb > 0){ // se positivo, no caso, seria o valor 2
             if(root.leftBranch.balancingFactor >= 0)
                root = this.rotateRight(root);
             else
                root = this.rotateDoubleRight(root);
        }else {
            if (root.rightBranch.balancingFactor <= 0)
                root = this.rotateLeft(root);
            else
                root = this.rotateDoubleLeft(root);
        }

        return root;
    }

    @Override
    public void remove(int value){
        this.root = this.remove(this.root, value);
    }

    private BinaryTreeNodeAVL remove(BinaryTreeNodeAVL root, int value) throws NullPointerException {
        if (root == null) return null;

        int nextfb = 0;
        //boolean auxhasChange = false;
        if (root.value > value) {
            if(root.leftBranch != null) {
                nextfb = root.leftBranch.balancingFactor;
                root.leftBranch = this.remove(root.leftBranch, value);

                if(root.leftBranch == null || (nextfb + root.leftBranch.balancingFactor  != 0) && nextfb != 0){
                    root.balancingFactor -= 1;
                }
            }
            //root.balancingFactor = (root.leftBranch != null? 1 : 0) + (root.rightBranch != null? -1 : 0);
        } else if (root.value < value) {
            if(root.rightBranch != null) {
                nextfb = root.rightBranch.balancingFactor;
                root.rightBranch = this.remove(root.rightBranch, value);

                if(root.rightBranch == null || (nextfb + root.rightBranch.balancingFactor != 0) && nextfb != 0){
                    root.balancingFactor -= -1;
                }
            }
            //root.balancingFactor = (root.leftBranch != null? 1 : 0) + (root.rightBranch != null? -1 : 0);
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
                BinaryTreeNodeAVL auxNode;
                auxNode = root.leftBranch;
                while (auxNode.rightBranch != null) {
                    auxNode = auxNode.rightBranch;
                }
                root.value = auxNode.value;
                auxNode.value = value;

                //nextfb = root.leftBranch.balancingFactor;
                root.leftBranch = this.remove(root.leftBranch, value);
                //se remoção seguinte, a chamada recursiva não itera atualizaçã de fb, portanto aqui isto é tratado
                if(root.leftBranch == null ){//|| (nextfb + root.leftBranch.balancingFactor != 0) && nextfb != 0){
                    root.balancingFactor -= 1;
                }
            }
        }

        // se módulo do fator de balanceamento; se fb está em ]...,-2] ou [2,...[.
        if (root != null && Math.sqrt(Math.pow(root.balancingFactor, 2)) >= 2){
            root = this.rotate(root, root.balancingFactor); // não existe a rotação geral e simples
        }

        return root;
    }

    private BinaryTreeNodeAVL rotateRight(BinaryTreeNodeAVL root){
        BinaryTreeNodeAVL leftRoot;
        leftRoot = root.leftBranch;

        root.leftBranch = leftRoot.rightBranch;
        //root.balancingFactor = (root.leftBranch != null? 1 : 0) + (root.rightBranch != null? -1 : 0); // problema
        //root.balancingFactor += (root.leftBranch != null? -1 : 0);
        root.balancingFactor = this.calcHeight(root.leftBranch) - this.calcHeight(root.rightBranch);

        leftRoot.rightBranch = root;
        //leftRoot.balancingFactor = (leftRoot.leftBranch != null? 1 : 0) + (leftRoot.rightBranch != null? -1 : 0);
        //leftRoot.balancingFactor -= 1;
        leftRoot.balancingFactor = this.calcHeight(leftRoot.leftBranch) - this.calcHeight(leftRoot.rightBranch);

        return leftRoot;
    }

    private BinaryTreeNodeAVL rotateLeft(BinaryTreeNodeAVL root){
        BinaryTreeNodeAVL rightRoot;
        rightRoot = root.rightBranch;

        root.rightBranch = rightRoot.leftBranch;
        //root.balancingFactor = (root.leftBranch != null? 1 : 0) + (root.rightBranch != null? -1 : 0); // problema
        //root.balancingFactor += (root.rightBranch != null? 1: 0);
        root.balancingFactor = this.calcHeight(root.leftBranch) - this.calcHeight(root.rightBranch);

        rightRoot.leftBranch = root;
        //rightRoot.balancingFactor = (rightRoot.leftBranch != null? 1 : 0) + (rightRoot.rightBranch != null? -1 : 0);
        //rightRoot.balancingFactor += 1;
        rightRoot.balancingFactor = this.calcHeight(rightRoot.leftBranch) - this.calcHeight(rightRoot.rightBranch);

        return rightRoot;
    }

    private BinaryTreeNodeAVL rotateDoubleRight(BinaryTreeNodeAVL root){
        root.leftBranch = this.rotateLeft(root.leftBranch);
        return this.rotateRight(root);
    }

    private BinaryTreeNodeAVL rotateDoubleLeft(BinaryTreeNodeAVL root){
        root.rightBranch = this.rotateRight(root.rightBranch);
        return this.rotateLeft(root);
    }

    @Override
    public String printPre(){
        return this.printPre(this.root);
    }

    private String printPre(BinaryTreeNodeAVL root){
        return (root != null?
                String.valueOf(root.value) + ", " + printPre(root.leftBranch) + printPre(root.rightBranch) :
                "");
    }

    @Override
    public String printIn(){
        return this.printIn(this.root);
    }

    private String printIn(BinaryTreeNodeAVL root){
        return (root != null?
                printIn(root.leftBranch) + String.valueOf(root.value) + ", " + printIn(root.rightBranch) :
                "");
    }

    @Override
    public String printPos(){
        return this.printPos(this.root);
    }

    private String printPos(BinaryTreeNodeAVL root){
        return (root != null?
                printPos(root.rightBranch) + printPos(root.leftBranch) + root.value + ", ":
                "");
    }
}
