package tree.binaryTree;
import tree.binaryTree.BinaryTree_Interface;

public class BinaryTree implements BinaryTree_Interface{
    private BinaryTreeNode root;
    private int size;

    public BinaryTree(){
        this.root = null;
        this.size = 0;
    }

    public int getSize(){
        return this.size;
    }

    @Override
    public void insert(int value){
        if(this.root == null)
            this.root = new BinaryTreeNode(value);
        else
            this.insert(this.root, value);
        this.size++;
    }

    //inserir recursivo
    //root não pode ser null
    private void insert(BinaryTreeNode root, int value){
        if(root.value > value){
            if(root.leftBranch == null)
                root.leftBranch = new BinaryTreeNode(value);
            else
                this.insert(root.leftBranch, value);
        }else{
            if(root.rightBranch == null)
                root.rightBranch = new BinaryTreeNode(value);
            else
                this.insert(root.rightBranch, value);
        }
    }

    @Override
    public void remove(int value){
        this.root = this.remove(this.root, value);
        this.size--;
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
            } else if (root.leftBranch == null) {
                root = root.rightBranch;
            } else if (root.rightBranch == null) {
                root = root.leftBranch;
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
