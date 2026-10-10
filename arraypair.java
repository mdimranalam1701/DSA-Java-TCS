import java.util.*;
public class arraypair {
    public static void printpair(int array[]){
        for(int i=0;i<array.length;i++){
            int cur = array[i];
            for(int j=i+1;j<array.length;j++){
                System.out.println("("+cur+","+array[j]+")"+", ");
                
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int array[] = {2,4,6,8,10};
        printpair(array);
    }
}
