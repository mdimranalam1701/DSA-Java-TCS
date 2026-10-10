public class SumofN {
    public static void main(String args[]) {
        int N =  10;
        int sum = 0;
        System.out.println("Finding Sum of " +N+ "Number using for loop");
        for (int i =0; i<=N; i++){
            sum += i;
        }
        System.out.println("sum of first  " + N + " natural number= "+sum);
    }
}
