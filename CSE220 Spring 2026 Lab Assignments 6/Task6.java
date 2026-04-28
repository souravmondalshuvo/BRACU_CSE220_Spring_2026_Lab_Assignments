public class Task6 {

    public static String[] scheduleTasks(String[] task_names, int[] priorities) {

        CustomMaxHeap heap_object = new CustomMaxHeap(task_names.length);

        for(int i = 0; i < task_names.length; i++) {
            heap_object.insert(task_names[i], priorities[i], i);
        }

        String[] result = new String[task_names.length];

        int index = 0;

        while(!heap_object.isEmpty()) {
            result[index] = heap_object.extractMax();
            index++;
        }

        return result;
    }

    private static class CustomMaxHeap {

        private String[] task_names;
        private int[] priorities;
        private int[] order;
        private int size;
        private int capacity;

        public CustomMaxHeap(int capacity) {
            this.capacity = capacity;
            this.task_names = new String[capacity];
            this.priorities = new int[capacity];
            this.order = new int[capacity];
            this.size = 0;
        }

        public void insert(String task_name, int priority, int original_order) {
            
            if(size >= capacity) {
                System.out.println("Heap is full");
                return;
            }

            task_names[size] = task_name;
            priorities[size] = priority;
            order[size] = original_order;

            heapifyUp(size);
            size++;
        }

        public String extractMax() {
            
            if(isEmpty()) {
                return null;
            }

            String max_task = task_names[0];

            task_names[0] = task_names[size - 1];
            priorities[0] = priorities[size - 1];
            order[0] = order[size - 1];

            task_names[size - 1] = null;
            priorities[size - 1] = 0;
            order[size - 1] = 0;

            size--;

            if(size > 0) {
                heapifyDown(0);
            }

            return max_task;
        }

        private void heapifyUp(int index) {
            
            while(index > 0) {
                int parent = (index - 1) / 2;

                if(isGreater(index, parent)) {
                    swap(index, parent);
                    index = parent;
                } else {
                    break;
                }
            }
        }

        private void heapifyDown(int index) {
            
            while(index < size) {
                int leftChild = index * 2 + 1;
                int rightChild = index * 2 + 2;
                int largestChild = index;

                if(leftChild < size && isGreater(leftChild, largestChild)) {
                    largestChild = leftChild;
                }

                if(rightChild < size && isGreater(rightChild, largestChild)) {
                    largestChild = rightChild;
                }

                if(largestChild != index) {
                    swap(index, largestChild);
                    index = largestChild;
                } else {
                    break;
                }
            }
        }

        private boolean isGreater(int firstIndex, int secondIndex) {
            
            if(priorities[firstIndex] > priorities[secondIndex]) {
                return true;
            }

            if(priorities[firstIndex] == priorities[secondIndex] && order[firstIndex] < order[secondIndex]) {
                return true;
            }

            return false;
        }

        private void swap(int index1, int index2) {
            
            String tempTask = task_names[index1];
            
            task_names[index1] = task_names[index2];
            task_names[index2] = tempTask;

            int tempPriority = priorities[index1];
            
            priorities[index1] = priorities[index2];
            priorities[index2] = tempPriority;

            int tempOrder = order[index1];
            
            order[index1] = order[index2];
            order[index2] = tempOrder;
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }
}