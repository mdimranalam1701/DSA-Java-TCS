package epamcode;

public class rotatedarray {

    public static int pivotindex(int[] arr) {
        if (arr.length == 0)
            return 0;

        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > arr[high]) { // why right half
                // left array is sorted
                low = mid + 1;

            } else {
                high = mid;
            }

        }
        return low;
    }

    public static void main(String[] args) {
        int arr[] = { 4, 5, 6, 1, 2, 3 };
        System.out.println(pivotindex(arr));
    }
}
