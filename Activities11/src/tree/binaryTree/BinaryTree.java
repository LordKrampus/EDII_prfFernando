package tree.binaryTree;
import tree.binaryTree.BinaryTree_Interface;

public class BinaryTree implements BinaryTree_Interface{
    private BinaryTreeNode root;
    private int size;

    public BinaryTree(){
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
    public BinaryTreeNode getRoot(){
        return this.root;
    }

    @Override
    public void setRoot(BinaryTreeNode root, int size){
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

    @Override
    public boolean hasElement(int value){
        return (this.searchElement(this.root, value) != null);
    }

    private BinaryTreeNode searchElement(BinaryTreeNode root, int value){
        if(root == null || root.value == value) return root;
        return (root.value > value?
                this.searchElement(root.leftBranch, value):
                this.searchElement(root.rightBranch, value));
    }

    // specífic functional for get Height method
    private int calcHeight(BinaryTreeNode root){
        if(root == null) return 0;

        int leftLevel, rightLevel;
        leftLevel = this.calcHeight(root.leftBranch);
        rightLevel = this.calcHeight(root.rightBranch);
        return leftLevel > rightLevel? leftLevel + 1: rightLevel + 1;
    }

    public int calcMinHeight(BinaryTreeNode root){
        if(root == null) return 0;
        if (root.leftBranch == null) return 1;
        if (root.rightBranch == null) return 1;

        int leftLevel, rightLevel;
        leftLevel = this.calcMinHeight(root.leftBranch);
        rightLevel = this.calcMinHeight(root.rightBranch);

        return leftLevel < rightLevel? leftLevel + 1: rightLevel + 1;
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
    private BinaryTreeNode insert(BinaryTreeNode root, int value){
        if(root == null){
            root = new BinaryTreeNode(value);
            this.size++;
        }
        else if(root.value > value)
            root.leftBranch = insert(root.leftBranch, value);
        else
            root.rightBranch = insert(root.rightBranch, value);

        return root;
    }

    @Override
    public void remove(int value){
        this.root = this.remove(this.root, value);
    }

    private BinaryTreeNode remove(BinaryTreeNode root, int value) throws NullPointerException {
        if (root == null) return null;

        else if (root.value > value) {
            root.leftBranch = this.remove(root.leftBranch, value);
        } else if (root.value < value) {
            root.rightBranch = this.remove(root.rightBranch, value);
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
                BinaryTreeNode auxNode;
                auxNode = root.leftBranch;
                while (auxNode.rightBranch != null) {
                    auxNode = auxNode.rightBranch;
                }
                root.value = auxNode.value;
                auxNode.value = value;
                root.leftBranch = this.remove(root.leftBranch, value);
            }
        }
        return root;
    }

    @Override
    public String printPre(){
        return this.printPre(this.root);

    }

    private String printPre(BinaryTreeNode root){
        return (root != null?
                String.valueOf(root.value) + ", " + printPre(root.leftBranch) + printPre(root.rightBranch) :
                "");
    }

    @Override
    public String printIn(){
        return this.printIn(this.root);
    }

    private String printIn(BinaryTreeNode root){
        return (root != null?
                printIn(root.leftBranch) + String.valueOf(root.value) + ", " + printIn(root.rightBranch) :
                "");
    }

    @Override
    public String printPos(){
        return this.printPos(this.root);
    }

    private String printPos(BinaryTreeNode root){
        return (root != null?
                printPos(root.rightBranch) + printPos(root.leftBranch) + root.value + ", ":
                "");
    }
}
