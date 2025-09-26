import java.util.ArrayList;

public class MaxHeap {
    private ArrayList<Integer> heap;

    public MaxHeap() {
        this.heap = new ArrayList<>();
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);

        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    private void heapifyUp(int index) {
        int parent = parent(index);
        if (index > 0 && heap.get(index) > heap.get(parent)) {
            swap(index, parent);
            heapifyUp(parent);
        }
    }

    private void heapifyDown(int index) {
        int left = leftChild(index);
        int right = rightChild(index);
        int largest = index;

        if (left < heap.size() && heap.get(left) > heap.get(largest)) {
            largest = left;
        }

        if (right < heap.size() && heap.get(right) > heap.get(largest)) {
            largest = right;
        }

        if (largest != index) {
            swap(index, largest);
            heapifyDown(largest);
        }
    }

    public void insert(int key) {
        heap.add(key);
        heapifyUp(heap.size() - 1);
    }

    public int extractMax() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        if (heap.size() == 1) {
            return heap.remove(0);
        }
        int max = heap.get(0);
        heap.set(0, heap.remove(heap.size() - 1));
        heapifyDown(0);
        return max;
    }

    public int getMax() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap.get(0);
    }

    public void delete(int key) {
        int index = heap.indexOf(key);
        if (index == -1) {
            throw new IllegalStateException("Key not found");
        }
        heap.set(index, heap.get(heap.size() - 1));

        heap.remove(heap.size() - 1);
        if (index < heap.size()) {
            heapifyDown(index);
            heapifyUp(index);
        }
    }

    public void printHeap() {
        System.out.println(heap);
    }

    public static void main(String[] args) {
        System.out.println("Name:Yogesh Rathod \nRoll No: C24092\n");
        MaxHeap heap = new MaxHeap();
        heap.insert(11);
        heap.insert(22);
        heap.insert(5);
        heap.insert(32);

        heap.printHeap();

        System.out.println("Maximum: " + heap.getMax());

        System.out.println("Extract Max: " + heap.extractMax());
        heap.printHeap();

        heap.delete(22);
        heap.printHeap();
    }
}
