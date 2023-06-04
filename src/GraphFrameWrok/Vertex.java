/*
    Group 2 CPCS324 Poject 
*/
package GraphFrameWrok;

// imports
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Vertex {

    // attributes
    public String label;
    public boolean isVisited;
    public List<Edge> adjacentVertices;
   

    public Vertex(String label) {
        this.label = label;
        this.isVisited = false;
        this.adjacentVertices = new ArrayList<>();
    }

   
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }

    // get and sort adjacent vertices edges according to weights 
    public List<Edge> getAdjacentVertices() {
        Collections.sort(adjacentVertices, (e1, e2) -> e1.getWeight() - e2.getWeight());
        return adjacentVertices;
    }

    public int getNoAdjacentVertices() {
        return adjacentVertices.size();
    }

    public void setAdjacentVertices(List<Edge> adjacentVertices) {
        this.adjacentVertices = adjacentVertices;
    }

    public void addAdjacentVertex(Edge edge) {
        adjacentVertices.add(edge);
    }

    // check if the edge exist in the adjancency list
    public boolean edgeExist(String d) {
        for (Edge adjacentVertice : adjacentVertices) {
            if (adjacentVertice.getDestination().getLabel().equalsIgnoreCase(d)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return label;
    }

    public void displayInfo() {
        
    }

}
