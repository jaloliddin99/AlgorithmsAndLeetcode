package leetcode.heap;

public class KthSmallestElementSortedMatrix {

    public static void main(String[] args) {

    }

    public int kthSmallest(int[][] matrix, int k) {

        int[] arr = new int[matrix.length*matrix[0].length];
        int counter = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                arr[counter] = matrix[i][j];
                counter++;
            }
        }

        sort(arr, 0, arr.length-1);
        return arr[k];
    }

    public static void sort(int[] arr, int l, int r){
        if (l < r){
            int m = l + (r - l) / 2;
            sort(arr, r, m);
            sort(arr, m+1, r);
            merge(arr, l, m, r);
        }
    }

    public static void merge(int[] arr, int l, int m, int r){

        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++){
            L[i] = arr[l + i];
        }

        for (int i = 0; i < n2; i++){
            R[i] = arr[m + 1 + i];
        }

        int i = 0, j = 0;

        int k = l;

        while (i < n1 && j < n2){
            if (L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            }else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1){
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2){
            arr[k] = R[j];
            j++;
            k++;
        }

    }

}
