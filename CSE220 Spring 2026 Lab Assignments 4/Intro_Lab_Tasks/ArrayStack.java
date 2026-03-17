package Intro_Lab_Tasks;

public class ArrayStack {

    private Object[] stack;
    private int top;

    public ArrayStack(int size) {
        stack = new Object[size];
        top = -1;
    }

    public void push(Object element) {
        // TODO: Implement push

        if(top == stack.length - 1) {
            System.out.println("stack overflow");
            return;
        }

        top++;
        stack[top] = element;
    }

    public Object pop() {
        // TODO: Implement pop

        if(isEmpty()) {
            System.out.println("stack underflow");
            return null;
        }

        Object poppedElement = stack[top];
        top--;
        return poppedElement;

        // return null;
    }

    public Object peek() {
        // TODO: Implement peek

        if(isEmpty()) {
            return null;
        }

        return stack[top];
        // return null;
    }

    public boolean isEmpty() {
        // TODO: Implement isEmpty
        return false;
    }
    
}
