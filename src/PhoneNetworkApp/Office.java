/*
    Group 2 CPCS324 Poject 
*/
package PhoneNetworkApp;

// imports 
import GraphFrameWrok.Vertex;

public class Office extends Vertex {

  public Office(String label) {
        super(label);
    }

    // override a the display info in vertex
    @Override
    public void displayInfo() {
      System.out.print("\nVertex {" +
              "label = " + label +
              ", isVisited = " + isVisited +
              ", adjacentVertices = \n");
      adjacentVertices.forEach((adjacentVertice) -> {
          adjacentVertice.displayInfo();
      });
  }
  
}
