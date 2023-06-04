/*
    Group 2 CPCS324 Poject 
*/
package GraphFrameWrok;

public class Min_Heap {

    // attributes
    public HeapNode[] H;
    public int size;
    public int maxsize;

    public Min_Heap(int maxsize) {
        this.size = 1;
        this.maxsize = maxsize;
        H = new HeapNode[this.maxsize + 1];
    }

    public void insert(Vertex vertex, int key, Vertex parent) {
        H[size] = new HeapNode(vertex, key, parent);
        int i = size;
        if (size != maxsize) {
            size++;
        }
        heapify_up(i);
    }

    public void UpdateKey(int key, int i) {
        H[i].key = key;
        heapify_up(i);
    }

    private void heapify_up(int i) {
        while (i > 1 && H[i].getKey() < H[i / 2].getKey()) {
            HeapNode temp = H[i];
            H[i] = H[i / 2];
            H[i / 2] = temp;
            i /= 2;
        }
    }

    public HeapNode extract_min() {
        HeapNode ret = H[1];
        H[1] = H[size];
        size--;
        if (size >= 1) {
            heapify_down(1);
        }
        return ret;
    }

    private void heapify_down(int i) {
        int j = 2 * i;
        if (j > size) {
            return;
        }
        int minChild = j;
        if (j + 1 <= size && H[j + 1].getKey() < H[j].getKey()) {
            minChild = j + 1;
        }
        if (H[i].getKey() > H[minChild].getKey()) {
            HeapNode temp = H[i];
            H[i] = H[minChild];
            H[minChild] = temp;
            heapify_down(minChild);
        }
    }

    public void decrease_key(int v, int key_value) {
        H[v].setKey(key_value);
        heapify_up(v);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int vertexIndex(Vertex vertex) {
        int index = -1;
        for (int i = 1; i <= size; i++) {
            if (H[i].vertex == vertex) {
                index = i;
                break;
            }
        }
        return index;
    }
}
