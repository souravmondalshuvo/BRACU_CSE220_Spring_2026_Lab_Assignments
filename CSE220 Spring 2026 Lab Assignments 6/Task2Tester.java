public class Task2Tester {

    static final String GREEN = "\u001B[32m";
    static final String RED = "\u001B[31m";
    static final String CYAN = "\u001B[36m";
    static final String YELLOW = "\u001B[33m";
    static final String RESET = "\u001B[0m";

    public static void printArray(int[] arr) {
        System.out.print("[");

        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);

            if(i < arr.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }

    public static void main(String[] args) {

        printHeader("TASK 2 TESTER - MAX HEAP");

        MaxHeap heap_object = new MaxHeap(5);

        printSection("Test 1: Insert and Peek");

        heap_object.insert(10);
        heap_object.insert(20);
        heap_object.insert(5);
        heap_object.insert(30);
        heap_object.insert(15);

        checkArray("Heap after inserts", heap_object.getHeapArray(), new int[]{30, 20, 5, 10, 15});
        checkInteger("Peek", heap_object.peek(), 30);


        printSection("Test 2: Extract Max");

        checkInteger("Extract Max", heap_object.extractMax(), 30);
        checkArray("Heap after extract", heap_object.getHeapArray(), new int[]{20, 15, 5, 10});
        checkInteger("Peek after extract", heap_object.peek(), 20);


        printSection("Test 3: Capacity Check");

        heap_object.insert(40);

        checkArray("Heap after inserting 40", heap_object.getHeapArray(), new int[]{40, 20, 5, 10, 15});
        checkInteger("Peek after inserting 40", heap_object.peek(), 40);

        System.out.println(YELLOW + "Trying to insert 100 into full heap..." + RESET);
        heap_object.insert(100);
        checkInteger("Peek should still remain 40", heap_object.peek(), 40);


        printSection("Test 4: Extract All");

        System.out.print("Extracted order: ");
        int[] extracted = new int[5];

        int index = 0;
        
        while(!heap_object.isEmpty()) {
            extracted[index] = heap_object.extractMax();
            System.out.print(extracted[index] + " ");
            index++;
        }

        System.out.println();
        checkArray("Expected descending order", extracted, new int[]{40, 20, 15, 10, 5});


        printSection("Test 5: Empty Heap");

        checkBoolean("Is empty", heap_object.isEmpty(), true);
        checkInteger("Peek empty heap", heap_object.peek(), null);
        checkInteger("Extract from empty heap", heap_object.extractMax(), null);

        printFooter();
    }

    public static void printHeader(String title) {
        System.out.println();
        System.out.println(CYAN + "==================================================" + RESET);
        System.out.println(CYAN + "              " + title + RESET);
        System.out.println(CYAN + "==================================================" + RESET);
    }

    public static void printSection(String title) {
        System.out.println();
        System.out.println(YELLOW + "--------------------------------------------------" + RESET);
        System.out.println(YELLOW + title + RESET);
        System.out.println(YELLOW + "--------------------------------------------------" + RESET);
    }

    public static void printFooter() {
        System.out.println();
        System.out.println(CYAN + "==================================================" + RESET);
        System.out.println(CYAN + "                 TESTING COMPLETE" + RESET);
        System.out.println(CYAN + "==================================================" + RESET);
    }

    public static void checkInteger(String testName, Integer actual, Integer expected) {
        System.out.println(testName);
        System.out.println("Actual   : " + actual);
        System.out.println("Expected : " + expected);

        if(actual == expected || actual != null && actual.equals(expected)) {
            System.out.println(GREEN + "Result   : PASS" + RESET);
        }else {
            System.out.println(RED + "Result   : FAIL" + RESET);
        }

        System.out.println();
    }

    public static void checkBoolean(String testName, boolean actual, boolean expected) {
        System.out.println(testName);
        System.out.println("Actual   : " + actual);
        System.out.println("Expected : " + expected);

        if(actual == expected) {
            System.out.println(GREEN + "Result   : PASS" + RESET);
        }else {
            System.out.println(RED + "Result   : FAIL" + RESET);
        }

        System.out.println();
    }

    public static void checkArray(String testName, int[] actual, int[] expected) {
        System.out.println(testName);

        System.out.print("Actual   : ");
        printArray(actual);

        System.out.print("Expected : ");
        printArray(expected);

        if(arrayEquals(actual, expected)) {
            System.out.println(GREEN + "Result   : PASS" + RESET);
        }else {
            System.out.println(RED + "Result   : FAIL" + RESET);
        }

        System.out.println();
    }

    public static boolean arrayEquals(int[] arr1, int[] arr2) {
        if(arr1.length != arr2.length) {
            return false;
        }

        for(int i = 0; i < arr1.length; i++) {
            
            if(arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }
}