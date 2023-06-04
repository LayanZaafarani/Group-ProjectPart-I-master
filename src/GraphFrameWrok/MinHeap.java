/*
    Group 2 CPCS324 Poject 
*/
package GraphFrameWrok;

import java.util.ArrayList;

public class MinHeap {
   
    // attributes
    private final ArrayList<Edge> edges;
    private int size=0;

    public MinHeap(int capacity) {
        edges = new ArrayList<>(capacity);
    }

    public void add(Edge value) {
        edges.add(value);
        size++;
        heapifyUp(size - 1);
    }

    public Edge peek() {
        return edges.get(0);
    }

    public Edge poll() {
        Edge value = edges.get(0);
        edges.remove(0);
        size--;
        heapifyDown(0);
        return value;
    }

     private void heapifyUp(int index) {
        while (index > 0 && edges.get(index).getWeight() < edges.get((index - 1) / 2).getWeight()) {
            Edge temp = edges.get(index);
            edges.set(index, edges.get((index - 1) / 2));
            edges.set((index - 1) / 2, (Edge) temp);
            index = (index - 1) / 2;
        }
    }

     private void heapifyDown(int index) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int largest = index;

        if (leftChild < edges.size() && edges.get(leftChild).getWeight() < edges.get(largest).getWeight()) {
            largest = leftChild;
        }

        if (rightChild < edges.size() && edges.get(rightChild).getWeight() < edges.get(largest).getWeight()) {
            largest = rightChild;
        }

        if (largest != index) {
            Edge temp = edges.get(index);
            edges.set(index, edges.get(largest));
            edges.set(largest, (Edge) temp);
            heapifyDown(largest);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

}


