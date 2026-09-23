package String;
import java.util.*;
public class firstnonrepeat {

    public static void main(String[] args) {
        String s = "aabbcdde";
        HashMap<Character,Integer> map = new HashMap<>();
        for(char i : s.toCharArray()){
            map.put(i,map.getOrDefault(i, 0)+1);
        }

        for(char ch : s.toCharArray()){
            if(map.get(ch) == 1){
                System.out.println("First occurace char is: "+ch);
                return;
            }
        }
    }
}

// int nonRepeatingCount = 0;

// for (char ch : s.toCharArray()) {
//     if (map.get(ch) == 1) {
//         nonRepeatingCount++;

//         if (nonRepeatingCount == 2) {
//             System.out.println("Second non-repeating character is: " + ch);
//             return;
//         }
//     }
// }

// System.out.println("Second non-repeating character not found");
