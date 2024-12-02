package algorithms;

public class HeapSort {


    public static void main(String[] args) {
        int[] arr = {9, 4, 3, 8, 10, 2, 5};
        heapSort(arr);
        System.out.println("Sorted array is ");
        printArray(arr);
    }

    static void heapify(int arr[], int n, int i, boolean shouldPrint) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        // If largest is not root
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

           if (shouldPrint){
               System.out.println("Heapifying array");
               printArray(arr);
           }
            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest, shouldPrint);
        }
    }
    static void heapSort(int arr[]) {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i, true);
        }

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {

            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0, false);
        }
    }

    // A utility function to print array of size n
    static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Driver's code

}
