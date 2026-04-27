public class MinHeap {

    private Integer[] heap;
    private int size;
    private int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.heap = new Integer[capacity];
        this.size = 0;
    }
    public void insert(int value) {
        /*
         Steps:
         1. Check if heap is full
         2. Insert at end
         3. Heapify up
        */
       

        // TODO: Implement insert method

        if(size >= capacity){
            System.out.println("Heap is full");
            return;
        }

        heap[size] = value;
        heapifyUp(size);
        size++;
    }

    public Integer extractMin() {
        /*
         Steps:
         1. Handle empty heap
         2. Store root
         3. Move last element to root
         4. Reduce size
         5. Heapify down
        */
        // TODO: Implement extraction logic

        if(isEmpty()) {
            return null;
        }
        
        int min = heap[0];
        heap[0] = heap[size - 1];
        heap[size - 1] = null;
        size--;

        if(size > 0) {
            heapifyDown(0);
        }
        
        return min;
    }

    public Integer peek() {
         /*
         Steps:
         1. Handle empty heap
         2. Return root value
        */
       // TODO: Implement peek

       if(isEmpty()) {
            return null;
       }

       return heap[0];
    }

    // --------------------------
    // Heapify operations
    // --------------------------
    private void heapifyUp(int index) {
        /*
         Move element up while parent is greater
        */
        // TODO: Implement heapify up

        while(index > 0) {
            int parent = (index - 1) / 2;

            if(heap[parent] > heap[index]) {
                Integer temp = heap[parent];
                heap[parent] = heap[index];
                heap[index] = temp;

                index = parent;
            }
            else {
                break;
            }
        }
    }
    private void heapifyDown(int index) {
        /*
         Move element down by comparing with children
        */
        // TODO: Implement heapify down

        while(index < size) {
            int leftChild = index * 2 + 1;
            int rightChild = index * 2 + 2;
            int smallestChild = index;

            if(leftChild < size && heap[leftChild] < heap[smallestChild]) {
                smallestChild = leftChild;
            }

            if(rightChild < size && heap[rightChild] < heap[smallestChild]) {
                smallestChild = rightChild;
            }

            if(smallestChild != index) {
                Integer temp = heap[index];
                heap[index] = heap[smallestChild];
                heap[smallestChild] = temp;

                index = smallestChild;
            }
            else {
                break;
            }
        }
    }

    public boolean isEmpty(){
        // TODO: Implement isEmpty

        return size == 0;
    }

    public int[] getHeapArray() {

        int[] arr = new int[size];

        for(int i = 0; i < size; i++) {
            arr[i] = heap[i];
        }

        return arr;
    }
}