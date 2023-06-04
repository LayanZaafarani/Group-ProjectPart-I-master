/*
    Group 2 CPCS324 Poject 
*/
package GraphFrameWrok;

// imports
import java.util.List;
import java.util.Comparator;

public class KruskalAlg extends MSTAlgorithm {

    // attributes
    private final List<Edge> graphEdges;
    private final int noVertices;
    private int noOfEdges;

    public KruskalAlg(Graph graph) {
        // getting edges' list and vertices' number from graph
        this.graph = graph;
        this.graphEdges = graph.getEdgesList();
        this.noVertices = graph.getVerticesNo();

        // sorting the edge list
        graphEdges.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.getWeight() - o2.getWeight();
            }
        });

        // start computing the minimum spanning tree
        computeMST();

        // display the result of the minimum spanning tree
        displayResultingMST();
    }

    // computes the minimum spanning tree using Kruskal's algorithm
    public void computeMST() {
        int j = 0;
        noOfEdges = 0;

        // allocate memory for creating subsets as the number of vertices
        Subset subsets[] = new Subset[noVertices];

        // create subsets for every vertex as single element subset
        for (int i = 0; i < noVertices; i++) {
            subsets[i] = new Subset(i, 0);
        }

        // loop until number of edges is equal to number of vertices - 1
        while (noOfEdges < noVertices - 1) {
            
            // get edge (don't forget edges are ordered according to weights so it will always get the next smallest weighted edge)
            Edge nextEdge = graphEdges.get(j);

            // get the parent of both source and destination vertices of the edge
            int x = findRoot(subsets, getVertexNo(nextEdge.getSource()));
            int y = findRoot(subsets, getVertexNo(nextEdge.getDestination()));

            // if both parents are different it means they are in different subsets which means the edge will NOT cause a cycle 
            if (x != y) {
                // save the edge into the MST result list
                MSTResultList.add(nextEdge);

                // merge the two subsets of source and destination to make them have the same parent
                union(subsets, x, y);

                // increment number of edges found
                noOfEdges++;
            }

            // increment j to loop through all edges
            j++;
        }
    }

    // return number of vertex from the vertex's label
    private static int getVertexNo(Vertex v) {
        if (v.getLabel().charAt(0) == 'O') {
            return Integer.parseInt(v.getLabel().substring(1)) - 1;
        }
        return Integer.parseInt(v.getLabel()) - 1;
    }

    // the union method combines the source and destination subsets
    private static void union(Subset[] subsets, int x, int y) {

        // find the parents of x and y
        int rootX = findRoot(subsets, x);
        int rootY = findRoot(subsets, y);

        // find the subset with the lowest rank to be combined with the highest rank
        // rank determines which subset has a higher height (imagine it like a tree)
        if (subsets[rootY].rank < subsets[rootX].rank) {
            subsets[rootY].parent = rootX;
        } else if (subsets[rootX].rank < subsets[rootY].rank) {
            subsets[rootX].parent = rootY;
        } else {
            subsets[rootY].parent = rootX;
            subsets[rootX].rank++;
        }
    }

    // find parent of a set method
    private static int findRoot(Subset[] subsets, int i) {
        if (subsets[i].parent == i)
            return subsets[i].parent;

        subsets[i].parent = findRoot(subsets, subsets[i].parent);
        return subsets[i].parent;
    }

    //print results method
    @Override
    public void displayResultingMST() {
        System.out.println(
                "\nThe phone network (minimum spanning tree) generated by Kruskal algorithm is as follows: ");
        int minCost = 0;
        for (int i = 0; i < noOfEdges; i++) {
            MSTResultList.get(i).displayInfo();
            minCost += MSTResultList.get(i).getWeight();
        }
        System.out.println("The cost of designed phone network: " + minCost + "\n");
    }
}
