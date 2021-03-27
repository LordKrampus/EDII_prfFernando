package treeStructure;

public interface BTree_Interface {
    boolean getCorrectness();
    int getHeight();
    void insert(int value);
    void remove(int value);
    BTreeNode search(int value);
    boolean hasElement(int value);
    String print();
}
