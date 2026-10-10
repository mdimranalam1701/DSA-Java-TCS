package epamcode;

public class secondlargest {
    public static int find(int[] arr) {
        if (arr.length < 1) {
            return -1;
        }

        int largest = Integer.MIN_VALUE;
        int second = Integer.MAX_VALUE;

        for (int n : arr) {
            if (n > largest) {
                second = largest;
                largest = n;
            } else if (n < largest && n > second) {
                second = n;
            }
        }

        return second;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 20, 5, 2 };
        System.out.println(find(arr));
    }
}
