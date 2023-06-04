/*
    Group 2 CPCS324 Poject 
*/
package PhoneNetworkApp;

// imports
import GraphFrameWrok.KruskalAlg;
import GraphFrameWrok.MHPrimAlg;
import java.io.FileNotFoundException;
import java.io.*;

public class PhoneNetworkApp {

    public static void main(String[] args) throws FileNotFoundException {

        // create a BluePrintGraphs object 
        BluePrintsGraph PhLNetwork2 = new BluePrintsGraph();

        // read graph from file
        // File f = new File("DI.txt");
        // PhLNetwork2.readGraphFromFile(f);

        // make graph with number of vertices and number of edges
        PhLNetwork2.makeGraph(20, 20);

        // print the graph
        PhLNetwork2.printGraph();
        System.out.println("");
        
        // apply Prim's MinHeap algorithm to the graph
        MHPrimAlg mhPrimAlg = new MHPrimAlg(PhLNetwork2);

        // apply Kruskal's algorithm to the graph
        KruskalAlg kruskalAlg = new KruskalAlg(PhLNetwork2);
    }

}
