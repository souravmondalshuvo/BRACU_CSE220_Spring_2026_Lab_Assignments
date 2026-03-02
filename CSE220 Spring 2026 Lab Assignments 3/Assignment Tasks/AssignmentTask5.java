public class AssignmentTask5 {

    //SUBMIT ONLY THIS METHOD
    public static void sumOddAppend(Node dh) {
        // TO DO

        if(dh == null) {
            return;
        }

        Node previous = dh;
        Node current = dh.next;

        int sum = 0;

        while(current != dh) {
            int value = (Integer) current.elem;

            if(value % 2 != 0) {
                sum += value;

                previous.next = current.next;
                current = previous.next;
            } else {
                previous = current;
                current = current.next;
            }
        }

        Node new_node = new Node(sum);
        new_node.next = dh;
        previous.next = new_node;
    }

    //DO NOT SUBMIT THE DRIVER CODE BELOW
    //SUBMITTING IT WILL INCREASE YOUR PLAG % FOR NO REASON
    public static void main(String[] args) {
        Object[] values = {11, 22, 33, 44, 55, 66};
        Node head = LinkedListHelpers.createDummyHeadedSinglyCircularLL(values, true);

        System.out.println("Given Linked List:");
        LinkedListHelpers.printDummyHeadedSinglyCircularLL(head);
        System.out.println("\nExpected Output:");
        Object[] expected = {22, 44, 66, 99};
        Node expectedHead = LinkedListHelpers.createDummyHeadedSinglyCircularLL(expected, true);
        LinkedListHelpers.printDummyHeadedSinglyCircularLL(expectedHead);
        
        //Running the Sum Odd Append
        sumOddAppend(head);
        //Printing after Sum Odd Append
        System.out.println("\nYour Output:");
        LinkedListHelpers.printDummyHeadedSinglyCircularLL(head);
    }
}
