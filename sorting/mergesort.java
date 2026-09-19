package sorting;

public class mergesort {//tc:(nlogn)
    public static void printarry(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void mergeSort(int[] arr, int si, int ei) {
        if (si >= ei)
            return;
        int mid = si + (ei - si) / 2;

        // left part sort
        mergeSort(arr, si, mid);
        // right part sort
        mergeSort(arr, mid + 1, ei);
        // merge both left and right
        merge(arr, si, mid, ei);

    }

    public static void merge(int[] arr, int si, int mid, int ei) {
        int[] temp = new int[ei - si + 1];
        int i = si;// iterator for left merge
        int j = mid + 1;// iterator for right merge
        int k = 0; // iterator for temp
        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;

        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        // copy temp to original array
        for (int x = 0; x < temp.length; x++) {
            arr[si + x] = temp[x];
        }

    }

    public static void main(String[] args) {
        int[] arr = { 2, 6, 7, 1, 5, 3, 4 };
        mergeSort(arr, 0, arr.length - 1);
        printarry(arr);

    }
}
