package solution;



//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
//
//        示例 1:
//
//        输入: 121
//        输出: true
//        示例 2:
//
//        输入: -121
//        输出: false
//        解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
//        示例 3:
//
//        输入: 10
//        输出: false
//        解释: 从右向左读, 为 01 。因此它不是一个回文数。


//回文数
public class s009 {

    public boolean isPalindrome(int x) {



        //13ms
        // if (x < 0)
        //     return false;
        // String s = String.valueOf(x);
        // byte [] bs = s.getBytes();

        // //3    1   0 1 2
        // //4    2   0 1 2 3
        // for (int i=0;i<bs.length/2;++i){
        //     if (bs[i] != bs[bs.length-i-1]){
        //         return false;
        //     }
        // }

        // return true;


//        if (x < 0)
//            return false;
//        int [] bs = new int[10];
//        int pos = 0;
//        int len;
//        while(x!=0){
//            bs[pos++] = x%10;
//            x/=10;
//        }
//        len = pos/2;  //0 1 2
//        for (int i=0;i<len;++i){
//            if (bs[i] != bs[pos-i-1]){
//                return false;
//            }
//        }
//        return true;

//        if (x < 0)
//            return false;
//
//        if (x==0)
//            return true;
//
//        int flag = 1000000000;
//        int i=10;
//
//        while (x/flag == 0){
//            flag/=10;
//            i--;
//        }
//
//        for (int j=0;j<i/2;++j){
//            if (x/flag != x%10)
//                return false;
//            x%=flag;
//            flag/=100;
//            x/=10;
//        }
//
//        return true;

        if (x < 0)
            return false;

        if (x==0)
            return true;

        int y=0;
        int z = x;
        while(x!=0){
            y=y*10;
            y+=x%10;
            x=x/10;
        }

        return z == y;


    }

    public static void main(String[] args) {
        s009 s009 = new s009();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(s009.isPalindrome(9999));
        System.out.println(s009.isPalindrome(123));
        System.out.println(s009.isPalindrome(1234));
        System.out.println(s009.isPalindrome(1001));


    }


}
