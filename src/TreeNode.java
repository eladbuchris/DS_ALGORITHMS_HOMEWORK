
public class TreeNode {
    TreeNode parent;
    TreeNode leftChild;
    TreeNode rightSibling;
    int key;

    public  TreeNode(TreeNode parent,TreeNode leftChild,TreeNode rightSibling, int key){
        this.parent = parent;
        this.leftChild = leftChild;
        this.rightSibling = rightSibling;
        this.key = key;
    }
}
