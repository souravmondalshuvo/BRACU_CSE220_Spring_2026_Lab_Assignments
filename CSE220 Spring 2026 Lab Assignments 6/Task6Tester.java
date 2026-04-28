public class Task6Tester {

    public static String GREEN = "\u001B[32m";
    public static String RED = "\u001B[31m";
    public static String CYAN = "\u001B[36m";
    public static String YELLOW = "\u001B[33m";
    public static String RESET = "\u001B[0m";

    public static void main(String[] args) {

        printHeader("TASK 6 TESTER - TASK SCHEDULER WITH PRIORITY QUEUE");

        testSampleCase();
        testAlreadyPriorityOrdered();
        testReversePriorityOrder();
        testSamePriorityValues();
        testSingleTask();
        printFooter();
    }

    // --------------------------
    // Test 1: Sample Case
    // --------------------------
    
    private static void testSampleCase() {
        printSection("Test 1: Sample Case");

        String[] task_names = {"Email", "Meeting", "Code Review", "Lunch", "Debug"};
        int[] priorities = {2, 5, 3, 1, 4};

        String[] expected = {"Meeting", "Debug", "Code Review", "Email", "Lunch"};
        String[] actual = Task6.scheduleTasks(task_names, priorities);

        System.out.print("Task Names: ");
        printStringArray(task_names);

        System.out.print("Priorities: ");
        printIntArray(priorities);

        checkArray("Tasks scheduled by highest priority", expected, actual);
        System.out.println();
    }

    // --------------------------
    // Test 2: Already Priority Ordered
    // --------------------------
  
    private static void testAlreadyPriorityOrdered() {
        printSection("Test 2: Already Priority Ordered");

        String[] task_names = {"Task A", "Task B", "Task C"};
        int[] priorities = {9, 6, 3};

        String[] expected = {"Task A", "Task B", "Task C"};
        String[] actual = Task6.scheduleTasks(task_names, priorities);

        System.out.print("Task Names: ");
        printStringArray(task_names);

        System.out.print("Priorities: ");
        printIntArray(priorities);

        checkArray("Tasks remain in priority order", expected, actual);
        System.out.println();
    }

    // --------------------------
    // Test 3: Reverse Priority Order
    // --------------------------
   
    private static void testReversePriorityOrder() {
        printSection("Test 3: Reverse Priority Order");

        String[] task_names = {"Low", "Medium", "High"};
        int[] priorities = {1, 5, 10};

        String[] expected = {"High", "Medium", "Low"};
        String[] actual = Task6.scheduleTasks(task_names, priorities);

        System.out.print("Task Names: ");
        printStringArray(task_names);

        System.out.print("Priorities: ");
        printIntArray(priorities);

        checkArray("Tasks are reversed into priority order", expected, actual);
        System.out.println();
    }

    // --------------------------
    // Test 4: Same Priority Values
    // --------------------------
  
    private static void testSamePriorityValues() {
        printSection("Test 4: Same Priority Values");

        String[] task_names = {"A", "B", "C", "D"};
        int[] priorities = {5, 5, 3, 5};

        String[] expected = {"A", "B", "D", "C"};
        String[] actual = Task6.scheduleTasks(task_names, priorities);

        System.out.print("Task Names: ");
        printStringArray(task_names);

        System.out.print("Priorities: ");
        printIntArray(priorities);

        checkArray("Same priority keeps original order", expected, actual);
        System.out.println();
    }

    // --------------------------
    // Test 5: Single Task
    // --------------------------
  
    private static void testSingleTask() {
        printSection("Test 5: Single Task");

        String[] task_names = {"Only Task"};
        int[] priorities = {100};

        String[] expected = {"Only Task"};
        String[] actual = Task6.scheduleTasks(task_names, priorities);

        System.out.print("Task Names: ");
        printStringArray(task_names);

        System.out.print("Priorities: ");
        printIntArray(priorities);

        checkArray("Single task returns itself", expected, actual);
        System.out.println();
    }

    // --------------------------
    // Utility Methods
    // --------------------------
  
    private static void printHeader(String title) {
        System.out.println();
        System.out.println(CYAN + "============================================================" + RESET);
        System.out.println(CYAN + "     " + title + RESET);
        System.out.println(CYAN + "============================================================" + RESET);
    }

    private static void printSection(String title) {
        System.out.println();
        System.out.println(YELLOW + "------------------------------------------------------------" + RESET);
        System.out.println(YELLOW + title + RESET);
        System.out.println(YELLOW + "------------------------------------------------------------" + RESET);
    }

    private static void printFooter() {
        System.out.println(CYAN + "============================================================" + RESET);
        System.out.println(CYAN + "                    TESTING COMPLETE" + RESET);
        System.out.println(CYAN + "============================================================" + RESET);
    }

    private static void checkArray(String testName, String[] expected, String[] actual) {
        
        if(arrayEquals(expected, actual)) {
            System.out.println(GREEN + "PASS: " + testName + RESET);
        } else {
            System.out.println(RED + "FAIL: " + testName + RESET);

            System.out.print("Expected: ");
            printStringArray(expected);

            System.out.print("Got     : ");
            printStringArray(actual);
        }
    }

    private static boolean arrayEquals(String[] arr1, String[] arr2) {
       
        if(arr1.length != arr2.length) {
            return false;
        }

        for(int i = 0; i < arr1.length; i++) {
            
            if(!arr1[i].equals(arr2[i])) {
                return false;
            }
        }

        return true;
    }

    private static void printStringArray(String[] arr) {
        System.out.print("[");

        for(int i = 0; i < arr.length; i++) {
            System.out.print("\"" + arr[i] + "\"");

            if(i < arr.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }

    private static void printIntArray(int[] arr) {
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