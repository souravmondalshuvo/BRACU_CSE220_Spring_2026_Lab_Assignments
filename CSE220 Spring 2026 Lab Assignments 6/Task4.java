public class Task4 {

    public static void main(String[] args) {
        
        int[] tasks = {2, 4, 7, 1, 6};
        int number_of_machines = 4;

        int[] result = assignTasks(tasks, number_of_machines);

        printArray(result);
    }

    public static int[] assignTasks(int[] tasks, int number_of_machines) {

        MinHeap minHeap = new MinHeap(number_of_machines);

        for(int i = 0; i < number_of_machines; i++) {
            minHeap.insert(0);
        }

        for(int i = 0; i < tasks.length; i++) {
            
            int smallest_load = minHeap.extractMin();
            int updated_load = smallest_load + tasks[i];

            minHeap.insert(updated_load);
        }

        return minHeap.getHeapArray();
    }

    public static void printArray(int[] arr) {

        System.out.print("[");

        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");

            if(i < arr.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }
}
