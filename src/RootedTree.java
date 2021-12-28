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
//    public void printByLayer(DataOutputStream out) throws IOException {
//        Queue<TreeNode> levelStack = new Queue<>();
//        LinkedList<TreeNode> nodesByLayer = new LinkedList<>();
//        Stack<TreeNode> toPrint = new Stack<>();
//        boolean from = true; //true -> came from parent or left sibling, false -> came from child
//        TreeNode fromStack = null;
//        out.writeBytes(String.valueOf(root.key));
//        out.writeBytes(System.lineSeparator());
//        TreeNode x = root.leftChild;
////        if(x != null) {
////            x.level += x.parent.level + 1;
////        }
//        levelStack.enqueue(x);
//        Queue<TreeNode> preOrderQueue = new Queue<>();
//        while (x!=null){
//            if(x == levelStack.front.key){
//                fromStack = levelStack.dequeue();
//            }
//            if(!x.inList) {
//                Element <TreeNode> newElement = new Element<>(x);
//                x.linkedListElement = newElement;
//                if(fromStack == null){
//                    nodesByLayer.listInsertByElement(newElement);
//                }
//                else{
//                    nodesByLayer.listInsertBefore(x.linkedListElement,fromStack.linkedListElement);
//                    fromStack = null;
//                }
//                x.inList = true;
//            }
//            if (from){
//                if(x.leftChild != null){
//                    levelStack.enqueue(x);
//                    x = x.leftChild;
//                }
//                else{
//                    if(x.rightSibling != null){
//                        levelStack.dequeue();
//                        x = x.rightSibling;
//                    }
//                    else{
//                        levelStack.enqueue(x);
//                        from = false;
//                        x = x.parent;
//                    }
//                }
//            }
//            else{
//                if(x.rightSibling != null){
//                    from = true;
//                    x = x.rightSibling;
//                }
//                else{
//                    fromStack = levelStack.dequeue();
//                    levelStack.enqueue(x);
//                    x = x.parent;
//                }
//            }
//        }
//        Element<TreeNode> run = nodesByLayer.head;
//        while(run!=null){
//            toPrint.push(run.data);
//            run = run.next;
//        }
//        while(toPrint.peek() != null){
//            if(toPrint.peek() == root){
//                toPrint.pop();
//                continue;
//            }
//            if(toPrint.getSecond() != null) {
//                if (toPrint.peek().level + 1 == toPrint.getSecond().level) {
//                    out.writeBytes(String.valueOf(toPrint.peek().key));
//                    out.writeBytes(System.lineSeparator());
//                }
//                else{
//                    out.writeBytes(String.valueOf(toPrint.peek().key) + ",");
//                }
//            }
//            else{
//                out.writeBytes(String.valueOf(toPrint.peek().key));
//            }
//            toPrint.pop();
//        }
//    }
    /* An Iterative Java program to print levels line by line */

        // Iterative method to do level order traversal line by line
    public void printByLayer(DataOutputStream out) throws IOException {
        // Base Case
        if(root == null)
            return;
        // Create an empty queue for level order traversal
        Queue<TreeNode> q =new Queue<>();
        int queueSize = 0;
        // Enqueue Root and initialize height
        q.enqueue(root);
        queueSize += 1;
        TreeNode run = null;
        while(true)
        {
            // nodeCount (queue size) indicates number of nodes
            // at current level.
            int nodeCount = queueSize;
            queueSize = 0;
            if(nodeCount == 0)
                break;
            // Dequeue all nodes of current level and Enqueue all
            // nodes of next level
            while(nodeCount > 0)
            {
                TreeNode node = q.front.key;
                if(nodeCount>1) {
                    out.writeBytes(node.key + ",");
                }
                else{
                    out.writeBytes(String.valueOf(node.key));
                }
                q.dequeue();
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
//This code is contributed by Sumit Ghosh

//    public void printByLayer(DataOutputStream out) throws IOException {
//        boolean fromChild = false; //true -> came from parent or left sibling, false -> came from child
//        boolean fromParent = true;
//        boolean fromSibling = false;
////        out.writeBytes(String.valueOf(root.key));
////        out.writeBytes(System.lineSeparator());
////        root.printed = true;
//        TreeNode x = root;
//        while(x != null){
//            if(fromParent && x.printed){
//                if(x.leftChild != null){
//                    out.writeBytes(System.lineSeparator());
//                    x = x.leftChild;
//                    fromChild = false;
//                    fromSibling = false;
//                    fromParent = true;
//                }
//                else{
//                    x = x.parent;
//                    fromChild = true;
//                    fromSibling = false;
//                    fromParent = false;
//                }
//            }
//            else if(fromSibling && x.printed){
//                if(x.leftChild != null){
//                    x = x.leftChild;
//                    fromChild = false;
//                    fromSibling = false;
//                    fromParent = true;
//                }
//                else if(x.rightSibling != null){
//                    x = x.rightSibling;
//                    fromChild = false;
//                    fromSibling = true;
//                    fromParent = false;
//                }
//                else{
//                    x = x.parent;
//                    fromChild = true;
//                    fromSibling = false;
//                    fromParent = false;
//                }
//            }
//        else if(fromChild){
//            if(x.rightSibling != null){
//                x = x.rightSibling;
//                fromChild = false;
//                fromSibling = true;
//                fromParent = false;
//                }
//            else {
//                x = x.parent;
//                fromChild = true;
//                fromSibling = false;
//                fromParent = false;
//                }
//            }
//        else {
//            if(fromParent && x.rightSibling == null){
//                out.writeBytes(String.valueOf(x.key));
//                out.writeBytes(System.lineSeparator());
//                }
//            else{
//                if(x.parent.rightSibling == null && x.rightSibling == null){
//                    out.writeBytes(String.valueOf(x.key));
//                    out.writeBytes(System.lineSeparator());
//                }
//                else{
//                out.writeBytes(x.key + ",");}
//            }
//            x.printed = true;
//            if(x.rightSibling != null){
//                x = x.rightSibling;
//                fromChild = false;
//                fromSibling = true;
//                fromParent = false;
//                }
//            else if(x.leftChild != null){
//                x = x.leftChild;
//                fromChild = false;
//                fromParent = true;
//                fromSibling = false;
//                }
//            else{
//                x = x.parent;
//                fromChild = true;
//                fromSibling = false;
//                fromParent = false;
//                }
//            }
//        }
//    }
//}
