import java.io.DataOutputStream;
import java.io.IOException;

public class RootedTree {
    /*
    A class to represent a Rooted tree.
     */
    TreeNode root;

    public RootedTree(){
    }
    public RootedTree(TreeNode source){
        root = source;
    }
    public void preorderPrint(DataOutputStream out) throws IOException {
        /*
        A method to print to the stream all nodes of the tree in pre order.
         */
        boolean from = true; //true -> came from parent or left sibling, false -> came from child
        TreeNode x = root;
        Queue<TreeNode> preOrderQueue = new Queue<>(); // A queue from the tree nodes, will be used later.
        while (x!=null){
            if(!x.seen){
                /*
                If it is the first time we see a TreeNode than add it to the queue.
                 */
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
            /*
            Prints the nodes with "," up to the second last element.
             */
            TreeNode v = preOrderQueue.dequeue();
            out.writeBytes(v.key +",");
        }
        TreeNode last = preOrderQueue.dequeue();
        out.writeBytes(String.valueOf(last.key)); //Print last element without ",".
    }

    public void printByLayer(DataOutputStream out) throws IOException {
        if(root == null)
            return;
        Queue<TreeNode> q =new Queue<>();
        int queueSize = 0;
        // Enqueue Root and initialize levelSize, i.e queueSize.
        q.enqueue(root);
        queueSize += 1;
        TreeNode run = null;
        while(true)
        {
            // nodeCount (queue size) indicates number of nodes
            // at current level.
            int nodeCount = queueSize; // Allow us to know how many Tree nodes are in a specific level,
            queueSize = 0; // will be incremented according to next level size.
            if(nodeCount == 0)
                break;
            // Dequeue all nodes of current level and Enqueue all
            // nodes of next level
            while(nodeCount > 0)
            {
                TreeNode node = q.front.key; // The first node of the level.
                if(nodeCount>1) {
                    // If we are not at the last element of the level, print with ","
                    out.writeBytes(node.key + ",");
                }
                else{
                    out.writeBytes(String.valueOf(node.key));
                }
                q.dequeue();
                // Initiating the next level.
                if(node.leftChild != null){
                    q.enqueue(node.leftChild);
                    queueSize += 1;
                    run = node.leftChild.rightSibling;
                }
                while(run != null){
                    q.enqueue(run);
                    queueSize += 1;
                    run = run.rightSibling;
                }
                nodeCount--;
            }
            out.writeBytes(System.lineSeparator());
        }
    }
}
