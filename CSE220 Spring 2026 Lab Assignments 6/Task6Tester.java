public class Task6Tester {

    public static String GREEN = "\u001B[32m";
    public static String RED = "\u001B[31m";
    public static String CYAN = "\u001B[36m";
    public static String YELLOW = "\u001B[33m";
    public static String RESET = "\u001B[0m";

    public static void main(String[] args) {

        printHeader("TASK 6 TESTER - TASK SCHEDULER WITH PRIORITY QUEUE");

        printSection("Test 1: Sample Test");

        String[] task_names1 = {"Email", "Meeting", "Code Review", "Lunch", "Debug"};
        int[] priorities1 = {2, 5, 3, 1, 4};

        String[] result1 = Task6.scheduleTasks(task_names1, priorities1);

        System.out.print("Task Names : ");
        printStringArray(task_names1);

        System.out.print("Priorities : ");
        printIntArray(priorities1);

        checkArray(
            "Scheduled Tasks",
            result1,
            new String[]{"Meeting", "Debug", "Code Review", "Email", "Lunch"}
        );


        printSection("Test 2: Already Priority Ordered");

        String[] task_names2 = {"Task A", "Task B", "Task C"};
        int[] priorities2 = {9, 6, 3};

        String[] result2 = Task6.scheduleTasks(task_names2, priorities2);

        System.out.print("Task Names : ");
        printStringArray(task_names2);

        System.out.print("Priorities : ");
        printIntArray(priorities2);

        checkArray(
            "Scheduled Tasks",
            result2,
            new String[]{"Task A", "Task B", "Task C"}
        );


        printSection("Test 3: Reverse Priority Order");

        String[] task_names3 = {"Low", "Medium", "High"};
        int[] priorities3 = {1, 5, 10};

        String[] result3 = Task6.scheduleTasks(task_names3, priorities3);

        System.out.print("Task Names : ");
        printStringArray(task_names3);

        System.out.print("Priorities : ");
        printIntArray(priorities3);

        checkArray(
            "Scheduled Tasks",
            result3,
            new String[]{"High", "Medium", "Low"}
        );


        printSection("Test 4: Same Priority Values");

        String[] task_names4 = {"A", "B", "C", "D"};
        int[] priorities4 = {5, 5, 3, 5};

        String[] result4 = Task6.scheduleTasks(task_names4, priorities4);

        System.out.print("Task Names : ");
        printStringArray(task_names4);

        System.out.print("Priorities : ");
        printIntArray(priorities4);

        checkArray(
            "Scheduled Tasks",
            result4,
            new String[]{"A", "B", "D", "C"}
        );

        printFooter();
    }

    public static void printHeader(String title) {
        System.out.println();
        System.out.println(CYAN + "============================================================" + RESET);
        System.out.println(CYAN + "     " + title + RESET);
        System.out.println(CYAN + "============================================================" + RESET);
    }

    public static void printSection(String title) {
        System.out.println();
        System.out.println(YELLOW + "------------------------------------------------------------" + RESET);
        System.out.println(YELLOW + title + RESET);
        System.out.println(YELLOW + "------------------------------------------------------------" + RESET);
    }

    public static void printFooter() {
        System.out.println();
        System.out.println(CYAN + "============================================================" + RESET);
        System.out.println(CYAN + "                    TESTING COMPLETE" + RESET);
        System.out.println(CYAN + "============================================================" + RESET);
    }

    public static void checkArray(String testName, String[] actual, String[] expected) {
        System.out.println(testName);

        System.out.print("Actual   : ");
        printStringArray(actual);

        System.out.print("Expected : ");
        printStringArray(expected);

        if(arrayEquals(actual, expected)) {
            System.out.println(GREEN + "Result   : PASS" + RESET);
        } else {
            System.out.println(RED + "Result   : FAIL" + RESET);
        }

        System.out.println();
    }

    public static boolean arrayEquals(String[] arr1, String[] arr2) {
        
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

    public static void printStringArray(String[] arr) {
        System.out.print("[");

        for(int i = 0; i < arr.length; i++) {
            System.out.print("\"" + arr[i] + "\"");

            if(i < arr.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }

    public static void printIntArray(int[] arr) {
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