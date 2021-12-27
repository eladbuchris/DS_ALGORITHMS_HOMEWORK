import java.io.DataOutputStream;
import java.io.IOException;

public class RootedTree {
    TreeNode root;

    public RootedTree(){
    }
    public RootedTree(TreeNode source){
        root = source;
    }
    public void preorderPrint(DataOutputStream out) throws IOException {
        boolean from = true; //true -> came from parent or left sibling, false -> came from child
        TreeNode x = root;
        Queue<TreeNode> preOrderQueue = new Queue<>();
        while (x!=null){
            if(!x.seen){
                preOrderQueue.enqueue(x);
                x.seen = true;
            }
            if (from){
                if(x.leftChild != null){
                    x = x.leftChild;
                }
                else{
                    if(x.rightSibling != null){
                        x = x.rightSibling;
                    }
                    else{
                        from = false;
                        x = x.parent;
                    }
                }
            }
            else{
                if(x.rightSibling != null){
                    from = true;
                    x = x.rightSibling;
                }
                else{
                    x = x.parent;
                }
            }
        }
        while(preOrderQueue.front.next != null){
            TreeNode v = preOrderQueue.dequeue();
            out.writeBytes(v.key +",");
        }
        TreeNode last = preOrderQueue.dequeue();
        out.writeBytes(String.valueOf(last.key));
    }
    public void printByLayer(DataOutputStream out) throws IOException {
        boolean fromChild = false; //true -> came from parent or left sibling, false -> came from child
        boolean fromParent = true;
        boolean fromSibling = false;
        out.writeBytes(String.valueOf(root.key));
        out.writeBytes(System.lineSeparator());
        root.printed = true;
        TreeNode x = root.leftChild;
        while(x != null){
            if(fromParent && x.printed){
                if(x.leftChild != null){
                    out.writeBytes(System.lineSeparator());
                    x = x.leftChild;
                    fromChild = false;
                    fromSibling = false;
                    fromParent = true;
                }
                else{
                    x = x.parent;
                    fromChild = true;
                    fromSibling = false;
                    fromParent = false;
                }
            }
            else if(fromSibling && x.printed){
                if(x.leftChild != null){
                    x = x.leftChild;
                    fromChild = false;
                    fromSibling = false;
                    fromParent = true;
                }
                else if(x.rightSibling != null){
                    x = x.rightSibling;
                    fromChild = false;
                    fromSibling = true;
                    fromParent = false;
                }
                else{
                    x = x.parent;
                    fromChild = true;
                    fromSibling = false;
                    fromParent = false;
                }
            }
        else if(fromChild){
            if(x.rightSibling != null){
                x = x.rightSibling;
                fromChild = false;
                fromSibling = true;
            }
            else {
                x = x.parent;
                fromChild = true;
                fromSibling = false;
            }
                fromParent = false;
            }
        else {
            if(fromParent && x.rightSibling == null){
                out.writeBytes(String.valueOf(x.key) );
                out.writeBytes(System.lineSeparator());
            }
            else{
                out.writeBytes(x.key + ",");
            }
            x.printed = true;
            if(x.rightSibling != null){
                x = x.rightSibling;
                fromChild = false;
                fromSibling = true;
            }
            else if(x.leftChild != null){
                x = x.leftChild;
                fromChild = false;
                fromParent = true;
                fromSibling = false;
                }
            else{
                x = x.parent;
                fromChild = true;
                fromSibling = false;
                fromParent = false;
            }
        }
        }
    }
}
