package treeStructure;

// tem um fonteiro para pagina filha
// tem um ponteiro para registro irmão na página
public class BTreeNode {
    public BTreePage leftBranch;
    public BTreeNode rightBranch;
    public int value;

    public BTreeNode(int value){
        this.value = value;
        this.leftBranch = leftBranch;
        this.rightBranch = rightBranch;
    }
}
