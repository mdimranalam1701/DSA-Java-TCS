package String;

import java.util.*;
public class reverseword {
    public static String reverseword(String s){
        String[] words = s.trim().split("\\s+");
        // \\s+ handel multiple space
        StringBuilder sb = new StringBuilder();

        for(int i = words.length-1;i>=0;i--){
            sb.append(words[i]);
            //if they said rever the leter as well : result.append(new StringBuilder(words[i]).reverse());
            if(i != 0){
                sb.append(" ");
            }
        }

        return sb.toString();

    }
    public static void main(String[] args) {
        String s = "I love               Java";
        System.out.println(reverseword(s));
    }
}
