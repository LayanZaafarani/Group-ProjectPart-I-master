/*
    Group 2 CPCS324 Poject 
*/
package GraphFrameWrok;

// imports
import java.util.ArrayList;
import java.util.List;

public abstract class MSTAlgorithm {

    // The list of edges in the minimum spanning tree
    protected List<Edge> MSTResultList = new ArrayList<>();

    // the graph
    protected Graph graph; 

    // The abstract function to display the minimum spanning tree
    public abstract void displayResultingMST();

}
