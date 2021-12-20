public class GraphEdge {
    Element<GraphEdge> linkedListElement;
    GraphNode edge[] = new GraphNode[2];
    Element<GraphNode> fromElement;
    Element<GraphNode> toElement;

    public GraphEdge(GraphNode from, GraphNode to){
        from.addOutNeighbor(to);
        this.toElement = from.outNeighbors.peek();
        to.addInNeighbor(from);
        this.fromElement = to.inNeighbors.head;
        this.edge[0] = from;
        this.edge[1] = to;

    }
}
