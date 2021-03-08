package tree.binaryTree.staticBalancing;

import tree.binaryTree.BinaryTree;
import tree.binaryTree.BinaryTreeNode;
import tree.binaryTree.BinaryTree_Interface;

public class AlgorithmicDSW implements StaticBalancing_Interface {
    @Override
    public BinaryTree_Interface balance(BinaryTree_Interface bTree){
        if(bTree.getSize() < 3) return bTree;

        degenerate(bTree);
        rotate(bTree);

        return bTree;
    }

    private void degenerate(BinaryTree_Interface bTree){
        BinaryTreeNode root = bTree.getRoot();

        if(root == null) return;
        root = this.iterateDegenerate(root);

        //conferindo se degenerada
        boolean isDegenerate = true;
        BinaryTreeNode rootAux = root;
        for(int i = 0; i < bTree.getSize(); i++){
            if(rootAux.leftBranch != null)
                isDegenerate = false;
            rootAux = rootAux.rightBranch;
        }
        if(!isDegenerate)
            System.out.println("it's not degenerated!!!");

        bTree.setRoot(root, bTree.getSize());
    }

    private BinaryTreeNode iterateDegenerate(BinaryTreeNode root) {
        if (root.leftBranch != null) {
            while(root.leftBranch != null) {
                BinaryTreeNode cacheNode = root.leftBranch;
                root.leftBranch = cacheNode.rightBranch;
                cacheNode.rightBranch = root;
                root = cacheNode;
            }
        }
        if(root.rightBranch != null)
            root.rightBranch = this.iterateDegenerate(root.rightBranch);

        return root;
    }

    //13 -> :11 -> ::5 -> ::2 -> ::1
    private void rotate(BinaryTree_Interface bTree){
        BinaryTreeNode root = bTree.getRoot();
        int m;

        //http://cee.uma.pt/edu/eda/eda_200506/Aula09.pdf
        m = (int)Math.pow(2,(int)(Math.log(bTree.getSize() + 1)/Math.log(2))) - 1; // loga(b) = log10(b)/log10(a) => log2(N + 1) = log(b + 1)/log(2)

        root = iterateRotate(root, bTree.getSize() - m);
        while(m > 1){
            m /= 2;
            root = iterateRotate(root, m);
        }

        bTree.setRoot(root, bTree.getSize());
    }

    private BinaryTreeNode iterateRotate(BinaryTreeNode root, int m){
        if(m > 1)
            root.rightBranch.rightBranch = iterateRotate(root.rightBranch.rightBranch, m - 1);

        BinaryTreeNode cacheRightRoot = root.rightBranch;
        root.rightBranch = cacheRightRoot.leftBranch; //rigth -> right.left
        cacheRightRoot.leftBranch = root; // right.left -> righ

        return cacheRightRoot;
    }
}
