package String;
import  java.util.*;
public class frequency {
    public static void main(String[] args) {
        String s = "hello";
        Map<Character,Integer> map = new HashMap<>();

        for(char ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        System.out.print(map);

    }
}
