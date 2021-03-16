package tree.binaryTreeAVL;

public interface BinaryTreeAVL_Interface {
     void lose();
     BinaryTreeNodeAVL getRoot();
     void setRoot(BinaryTreeNodeAVL root, int size);
     int getSize();
     int getHeight();
     int getBalance(int height);

     boolean hasElement(int value);
     BinaryTreeNodeAVL search(int value);

     void insert(int value);
     void remove(int value);

     String printPre();
     String printIn();
     String printPos();
}
