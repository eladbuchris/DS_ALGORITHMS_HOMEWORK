public class GraphNode {

    LinkedList<GraphNode> outNeighbors;
    LinkedList<GraphNode> inNeighbors;
    Element<GraphNode> linkedListElement;
    private final int key;
    int d;
    int color; // 0 = white, 1 = grey, 2 = black

    public GraphNode(int key){
        this.outNeighbors = new LinkedList<>();
        this.inNeighbors = new LinkedList<>();
        this.key = key;
    }
    public int getKey(){
        return this.key;
    }

    public int getOutDegree(){
        int outDegree = 0;
        Element<GraphNode> x = outNeighbors.head.data.linkedListElement;
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
        outNeighbors.listInsert(neighbor);
    }
}
