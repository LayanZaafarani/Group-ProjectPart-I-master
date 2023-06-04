/*
    Group 2 CPCS324 Poject 
*/
package GraphFrameWrok;

// imports
import java.util.*;
import java.io.*;

public class Graph {

    // number of vertices of the graph
    private int verticesNo;

    // number of edges of the graph
    private int edgeNo;

    // set to true if the graph is directed graph, and set to false if the graph is undirected
    private boolean isDigraph;

    // list/vectorrepresenting the list of vertices of a graph.
    private List<Vertex> vertices;

    // list of all edges of a graph.
    private List<Edge> edges = new ArrayList<>();

    // Return Edge list for kruskal algorithm
    public List<Edge> getEdgesList(){
        return edges;
    }

    //constructor  
    public Graph() {

        // Initialize the number of vertices and edges to 0.
        this.verticesNo = 0;
        this.edgeNo = 0;

        // set Graph UnDigraph
        this.isDigraph = false;

        // Create a list to store the vertices.
        this.vertices = new ArrayList<>();

    }

    // abstract create edge method
    public Edge createEdge(Vertex source, Vertex destination, int weight) {
        return null;
    }
    
    // abstract create vertex method
    public Vertex createVertex(String label) {
        return null;
    }

    // add edge method
    public void addEdge(Vertex source, Vertex destination, int weight) {
        // create edge object 
        Edge edge1 = createEdge(source, destination, weight);
        // add an adjacent vertex
        source.addAdjacentVertex(edge1);

        // If the graph is not directed, also add the edge in the opposite direction.
        if (!isDigraph) {
            Edge edge2 = createEdge(destination, source, weight);
            // add an adjacent vertex
            destination.addAdjacentVertex(edge2); // 

            this.edgeNo++;
        }
        this.edgeNo++;
    }

    // make graph method 
    public void makeGraph(int verticesNo, int edgeNo) {
        boolean Connected;
        
        // Set vertices number
        setVerticesNo(verticesNo);

        // Randomly initialize the vertices' labels
        for (int i = 0; i < verticesNo; i++) {
            String vertexLabel = i + 1 + "";
            vertices.add(createVertex(vertexLabel));
        }
        int s, t, weight;
        do {
            
            // Create edges that connects the created vertices randomly and assigning them random weights
            for (int i = 0; i < edgeNo; i++) {
                // prevent adding an edge between a vertex and itself
                do {
                    s = (int) (Math.random() * verticesNo);
                    t = (int) (Math.random() * verticesNo);
                } while (s == t);
                // make sure there is no duplicate edges
                Vertex sourceVertex = vertices.get(s);
                Vertex targetVertex = vertices.get(t);
                String label = targetVertex.getLabel();

                if (!sourceVertex.edgeExist(label)) {
                    weight = (int) (Math.random() * 40) + 1;
                    addEdge(sourceVertex, targetVertex, weight);
                } else {
                    i--;
                }
            }
            // check connectivity
            Connected = isConnected();
            // incase graph is not connected we need to delete all edges of vertices
            // and set visited to false
            if (!Connected) {
                for (int i = 0; i < verticesNo; i++) {
                    vertices.get(i).setVisited(false);
                    vertices.get(i).getAdjacentVertices().clear();
                }
            }
        } while (!Connected);

        // set all vertices setVisited to false
        for (int i = 0; i < verticesNo; i++) {
            vertices.get(i).setVisited(false);
        }

        // Add all edges in the graph into a edges list 
        for (int i = getVertices().size() - 1; i >= 0; i--) {
            for (int j = getVertices().get(i).getAdjacentVertices().size() - 1; j >= 0; j--) {
                this.edges.add(getVertices().get(i).getAdjacentVertices().get(j));
            }
        }
    }

    // method to check if the graph is connected
    public boolean isConnected() {
        // Start the DFS from vertex 0
        DFS(vertices.get(0));

        // Check if all the vertices are visited
        // Set connected to False if one node is unvisited
        boolean connected = true;

        for (int i = 0; i < vertices.size(); i++) {
            if (!vertices.get(i).isVisited()) {
                connected = false;
                break;
            }
        }
        return connected;
    }

    // depth first search method
    public void DFS(Vertex source) {
        // Mark the vertex visited as True
        source.setVisited(true);

        // Travel the adjacent neighbours
        for (int i = 0; i < source.getAdjacentVertices().size(); i++) {

            Edge neighbour = source.getAdjacentVertices().get(i);

            if (!neighbour.getDestination().isVisited()) {
                // Call DFS from neighbour
                DFS(neighbour.getDestination());
            }
        }
    }

    // read graph from file method 
    public void readGraphFromFile(File fileName) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(fileName)) {

            // check if the graph is directed or not
            if ("0".equals(scanner.next())) {
                isDigraph = false;
            }

            // set vertices and edges number
            verticesNo = Integer.parseInt(scanner.next());
            edgeNo = Integer.parseInt(scanner.next());
            scanner.nextLine();

            // start reading the graph
            while (scanner.hasNext()) {
                int source = ((int) scanner.next().charAt(0)) - 64;
                int destination = ((int) scanner.next().charAt(0)) - 64;

                // add vertices only if not added previously 
                if (vertices.size() < source) {
                    vertices.add(createVertex(source + ""));
                }
                if (vertices.size() < destination) {
                    vertices.add(createVertex(destination + ""));
                }

                // set weight
                int weight = Integer.parseInt(scanner.next());

                // add edge
                addEdge(vertices.get(source - 1), vertices.get(destination - 1), weight);
            }

            // Add all edges in the graph into a edges list 
            for (int i = getVertices().size() - 1; i >= 0; i--) {
                for (int j = getVertices().get(i).getAdjacentVertices().size() - 1; j >= 0; j--) {
                    this.edges.add(getVertices().get(i).getAdjacentVertices().get(j));
                }
            }
        }
    }
   
    // print graph method
    public void printGraph() {
        vertices.forEach((vertex) -> {
            vertex.displayInfo();
        });
    }

    // add vertex method
    public void addVertex(Vertex vertex) {
        this.vertices.add(vertex);

        this.verticesNo++;
    }

    // get number of vertices
    public int getVerticesNo() {
        return verticesNo;
    }

    // set vertices number
    public void setVerticesNo(int verticesNo) {
        this.verticesNo = verticesNo;
    }

    // get number of edges
    public int getEdgeNo() {
        return edgeNo;
    }

    // set number of edges
    public void setEdgeNo(int edgeNo) {
        this.edgeNo = edgeNo;
    }

    // return whether the graph is directed or not
    public boolean isDigraph() {
        return isDigraph;
    }

    // set true if the graph is directed, false for undirected
    public void setDigraph(boolean isDigraph) {
        this.isDigraph = isDigraph;
    }

    // get vertices list
    public List<Vertex> getVertices() {
        return vertices;
    }

    // set vertices list
    public void setVertices(List<Vertex> vertices) {
        this.vertices = vertices;
    }

    // checks if all vertices are visited method
    public boolean AllVisited() {
        for (int i = 0; i < vertices.size(); i++) {
            if (!vertices.get(i).isVisited()) {
                return false;

            }

        }
        return true;
    }

}
