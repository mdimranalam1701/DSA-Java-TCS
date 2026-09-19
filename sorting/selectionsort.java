package sorting;

public class selectionsort {
    public static void printarry(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void selectionSort(int[] arr){ //time o(n^2)
        for(int i=0;i<arr.length-1;i++){
                int min = i;
            for(int j = i+1;j<arr.length;j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
                //swap
               
            }
             int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
        }
    }
    public static void main(String[] args) {
        int[] arr = {2,6,7,1,5,3,4};
        selectionSort(arr);
        printarry(arr);
    }
}
