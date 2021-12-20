public class GraphNode {

    Stack<GraphNode> outNeighbors;
    LinkedList<GraphNode> inNeighbors;
    Element<GraphNode> linkedListElement;
    private final int key;

    public GraphNode(int key){
        this.outNeighbors = new Stack<>();
        this.inNeighbors = new LinkedList<>();
        this.key = key;
    }
    public int getKey(){
        return this.key;
    }

    public int getOutDegree(){
        int outDegree = 0;
        Element<GraphNode> x = outNeighbors.peek();
        while(x != null){
            outDegree += 1;
            x = x.next;
        }
        return outDegree;
    }
    public int getInDegree(){
        int inDegree = 0;
        Element<GraphNode> x = inNeighbors.head;
        while(x != null){
            inDegree += 1;
            x = x.next;
        }
        return inDegree;
    }
    public void addInNeighbor(GraphNode neighbor){
        inNeighbors.listInsert(neighbor);
    }
    public void addOutNeighbor(GraphNode neighbor){
        outNeighbors.push(neighbor);
    }
}
