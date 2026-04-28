public class Task5Tester {

    public static String GREEN = "\u001B[32m";
    public static String RED = "\u001B[31m";
    public static String CYAN = "\u001B[36m";
    public static String YELLOW = "\u001B[33m";
    public static String RESET = "\u001B[0m";

    public static void main(String[] args) {

        printHeader("TASK 5 TESTER - TOP K LARGEST ELEMENTS");

        testSampleCase();
        testKEqualsOne();
        testAllElements();
        testDuplicateValues();
        testNegativeValues();
        printFooter();
    }

    // --------------------------
    // Test 1: Sample Case
    // --------------------------
   
    private static void testSampleCase() {
        printSection("Test 1: Sample Case");

        int[] nums = {4, 10, 2, 8, 6, 7};
        int k = 3;

        int[] expected = {10, 8, 7};
        int[] actual = Task5.topKLargest(nums, k);

        System.out.print("Input Array: ");
        printArray(nums);
        System.out.println("k          : " + k);

        checkArray("Top 3 largest elements", expected, actual);
        System.out.println();
    }

    // --------------------------
    // Test 2: k = 1
    // --------------------------
    
    private static void testKEqualsOne() {
        printSection("Test 2: k = 1");

        int[] nums = {12, 5, 30, 7, 18};
        int k = 1;

        int[] expected = {30};
        int[] actual = Task5.topKLargest(nums, k);

        System.out.print("Input Array: ");
        printArray(nums);
        System.out.println("k          : " + k);

        checkArray("Largest element only", expected, actual);
        System.out.println();
    }

    // --------------------------
    // Test 3: k = array length
    // --------------------------
   
    private static void testAllElements() {
        printSection("Test 3: All Elements");

        int[] nums = {3, 9, 1, 6};
        int k = 4;

        int[] expected = {9, 6, 3, 1};
        int[] actual = Task5.topKLargest(nums, k);

        System.out.print("Input Array: ");
        printArray(nums);
        System.out.println("k          : " + k);

        checkArray("All elements in descending order", expected, actual);
        System.out.println();
    }

    // --------------------------
    // Test 4: Duplicate Values
    // --------------------------
   
    private static void testDuplicateValues() {
        printSection("Test 4: Duplicate Values");

        int[] nums = {5, 10, 10, 3, 8};
        int k = 3;

        int[] expected = {10, 10, 8};
        int[] actual = Task5.topKLargest(nums, k);

        System.out.print("Input Array: ");
        printArray(nums);
        System.out.println("k          : " + k);

        checkArray("Top elements with duplicates", expected, actual);
        System.out.println();
    }

    // --------------------------
    // Test 5: Negative Values
    // --------------------------
   
    private static void testNegativeValues() {
        printSection("Test 5: Negative Values");

        int[] nums = {-5, -1, -10, 0, 3};
        int k = 3;

        int[] expected = {3, 0, -1};
        int[] actual = Task5.topKLargest(nums, k);

        System.out.print("Input Array: ");
        printArray(nums);
        System.out.println("k          : " + k);

        checkArray("Top elements with negative values", expected, actual);
        System.out.println();
    }

    // --------------------------
    // Utility Methods
    // --------------------------
   
    private static void printHeader(String title) {
        System.out.println();
        System.out.println(CYAN + "==================================================" + RESET);
        System.out.println(CYAN + "       " + title + RESET);
        System.out.println(CYAN + "==================================================" + RESET);
    }

    private static void printSection(String title) {
        System.out.println();
        System.out.println(YELLOW + "--------------------------------------------------" + RESET);
        System.out.println(YELLOW + title + RESET);
        System.out.println(YELLOW + "--------------------------------------------------" + RESET);
    }

    private static void printFooter() {
        System.out.println(CYAN + "==================================================" + RESET);
        System.out.println(CYAN + "                 TESTING COMPLETE" + RESET);
        System.out.println(CYAN + "==================================================" + RESET);
    }

    private static void checkArray(String testName, int[] expected, int[] actual) {
        
        if(arrayEquals(expected, actual)) {
            System.out.println(GREEN + "PASS: " + testName + RESET);
        } else {
            System.out.println(RED + "FAIL: " + testName + RESET);

            System.out.print("Expected: ");
            printArray(expected);

            System.out.print("Got     : ");
            printArray(actual);
        }
    }

    private static boolean arrayEquals(int[] arr1, int[] arr2) {
        
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

    private static void printArray(int[] arr) {
        System.out.print("[");

        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);

            if(i < arr.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }
}