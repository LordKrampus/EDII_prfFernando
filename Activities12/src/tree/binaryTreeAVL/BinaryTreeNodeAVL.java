package tree.binaryTreeAVL;

public class BinaryTreeNodeAVL {
    public int value;
    public BinaryTreeNodeAVL leftBranch;
    public BinaryTreeNodeAVL rightBranch;
    public int balancingFactor;

    public BinaryTreeNodeAVL(int value){
        this.value = value;
        this.leftBranch = null;
        this.rightBranch = null;
        balancingFactor = 0;
    }
}
