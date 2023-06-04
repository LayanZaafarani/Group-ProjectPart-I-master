/*
    Group 2 CPCS324 Poject 
*/
package GraphFrameWrok;

public class HeapNode {

    // attributes
    public Vertex vertex;
    public int key;
    public Vertex parent;

    public HeapNode(Vertex vertex, int key, Vertex parent) {
        this.vertex = vertex;
        this.key = key;
        this.parent = parent;
    }

    public Vertex getVertex() {
        return vertex;
    }

    public void setVertex(Vertex vertex) {
        this.vertex = vertex;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Vertex getParent() {
        return parent;
    }

    public void setParent(Vertex parent) {
        this.parent = parent;
    }
    
}
