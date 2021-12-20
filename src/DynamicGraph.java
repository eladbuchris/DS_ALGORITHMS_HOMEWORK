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
        if(node.outNeighbors.peek() == null && node.inNeighbors.head == null) {
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


    public GraphEdge insertEdge(GraphNode to, GraphNode from){
        GraphEdge newEdge = new GraphEdge(to, from);
        Element<GraphEdge> newElement = new Element<>(newEdge);
        to.addInNeighbor(from);
        from.addOutNeighbor(to);
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
        from.outNeighbors.L.listDelete(toElement);
        to.inNeighbors.listDelete(fromElement);
        this.edgesInGraph.listDelete(edge.linkedListElement);
    }

    public RootedTree bfs(GraphNode source){
        Queue<BFSNode> bfsQueue = new Queue<>();
        return null; // TODO : CHANGE IT
    }

    private void bfsInitialization(GraphNode source, Queue<BFSNode> q){
        BFSNode s = new BFSNode(source.getKey());
        Element<GraphNode> x = nodesInGraph.head;
        LinkedList<BFSNode> bfsNodes = new LinkedList<>();
        while(x != null){
            if(x.data == source){
                continue;
            }
            BFSNode v = new BFSNode(x.data.getKey());
            x = x.next;
        s.color = 1;
        s.d = 0;
        s.parent = null;
        q.enqueue(s);
        }
    }
}
