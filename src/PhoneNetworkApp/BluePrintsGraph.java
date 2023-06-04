/*
    Group 2 CPCS324 Poject 
*/
package PhoneNetworkApp;

// imports
import GraphFrameWrok.Edge;
import GraphFrameWrok.Vertex;

public class BluePrintsGraph extends GraphFrameWrok.Graph{

    // create a new line edge
    @Override
    public Edge createEdge(Vertex source, Vertex destination, int weight) {
        return new Line(source, destination, weight);
    }

    // create a new office vertex
    @Override
    public Vertex createVertex(String label) {
        Vertex Of = new Office(label);
        Of.setLabel("0" + label);
        return Of;
    }
}
