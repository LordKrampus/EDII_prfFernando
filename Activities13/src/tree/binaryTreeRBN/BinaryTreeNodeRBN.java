package tree.binaryTreeRBN;

public class BinaryTreeNodeRBN {
    public int value;
    public BinaryTreeNodeRBN leftBranch;
    public BinaryTreeNodeRBN rightBranch;
    public boolean color; // true -> black, false -> red

    public BinaryTreeNodeRBN(int value){
        this.value = value;
        this.leftBranch = null;
        this.rightBranch = null;
        this.color = false; //red
    }
}
