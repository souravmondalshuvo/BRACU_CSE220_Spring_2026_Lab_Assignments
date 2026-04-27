public class Task2Tester {
    
    public static void printArray(int[] array) {
        
        System.out.print("[");

        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i]);

            if(i < array.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }

    public static void main(String[] args) {
        
        
        MaxHeap heap_object = new MaxHeap(5);

        System.out.println("===== Test 1: Insert and Peek =====");
        
        heap_object.insert(10);
        heap_object.insert(20);
        heap_object.insert(5);
        heap_object.insert(30);
        heap_object.insert(15);

        System.out.print("Heap Array: ");
        printArray(heap_object.getHeapArray());

        System.out.println("Peek: " + heap_object.peek());
        System.out.println("Expected Peek: 30");

        System.out.println();

        System.out.println("===== Test 2: Extract Max =====");

        System.out.println("Extracted: " + heap_object.extractMax());
        System.out.println("Expected Extracted: 30");

        System.out.print("Heap after extract: ");
        printArray(heap_object.getHeapArray());

        System.out.println("Peek after extract: " + heap_object.peek());
        System.out.println("Expected Peek: 20");

        System.out.println();


        System.out.println("===== Test 3: Capacity =====");

        heap_object.insert(40);

        System.out.print("Heap after inserting 40: ");
        printArray(heap_object.getHeapArray());

        System.out.println("Peek after inserting 40: " + heap_object.peek());
        System.out.println("Expected Peek: 40");

        heap_object.insert(100);

        System.out.println();


        System.out.println("===== Test 4: Extract All =====");

        System.out.print("Extracting all elements: ");

        while (!heap_object.isEmpty()) {
            System.out.print(heap_object.extractMax() + " ");
        }

        System.out.println();
        System.out.println("Expected order: 40 20 15 10 5");

        System.out.println();


        System.out.println("===== Test 5: Empty Heap =====");

        System.out.println("Is empty: " + heap_object.isEmpty());
        System.out.println("Expected: true");

        System.out.println("Peek empty heap: " + heap_object.peek());
        System.out.println("Expected: null");

        System.out.println("Extract from empty heap: " + heap_object.extractMax());
        System.out.println("Expected: null");
    }
}
