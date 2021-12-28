import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) throws IOException {
        DynamicGraph G = new DynamicGraph();
        GraphNode[] nodes = new GraphNode[10];
        GraphEdge[] edges = new GraphEdge[5];
        for(int i = 0;i<10;i++){
            nodes[i] = G.insertNode(i);}
        G.insertEdge(nodes[0],nodes[1]);
        G.insertEdge(nodes[0],nodes[2]);
        G.insertEdge(nodes[1],nodes[3]);
        G.insertEdge(nodes[3],nodes[4]);
        G.insertEdge(nodes[2],nodes[4]);
        RootedTree T = G.bfs(nodes[0]);
        DataOutputStream output = new DataOutputStream(new FileOutputStream("C:\\Users\\bboyc\\IdeaProjects\\DS_ALGORITHMS_HOMEWORK\\src/please.txt"));
        T.printByLayer(output);
        output.flush();
    }
}
