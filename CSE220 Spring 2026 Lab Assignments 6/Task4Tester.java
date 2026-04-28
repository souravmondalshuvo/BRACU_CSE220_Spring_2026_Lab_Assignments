public class Task4Tester {

    public static String GREEN = "\u001B[32m";
    public static String RED = "\u001B[31m";
    public static String CYAN = "\u001B[36m";
    public static String YELLOW = "\u001B[33m";
    public static String RESET = "\u001B[0m";

    public static void main(String[] args) {

        printHeader("TASK 4 TESTER - MACHINE TASK ASSIGNMENT");

        testSampleCase();
        testSingleMachine();
        testMoreMachinesThanTasks();
        testEqualTasks();
        testNoTasks();
        printFooter();
    }

    // --------------------------
    // Test 1: Sample Case
    // --------------------------
    
    private static void testSampleCase() {
        printSection("Test 1: Sample Case");

        int[] tasks = {2, 4, 7, 1, 6};
        int number_of_machines = 4;

        int[] expected = {2, 4, 7, 7};
        int[] actual = Task4.assignTasks(tasks, number_of_machines);

        System.out.print("Tasks             : ");
        printArray(tasks);
        System.out.println("Number of Machines: " + number_of_machines);

        checkArray("Final machine loads", expected, actual);
        System.out.println();
    }

    // --------------------------
    // Test 2: Single Machine
    // --------------------------
    
    private static void testSingleMachine() {
        printSection("Test 2: Single Machine");

        int[] tasks = {3, 5, 2};
        int number_of_machines = 1;

        int[] expected = {10};
        int[] actual = Task4.assignTasks(tasks, number_of_machines);

        System.out.print("Tasks             : ");
        printArray(tasks);
        System.out.println("Number of Machines: " + number_of_machines);

        checkArray("All tasks assigned to one machine", expected, actual);
        System.out.println();
    }

    // --------------------------
    // Test 3: More Machines Than Tasks
    // --------------------------
    
    private static void testMoreMachinesThanTasks() {
        printSection("Test 3: More Machines Than Tasks");

        int[] tasks = {5, 2};
        int number_of_machines = 4;

        int[] expected = {0, 0, 5, 2};
        int[] actual = Task4.assignTasks(tasks, number_of_machines);

        System.out.print("Tasks             : ");
        printArray(tasks);
        System.out.println("Number of Machines: " + number_of_machines);

        checkArray("Some machines remain unused", expected, actual);
        System.out.println();
    }

    // --------------------------
    // Test 4: Equal Task Times
    // --------------------------
    
    private static void testEqualTasks() {
        printSection("Test 4: Equal Task Times");

        int[] tasks = {2, 2, 2, 2};
        int number_of_machines = 2;

        int[] expected = {4, 4};
        int[] actual = Task4.assignTasks(tasks, number_of_machines);

        System.out.print("Tasks             : ");
        printArray(tasks);
        System.out.println("Number of Machines: " + number_of_machines);

        checkArray("Balanced machine loads", expected, actual);
        System.out.println();
    }

    // --------------------------
    // Test 5: No Tasks
    // --------------------------
    
    private static void testNoTasks() {
        printSection("Test 5: No Tasks");

        int[] tasks = {};
        int number_of_machines = 3;

        int[] expected = {0, 0, 0};
        int[] actual = Task4.assignTasks(tasks, number_of_machines);

        System.out.print("Tasks             : ");
        printArray(tasks);
        System.out.println("Number of Machines: " + number_of_machines);

        checkArray("All machines stay at zero load", expected, actual);
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