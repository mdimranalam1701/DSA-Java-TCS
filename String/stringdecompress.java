package String;

public class stringdecompress {
    public static String decompress(String s){
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);

            if(Character.isDigit(ch)){
                count = count * 10 + (ch - '0');
                //count = 0 * 10 + ('1' - '0'); // 1
            }else{
                if(count == 0){
                    count =1;
                }

                for(int j =0;j<count;j++){
                    sb.append(ch);
                }
                count = 0;
            }
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        String s = "10a12b4cd";
        System.out.println(decompress(s));
    }
}
