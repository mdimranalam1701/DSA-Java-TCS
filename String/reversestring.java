package String;

public class reversestring {

    public static String reverse(String s){
        char[] arr = s.toCharArray();
        int start = 0;
        int end = arr.length-1;
        while(start <  end){
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return new String(arr);
         
    }
    public static void main(String[] args) {
        String  s = "imran";
        System.out.println(reverse(s));
    }
}
