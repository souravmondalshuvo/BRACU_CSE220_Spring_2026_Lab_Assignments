public class Task5Tester {

    public static String GREEN = "\u001B[32m";
    public static String RED = "\u001B[31m";
    public static String CYAN = "\u001B[36m";
    public static String YELLOW = "\u001B[33m";
    public static String RESET = "\u001B[0m";

    public static void main(String[] args) {

        printHeader("TASK 5 TESTER - TOP K LARGEST ELEMENTS");

        printSection("Test 1: Sample Test");

        int[] nums1 = {4, 10, 2, 8, 6, 7};
        int k1 = 3;

        int[] result1 = Task5.topKLargest(nums1, k1);

        System.out.print("Input Array : ");
        printArray(nums1);
        System.out.println("k           : " + k1);

        checkArray("Top " + k1 + " largest elements", result1, new int[]{10, 8, 7});


        printSection("Test 2: k = 1");

        int[] nums2 = {12, 5, 30, 7, 18};
        int k2 = 1;

        int[] result2 = Task5.topKLargest(nums2, k2);

        System.out.print("Input Array : ");
        printArray(nums2);
        System.out.println("k           : " + k2);

        checkArray("Top " + k2 + " largest element", result2, new int[]{30});


        printSection("Test 3: All Elements");

        int[] nums3 = {3, 9, 1, 6};
        int k3 = 4;

        int[] result3 = Task5.topKLargest(nums3, k3);

        System.out.print("Input Array : ");
        printArray(nums3);
        System.out.println("k           : " + k3);

        checkArray("Top " + k3 + " largest elements", result3, new int[]{9, 6, 3, 1});


        printSection("Test 4: Duplicate Values");

        int[] nums4 = {5, 10, 10, 3, 8};
        int k4 = 3;

        int[] result4 = Task5.topKLargest(nums4, k4);

        System.out.print("Input Array : ");
        printArray(nums4);
        System.out.println("k           : " + k4);

        checkArray("Top " + k4 + " largest elements", result4, new int[]{10, 10, 8});

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
}