package String;
import  java.util.*;
public class anagrams {
    public static void anagramscheck(String s1, String s2){
        if(s1.length() != s2.length()){
            System.out.println("not anagrams");
            return;
        }

        Map<Character,Integer> map = new HashMap<>();

        for(int i=0;i<s1.length();i++){
            char ch = s1.charAt(i);
            char ch2 = s2.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            map.put(ch2, map.getOrDefault(ch2, 0) - 1);
        }

        boolean isAnagram = true;
        for(int count : map.values()){
            if(count != 0){
                isAnagram = false;
                break;
            }
        }

        if(isAnagram){
            System.out.println("anagrams");
        } else {
            System.out.println("not anagrams");
        }
    }
    public static void main(String[] args) {
        String s1 = "listene";
        String s2 = "istenla";
        anagramscheck(s1, s2);
    }
}
// Time:  O(n)
// Space: O(k), worst case O(n)

// public static void anagramscheck(String s1, String s2) {
//     if (s1.length() != s2.length()) {
//         System.out.println("not anagrams");
//         return;
//     }

//     int[] count = new int[26];

//     for (int i = 0; i < s1.length(); i++) {
//         count[s1.charAt(i) - 'a']++;
//         count[s2.charAt(i) - 'a']--;
//     }

//     for (int value : count) {
//         if (value != 0) {
//             System.out.println("not anagrams");
//             return;
//         }
//     }

//     System.out.println("anagrams");
// }

//time :0(n)
//space: 0(1)