public class AssignmentTask6 {

    //SUBMIT ONLY THIS METHOD
    public static void pairJoin(DNode dh1, DNode dh2) {
        // TO DO

        if(dh1 == null || dh2 == null) {
            return;
        }

        DNode pointer_1 = dh1.next;
        DNode pointer_2 = dh2.next;
        DNode tail = dh1;

        while(pointer_1 != null && pointer_2 != null) {
            DNode next_node_1 = pointer_1.next;
            DNode next_node_2 = pointer_2.next;

            tail.next = pointer_1;
            pointer_1.prev = tail;
            tail = pointer_1;

            tail.next = pointer_2;
            pointer_2.prev = tail;
            tail = pointer_2;

            pointer_1 = next_node_1;
            pointer_2 = next_node_2;
        }

        tail.next = dh1;
        dh1.prev = tail;
        dh1.next.prev = dh1;
    }

    //DO NOT SUBMIT THE DRIVER CODE BELOW
    //SUBMITTING IT WILL INCREASE YOUR PLAG % FOR NO REASON
    public static void main(String[] args) {
        Object[] list1 = {"A", "B", "C", "D"};
        Object[] list2 = {"E", "F", "G", "H"};

        DNode dh1 = LinkedListHelpers.createDummyHeadedDoublyLL(list1, false);
        DNode dh2 = LinkedListHelpers.createDummyHeadedDoublyLL(list2, false);

        System.out.println("Given Linked List 1:");
        LinkedListHelpers.printDummyHeadedDoublyLL(dh1);

        System.out.println("Given Linked List 2:");
        LinkedListHelpers.printDummyHeadedDoublyLL(dh2);

        System.out.println("\nExpected Output:");
        Object[] expected = {"A", "E", "B", "F", "C", "G", "D", "H"};
        DNode expectedHead = LinkedListHelpers.createDummyHeadedDoublyLL(expected, true);
        LinkedListHelpers.printDummyHeadedDoublyCircularLL(expectedHead);

        //Running the Pair Join
        pairJoin(dh1, dh2);
        //Printing after Pair Join
        System.out.println("\nYour Output:");
        LinkedListHelpers.printDummyHeadedDoublyCircularLL(dh1);
    }
}
