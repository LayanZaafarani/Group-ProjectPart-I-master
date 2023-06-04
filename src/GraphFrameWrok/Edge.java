/*
    Group 2 CPCS324 Poject 
*/
package GraphFrameWrok;

public class Edge {

    // attributes
    public Vertex source;
    public Vertex destination;
    public int weight;

    // edges has a source vertex and a destination vertex and a weight
    public Edge(Vertex source, Vertex destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public Vertex getSource() {
        return source;
    }

    public void setSource(Vertex source) {
        this.source = source;
    }

    public Vertex getDestination() {
        return destination;
    }

    public void setDestination(Vertex destination) {
        this.destination = destination;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    // abstract method
    public void displayInfo() {
        
    }
}