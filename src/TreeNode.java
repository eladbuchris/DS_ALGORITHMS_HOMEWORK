
public class TreeNode {
    /*
    A class to represent a TreeNode.
     */
    TreeNode parent;
    TreeNode leftChild;
    TreeNode rightSibling;
    int key;
    int level = 0;
    boolean seen = false;

    public TreeNode(TreeNode parent,TreeNode leftChild,TreeNode rightSibling, int key){
        /*
        The constructor for the TreeNode class, initiates the given attributes.
         */
        this.parent = parent;
        this.leftChild = leftChild;
        this.rightSibling = rightSibling;
        this.key = key;
    }
}
