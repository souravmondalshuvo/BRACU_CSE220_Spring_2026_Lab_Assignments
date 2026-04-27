public class MaxHeap {

    private Integer[] heap;
    private int size;
    private int capacity;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.heap = new Integer[capacity];
        this.size = 0;
    }

    public void insert(int value) {
        
        if(size >= capacity) {
            System.out.println("Heap is full");
            return;
        }

        heap[size] = value;
        heapifyUp(size);
        size++;
    }

    public Integer extractMax() {
        
        if (isEmpty()) {
            return null;
        }

        Integer max = heap[0];

        heap[0] = heap[size - 1];
        heap[size - 1] = null;
        size--;

        if (size > 0) {
            heapifyDown(0);
        }

        return max;
    }

    public Integer peek() {
        if (isEmpty()) {
            return null;
        }

        return heap[0];
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;

            if (heap[parent] < heap[index]) {
                Integer temp = heap[parent];
                heap[parent] = heap[index];
                heap[index] = temp;

                index = parent;
            } else {
                break;
            }
        }
    }

    private void heapifyDown(int index) {
        
        while (index < size) {
            int leftChild = index * 2 + 1;
            int rightChild = index * 2 + 2;
            int largestChild = index;

            if (leftChild < size && heap[leftChild] > heap[largestChild]) {
                largestChild = leftChild;
            }

            if (rightChild < size && heap[rightChild] > heap[largestChild]) {
                largestChild = rightChild;
            }

            if (largestChild != index) {
                Integer temp = heap[index];
                heap[index] = heap[largestChild];
                heap[largestChild] = temp;

                index = largestChild;
            } else {
                break;
            }
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int[] getHeapArray() {
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = heap[i];
        }

        return arr;
    }
}