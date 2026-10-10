import java.util.*;
public class recuersion {
    public static void function(int n){
        if(n==0){
        return;
        }
        function(n-1); // 1 to n;
        System.out.print(n+" ");
        // function(n-1); // n to 1
    }

    // public static void Sum(int n,int sum) {
    //     if(n<1){
    //     System.out.println(sum);
    //     return;
    //     }
    //     Sum(n-1,sum+n);
    // }
    public static int shortsum(int n ){
              if(n == 0){
                return 0;
              }
              return n + shortsum(n-1);
    }
     public static int factorial(int n ){
              if(n == 0){
                return 1;
              }
              return n * factorial(n-1);
    }


    //rever an array
    public static void reverse(int arr[],int i,int j){
       if(i >= j){
        return;
       }
       //swap
       int temp = arr[j];
       arr[j] = arr[i];
       arr[i] = temp;
       reverse(arr,i+1,j-1);

    }

    //palendrom a string reverser read a same like madam rev same ,11211
    public static boolean (string str)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // function(n);
        // Sum(n,0);
        // System.out.println(shortsum(n));
        // System.out.println(factorial(n));
       System.out.println("enter the element");
        int n = sc.nextInt();
        int arr[] = new int[n];
       for(int i=0;i<n;i++){
         arr[i] = sc.nextInt();
       }
        
        reverse(arr, 0, n-1);


       System.out.println("reverse array");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }

    }
}
