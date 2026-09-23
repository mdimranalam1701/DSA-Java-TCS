package String;
import java.util.*;
public class removeduplicate {
    public static String removeduplicate(String s){
        HashSet<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(char x : s.toCharArray()){
            if(!set.contains(x)){
                set.add(x);
                sb.append(x);
            }
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        String s ="programming";
        System.out.println(removeduplicate(s));
    }
}
