package epamcode;

import java.util.*;
public class longestconsicutive {


    public static int consequtive(int[] arr){
        HashMap<Integer,Boolean> map = new HashMap<>();

        for(int num:arr){
            map.put(num,false);
        }

        int largest = 0;
        for(int num:arr){
            //visited skip
            if(map.get(num)){
                continue;
            }

            map.put(num,true);
            int count = 1;

            
            //right
            int curr = num+1;
            while(map.containsKey(curr) && !map.get(curr)){
                map.put(curr,true);
                count++;
                curr++;
            }

            //left
            int leftcurr = num-1;
            while (map.containsKey(leftcurr) && !map.get(leftcurr)) {
                map.put(leftcurr,true);
                leftcurr--;
                count++;
                
            }

            largest = Math.max(largest,count);
        }

        return largest;
    }
    public static void main(String[] args) {
        int[] arr = {100,4,200,1,2,3};

        System.out.println(consequtive(arr));
    }
}