public class Task3Tester {

    static final String GREEN = "\u001B[32m";
    static final String RED = "\u001B[31m";
    static final String CYAN = "\u001B[36m";
    static final String YELLOW = "\u001B[33m";
    static final String RESET = "\u001B[0m";

    public static void main(String[] args) {

        printHeader("TASK 3 TESTER - OUT-OF-PLACE HEAP SORT");

        printSection("Test 1: Normal Unsorted Array");

        int[] arr1 = {10, 3, 5, 1, 20, 8};

        System.out.print("Before sorting: ");
        printArray(arr1);

        MinHeap.outPlaceHeapsort(arr1);

        checkArray("After sorting", arr1, new int[]{1, 3, 5, 8, 10, 20});


        printSection("Test 2: Already Sorted Array");

        int[] arr2 = {1, 2, 3, 4, 5};

        System.out.print("Before sorting: ");
        printArray(arr2);

        MinHeap.outPlaceHeapsort(arr2);

        checkArray("After sorting", arr2, new int[]{1, 2, 3, 4, 5});


        printSection("Test 3: Reverse Sorted Array");

        int[] arr3 = {9, 7, 5, 3, 1};

        System.out.print("Before sorting: ");
        printArray(arr3);

        MinHeap.outPlaceHeapsort(arr3);

        checkArray("After sorting", arr3, new int[]{1, 3, 5, 7, 9});


        printSection("Test 4: Duplicate Values");

        int[] arr4 = {4, 2, 4, 1, 2, 9};

        System.out.print("Before sorting: ");
        printArray(arr4);

        MinHeap.outPlaceHeapsort(arr4);

        checkArray("After sorting", arr4, new int[]{1, 2, 2, 4, 4, 9});


        printSection("Test 5: Negative Numbers");

        int[] arr5 = {-3, 10, 0, -1, 5};

        System.out.print("Before sorting: ");
        printArray(arr5);

        MinHeap.outPlaceHeapsort(arr5);

        checkArray("After sorting", arr5, new int[]{-3, -1, 0, 5, 10});


        printFooter();
    }

    public static void printHeader(String title) {
        System.out.println();
        System.out.println(CYAN + "==================================================" + RESET);
        System.out.println(CYAN + "       " + title + RESET);
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

    public static void checkArray(String testName, int[] actual, int[] expected) {
        System.out.println(testName);

        System.out.print("Actual   : ");
        printArray(actual);

        System.out.print("Expected : ");
        printArray(expected);

        if (arrayEquals(actual, expected)) {
            System.out.println(GREEN + "Result   : PASS" + RESET);
        } else {
            System.out.println(RED + "Result   : FAIL" + RESET);
        }

        System.out.println();
    }

    public static boolean arrayEquals(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }

    public static void printArray(int[] arr) {
        System.out.print("[");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);

            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }
}