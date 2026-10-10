package epamcode;

public class mismatch {

    public static int mismatchvalue(String a, String b) {
        if (a.length() != b.length()) {
            return 0;
        }
        a.toLowerCase();
        b.toLowerCase();

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String a = "hello";
        String b = "hallo";

        System.out.println(mismatchvalue(a, b));

    }
}
// time=0(n)