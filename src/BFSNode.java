public class BFSNode {
    int color; // 0 = white, 1 = black
    int d;
    BFSNode parent;
    int key;

    public BFSNode(int key){
        this.key = key;
        this.color = 0;
        this.d = Integer.MAX_VALUE;
        this.parent = null;
    }
}
