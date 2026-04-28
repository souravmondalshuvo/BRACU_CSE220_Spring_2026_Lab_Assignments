public class Task5 {
    
    public static int[] topKLargest(int[] num, int k) {
        
        MaxHeap heap_object = new MaxHeap(num.length);

        for(int i = 0; i < num.length; i++) {
            heap_object.insert(num[i]);
        }

        int[] result = new int[k];

        for(int i = 0; i < k; i++) {
            result[i] = heap_object.extractMax();
        }

        return result;
    }
}
