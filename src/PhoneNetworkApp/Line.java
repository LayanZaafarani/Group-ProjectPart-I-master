/*
    Group 2 CPCS324 Poject 
*/
package PhoneNetworkApp;

// imports
import GraphFrameWrok.Edge;
import GraphFrameWrok.Vertex;

public class Line extends Edge {

    // ILength attribte that is equal to the weight of edge multiplied by 5
    private int ILength;
   
    public Line(Vertex source, Vertex destination, int weight) {
        super(source, destination, weight);
        this.ILength = weight * 5;
    }
   
    // override a the display info in edge
    @Override
    public void displayInfo() {
        System.out.println("Office No. " 
        + (char)(Integer.parseInt(source.getLabel().substring(1))+64) 
        + " - Office No. " 
        + (char)(Integer.parseInt(destination.getLabel().substring(1))+64) 
        + " : Line lenght: " + ILength);
    }


}
    
