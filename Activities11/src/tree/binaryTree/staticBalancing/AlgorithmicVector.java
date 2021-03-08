package tree.binaryTree.staticBalancing;

import tree.binaryTree.BinaryTree;
import tree.binaryTree.BinaryTreeNode;
import tree.binaryTree.BinaryTree_Interface;
import tree.binaryTree.utilities.Util;

public class AlgorithmicVector implements StaticBalancing_Interface{
    private int[] cacheSet;
    private int iteratorCacheSet;

    @Override
    public BinaryTree_Interface balance(BinaryTree_Interface bTree){
        this.iteratorCacheSet = 0;
        this.cacheSet = new int[bTree.getSize()];
        this.generateCacheSet(bTree.getRoot());

        return generateBalancedBinaryTree(bTree, bTree.getSize()-1);
        //return generateBalancedBinaryTree(bTree, 5000-1);
    }

    private void generateCacheSet(BinaryTreeNode root) {
        if (root == null) return;

        this.generateCacheSet(root.leftBranch);
        this.cacheSet[this.iteratorCacheSet++] = root.value;
        this.generateCacheSet(root.rightBranch);
    }

    private BinaryTree_Interface generateBalancedBinaryTree(BinaryTree_Interface bTree, int size){
        bTree.lose();
        insertValues(bTree, 0, size);

        return bTree;
    }

    private void insertValues(BinaryTree_Interface bTree, int firstIndex, int lastIndex){
        if(firstIndex > lastIndex) return;

        int midIndex = (firstIndex + lastIndex)/2;
        bTree.insert(this.cacheSet[midIndex]);

        this.insertValues(bTree, firstIndex, (midIndex - 1));
        this.insertValues(bTree, (midIndex + 1), lastIndex);
    }
}
