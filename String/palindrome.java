package String;

public class palindrome {
    public static boolean palindromecheck(String s){
        int st = 0;
        int end = s.length()-1;
        while(st < end){
            if(s.charAt(st) != s.charAt(end)){
                return false;
            }
            st++;
            end--;
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "madam";
        if(palindromecheck(s)){
            System.out.println("palindrom");
        }else{
            System.out.println("not palindrome");
        }
    }
}
