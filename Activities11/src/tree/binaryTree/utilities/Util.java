package tree.binaryTree.utilities;

import tree.binaryTree.BinaryTreeNode;
import tree.binaryTree.BinaryTree_Interface;

public class Util {
    public static int getHeight_leftBalance(BinaryTree_Interface bTree){
        BinaryTreeNode root = bTree.getRoot();
        int levelsNumber;

        if(root != null)
            levelsNumber = 1;
        else return 0;

        while(root.leftBranch != null){
            root = root.leftBranch;
            levelsNumber++;
        }

        return levelsNumber;
    }

    public static int getHeight_rightBalance(BinaryTree_Interface bTree){
        BinaryTreeNode root = bTree.getRoot();
        int levelsNumber;

        if(root != null)
            levelsNumber = 1;
        else return 0;

        while(root.rightBranch != null){
            root = root.rightBranch;
            levelsNumber++;
        }

        return levelsNumber;
    }
}
