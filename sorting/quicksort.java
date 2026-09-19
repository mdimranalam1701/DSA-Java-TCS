package sorting;

public class quicksort {
     public static void printarry(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void quickSort(int[] arr,int si, int ei){
        if(si >= ei) return ;
        int pvtidx = partition(arr,si,ei);
        quickSort(arr, si, pvtidx-1);
        quickSort(arr, pvtidx+1, ei);
    }

    public static int partition(int[] arr, int si, int ei){
        int pivot =ei;
        int i = si-1; //space for elmet which are less then  pivot
        for(int j= si;j<arr.length;j++){
            if(arr[j] < arr[pivot]){
                i++;
                //swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        //pivot index
        i++;
        int temp = arr[pivot];
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;

    }
    public static void main(String[] args) {
        int[] arr = {2,6,7,1,5,3,4};
        quickSort(arr, 0, arr.length-1); //nlog(n)
        printarry(arr);

    }
}
