// AssignmentTask2: Organize Books
import java.util.Arrays;
public class AssignmentTask2{
    
    // MUST SUBMIT this method
    public static Node organizeBooks(Node head, Integer[] popularity) {
        
        //TO DO

        if(head == null) {
            return null;
        }
        
        Node temp = head;
        int size = 0;

        while(temp != null) {
            size++;
            temp = temp.next;
        }

        int number_of_elements = size;

        if(popularity.length < number_of_elements) {
            number_of_elements = popularity.length;
        } 

        Node[] new_nodes = new Node[size];
        temp = head;

        for(int i = 0; i < number_of_elements; i++) {
            new_nodes[i] = temp;
            temp = temp.next;
        }

        for(int i = 0; i < number_of_elements - 1; i++) {
            for(int j = 0; j < number_of_elements - i - 1; j++) {

                if(popularity[j] < popularity[j + 1]) {
                    
                    int temp_popularity = popularity[j];
                    popularity[j] = popularity[j + 1];
                    popularity[j + 1] = temp_popularity;

                    Node temp_node = new_nodes[j];
                    new_nodes[j] = new_nodes[j + 1];
                    new_nodes[j + 1] = temp_node;
                }
            }
        }

        for(int i = 0; i < number_of_elements - 1; i++) {
            new_nodes[i].next = new_nodes[i + 1];
        }

        new_nodes[number_of_elements - 1].next = temp;

        //return null; // Remove this when you're ready to return the new head
        return new_nodes[0];
    }

    //NOTE: if you find any issue with the driver code please inform AIB
    //DO NOT MAKE ANY MODIFICATIONS IN THE TESTER CODE BELOW
    //DO NOT SUBMIT THE DRIVER CODE BELOW
    public static void main(String[] args) {
        System.out.println("=================Test Case 1=================");
        Node books = LinkedList.createList(new String[]{"Dune", "IT", "Coraline", "Inferno", "Twlight"});
        Integer[] arr = { 8, 10, 5, 10, 6 };

        System.out.println("Sample Given LinkedList and Popularity array:  ");
        LinkedList.printLL(books);
        System.out.println(Arrays.toString(arr));
        
        System.out.println("\nExpected Output");
        System.out.println("IT -> Inferno -> Dune -> Twilight -> Coraline");
        
        System.out.println("Your Output");
        books = organizeBooks( books, arr );
        LinkedList.printLL(books);

       
        System.out.println("=================Test Case 2=================");
        Node books2 = LinkedList.createList(new String[]{"Hamlet", "Persuasion", "It", "Dracula", "Beloved"});
        Integer[] arr2 = {7, 9, 9, 6, 7};

        System.out.println("Sample Given LinkedList and Popularity array:  ");
        LinkedList.printLL(books2);
        System.out.println(Arrays.toString(arr2));

        System.out.println("\nExpected Output");
        System.out.println("Persuasion -> It -> Hamlet -> Beloved -> Dracula");

        System.out.println("Your Output");
        books2 = organizeBooks(books2, arr2);
        LinkedList.printLL(books2);


        System.out.println("=================Test Case 3=================");
        Node books3 = LinkedList.createList(new String[]{"Matilda", "Franny", "Foundation", "Carrie", "Misery"});
        Integer[] arr3 = {5, 8, 8, 10, 6};

        System.out.println("Sample Given LinkedList and Popularity array:  ");
        LinkedList.printLL(books3);
        System.out.println(Arrays.toString(arr3));

        System.out.println("\nExpected Output");
        System.out.println("Carrie -> Franny -> Foundation -> Misery -> Matilda");

        System.out.println("Your Output");
        books3 = organizeBooks(books3, arr3);
        LinkedList.printLL(books3);

    }
}
