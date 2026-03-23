package AssignmentTask1;
public class StackTaskTester {
    
    // You have to write this method
    public static Stack conditionalReverse(Stack stack) {
        // TODO: Implement conditional reverse logic here

        Stack reversed_stack = new Stack();
        Stack temp = new Stack();

        if(stack == null) {
            return reversed_stack;
        }

        int previous = 0;
        boolean first = true;

        while(!stack.isEmpty()) {
            int current = stack.pop();
            temp.push(current);

            if(first || current != previous) {
                reversed_stack.push(current);
                previous = current;
                first = false;
            }
        }

        while(!temp.isEmpty()) {
            stack.push(temp.pop());
        }

        return reversed_stack;
        // return null; //remove this line once your're done
    }

    //DO NOT CHANGE THIS METHOD
    // This method is for printing the element of the stack. No need to modify anything.
    public static void printStack(Stack stack) {
        if (stack==null || stack.isEmpty()) {
            return;
        }
        int elem = stack.pop();
        System.out.printf("| %2d |\n",elem);
        printStack(stack);
        stack.push(elem);
    }

    //DO NOT CHANGE THIS METHOD
    public static void assertTest(int actual, int expected) {
        if (actual == expected) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed! Expected: " + expected + ", but got: " + actual);
        }
    }


    //DO NOT CHANGE ANYTHING IN THE DRIVER CODE
    public static void main(String[] args) {
        // This part is for checking how the Stack class and printing working
	System.out.println("Demo of Stack class methods and Stack Printing\n");
	Stack s = new Stack();
        s.push(4);
        s.push(3);
        s.push(5);
        s.push(1);
        s.push(9);

        printStack(s);
        System.out.println("------\nCalling pop()\n");
	s.pop();
        printStack(s);
        System.out.println("------");
        System.out.println("--- Checking Ended ---\n");
        // Checking End Here

        System.out.println("====== Tests Starts Here =======");
        System.out.println("Test 01");
        Stack st = new Stack();
        st.push(10);
        st.push(10);
        st.push(20);
        st.push(20);
        st.push(30);
        st.push(10);
        st.push(50);

        System.out.println("Stack:");
        printStack(st);
        System.out.println("------");

        Stack reversedStack = conditionalReverse(st);

        System.out.println("After Calling Conditional Reversed Stack:");
        printStack(reversedStack); // Expected: 50, 10, 30, 20, 10
        System.out.println("------");

        System.out.println("====== Tests Ends Here =======");
    }
}
