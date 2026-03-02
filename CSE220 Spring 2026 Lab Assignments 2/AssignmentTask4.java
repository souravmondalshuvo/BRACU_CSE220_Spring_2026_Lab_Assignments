// AssignmentTask4: ID Generator
public class AssignmentTask4{
    
    // MUST SUBMIT this method
    public static Node idGenerator(Node head1, Node head2, Node head3) {
        
        //TO DO
        //Hint: the Node elements are actually Object, you can type cast them
        //      into int or Integer like the following:
        //        (int)n.elem  or  (Integer)n.elem

        Node head_result = null;
        Node current_1 = head1;

        while(current_1 != null) {
            Node new_node = new Node(current_1.elem);
            
            new_node.next = head_result;
            head_result = new_node;
            current_1 = current_1.next;
        }

        Node tail = head_result;

        while(tail != null && tail.next != null) {
            tail = tail.next;
        }

        Node current_2 = head2;
        Node current_3 = head3;

        while(current_2 != null && current_3 != null) {
            int total = (Integer) current_2.elem + (Integer) current_3.elem;
            int digit = total % 10;

            Node new_node = new Node(digit);

            if(head_result == null) {
                head_result = new_node;
                tail = new_node;
            } else {
                tail.next = new_node;
                tail = new_node;
            }

            current_2 = current_2.next;
            current_3 = current_3.next;
        }

        //return null; // Remove this when you're ready to return the new head
        return head_result;
    }

    //NOTE: if you find any issue with the driver code please inform AIB
    //DO NOT MAKE ANY MODIFICATIONS IN THE TESTER CODE BELOW
    //DO NOT SUBMIT THE DRIVER CODE BELOW
    public static void main(String[] args) {
        System.out.println("=========Test Case 1=============");
        Node head1 = LinkedList.createList(new Integer[]{0, 3, 2, 2});
        Node head2 = LinkedList.createList(new Integer[]{5, 2, 2, 1});
        Node head3 = LinkedList.createList(new Integer[]{4, 3, 2, 1});

        System.out.print("LinkedList#1:  ");
        LinkedList.printLL(head1); // This should print 0 -> 3 -> 2 -> 2

        System.out.print("LinkedList#2:  ");
        LinkedList.printLL(head2); // This should print 5 -> 2 -> 2 -> 1

        System.out.print("LinkedList#3:  ");
        LinkedList.printLL(head3); // This should print 4 -> 3 -> 2 -> 1

        Node result = idGenerator(head1, head2, head3);

        System.out.print("\nNew ID:  ");
        LinkedList.printLL(result); // This should print 2 -> 2 -> 3 -> 0 -> 9 -> 5 -> 4 -> 2

        System.out.println("\n=========Test Case 2=============");
        Node head4 = LinkedList.createList(new Integer[]{0, 3, 9, 1});
        Node head5 = LinkedList.createList(new Integer[]{3, 6, 5, 7});
        Node head6 = LinkedList.createList(new Integer[]{2, 4, 3, 8});

        System.out.print("LinkedList#4:  ");
        LinkedList.printLL(head4); // This should print 0 -> 3 -> 9 -> 1

        System.out.print("LinkedList#5:  ");
        LinkedList.printLL(head5); // This should print 3 -> 6 -> 5 -> 7

        System.out.print("LinkedList#6:  ");
        LinkedList.printLL(head6); // This should print 2 -> 4 -> 3 -> 8

        Node result2 = idGenerator(head4, head5, head6);

        System.out.print("\nNew ID:  ");
        LinkedList.printLL(result2); // This should print 1 -> 9 -> 3 -> 0 -> 5 -> 0 -> 8 -> 5
    }
}
