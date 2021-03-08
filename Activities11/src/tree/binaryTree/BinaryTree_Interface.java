package tree.binaryTree;

public interface BinaryTree_Interface {
     void lose();
     BinaryTreeNode getRoot();
     void setRoot(BinaryTreeNode root, int size);
     int getSize();
     int getHeight();
     int getBalance(int height);

     boolean hasElement(int value);

     void insert(int value);
     void remove(int value);

     String printPre();
     String printIn();
     String printPos();
}
