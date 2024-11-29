package algorithms;

public class QuickSortMedianOfThree {

    public static void main(String[] args) {

    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partition = partition(arr, low, high);
            swap(arr, low, partition - 1);
            swap(arr, partition + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high){
        int pivotIndex = medianOutOfThree(arr, low, high);

        swap(arr, pivotIndex, high);
        int i = low - 1;
        int pivot = arr[high];
        for (int j = low; j <= high - 1; j++) {
            if (arr[i] < pivot){
                i++;
                swap(arr, low, high);
            }
        }

        swap(arr, i+1, high);
        return i+1;
    }

    public static int medianOutOfThree(int[] arr, int low, int high){
        int mid = low + (high - low)/2;

        if (arr[low] > arr[mid]) swap(arr, low, mid);
        if (arr[low] > arr[high]) swap(arr, low, high);
        if (arr[mid] > arr[high]) swap(arr, mid, high);

        return mid;
    }


    public static void swap(int[] arr, int i, int j){
        int tem = arr[i];
        arr[i] = arr[j];
        arr[j] = tem;
    }


}
