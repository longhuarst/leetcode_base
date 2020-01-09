package t;

public class t007 {


    public int reverse(int x) {


        String s = String.valueOf(x);
        byte[] b = s.getBytes();

        if (s.charAt(0) == '-'){
            for (int i=1;i<=s.length()/2;++i){
                byte t = b[i];
                b[i] = b[s.length()-i];
                b[s.length()-i] = t;
            }
        }else{
            for (int i=0;i<s.length()/2;++i){
                byte t = b[i];
                b[i] = b[s.length()-1-i];
                b[s.length()-1-i] = t;
            }
        }
        int t;
        try {
            t = Integer.parseInt(new String(b));
        }catch (Exception e){
            t=0;
        }
        if (t>0 && x<0 || t<0 && x>0){
            t = 0;
        }
        return t;
    }



    public static void main(String[] args) {
        t007 t007 = new t007();

        System.out.println(t007.reverse(1534236469));




    }
}
