package tree.binaryTreeRBN;

public interface BinaryTreeRBN_Interface {
     void lose();
     BinaryTreeNodeRBN getRoot();
     void setRoot(BinaryTreeNodeRBN root, int size);
     int getSize();
     int getHeight();
     int getBalance();

     boolean hasElement(int value);
     BinaryTreeNodeRBN search(int value);

     void insert(int value);
     void remove(int value);

     String printPre();
     String printIn();
     String printPos();
}
