public class DynamicGraph {
    LinkedList<GraphNode> nodesInGraph;
    LinkedList<GraphEdge> edgesInGraph;

    public DynamicGraph(){
        nodesInGraph = new LinkedList<>();
        edgesInGraph = new LinkedList<>();
    }

    public GraphNode insertNode(int nodeKey){
        GraphNode newNode = new GraphNode(nodeKey);
        Element<GraphNode> newElement = new Element<>(newNode);
        newNode.linkedListElement = newElement;
        if (this.nodesInGraph.head == null) {
            this.nodesInGraph.head = newElement;
            return newNode;
        }
        this.nodesInGraph.head.prev = newElement;
        newElement.next = this.nodesInGraph.head;
        this.nodesInGraph.head = newElement;
        return newNode;
    }

    public void deleteNode(GraphNode node) {
        if(node.outNeighbors.head == null && node.inNeighbors.head == null) {
            if (node.linkedListElement.prev != null) {
                node.linkedListElement.prev.next = node.linkedListElement.next;
            } else {
                this.nodesInGraph.head = node.linkedListElement.next;
            }
            if (node.linkedListElement.next != null) {
                node.linkedListElement.next.prev = node.linkedListElement.prev;
            }
        }
    }


    public GraphEdge insertEdge(GraphNode from, GraphNode to){
        GraphEdge newEdge = new GraphEdge(from, to);
        Element<GraphEdge> newElement = new Element<>(newEdge);
        to.addInNeighbor(from);
        from.addOutNeighbor(to);
        newEdge.toElement = from.outNeighbors.head;
        newEdge.fromElement = to.inNeighbors.head;
        newEdge.linkedListElement = newElement;
        if (this.edgesInGraph.head == null) {
            this.edgesInGraph.head = newElement;
            return newEdge;
        }
        this.edgesInGraph.head.prev = newElement;
        newElement.next = this.edgesInGraph.head;
        this.edgesInGraph.head = newElement;
        return newEdge;
    }

    public void deleteEdge(GraphEdge edge) {
        Element<GraphNode> fromElement = edge.fromElement;
        Element<GraphNode> toElement = edge.toElement;
        GraphNode from = edge.edge[0];
        GraphNode to = edge.edge[1];
        from.outNeighbors.listDelete(toElement);
        to.inNeighbors.listDelete(fromElement);
        this.edgesInGraph.listDelete(edge.linkedListElement);
    }

    public RootedTree bfs(GraphNode source){
        Queue<GraphNode> bfsQueue = new Queue<>();
        Queue<TreeNode> bfsTreeQueue = new Queue<>();
        TreeNode treeSource = bfsInitialization(source,bfsQueue,bfsTreeQueue);
        TreeNode run = null;
        while(bfsQueue.rear != null){
            GraphNode u = bfsQueue.dequeue();
            TreeNode treeNode = bfsTreeQueue.dequeue();
            Element<GraphNode> vNode = u.outNeighbors.head;
            while(vNode!= null){
                if (vNode.data.color == 0){
                    vNode.data.color = 1;
                    vNode.data.d = u.d + 1;
                    TreeNode bfsTreeNode = new TreeNode(treeNode,null,
                            null,vNode.data.getKey());
                    if(treeNode.leftChild == null){
                        treeNode.leftChild = bfsTreeNode;
                        }
                    else{
                        if(treeNode.leftChild.rightSibling == null) {
                            treeNode.leftChild.rightSibling = bfsTreeNode;
                            run = treeNode.leftChild.rightSibling;
                        }
                        else{
                            run.rightSibling = bfsTreeNode;
                            run = run.rightSibling;
                        }
                    }
                    bfsQueue.enqueue(vNode.data);
                    bfsTreeQueue.enqueue(bfsTreeNode);
                }
                vNode = vNode.next;
            }
            u.color = 2;
        }
        return new RootedTree(treeSource);
    }

    private TreeNode bfsInitialization(GraphNode source, Queue<GraphNode> qGraphNode,
                                   Queue<TreeNode> qTreeNode){
        Element<GraphNode> x = nodesInGraph.head;
        TreeNode bfsTreeSourceNode = new TreeNode(null,null,
                null,source.getKey());
        while(x != null){
            x.data.d = Integer.MAX_VALUE;
            x.data.color = 0;
            x = x.next;}
        source.color = 1;
        source.d = 0;
        qGraphNode.enqueue(source);
        qTreeNode.enqueue(bfsTreeSourceNode);
        return bfsTreeSourceNode;
    }
}
