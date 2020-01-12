package solution;
//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//
// 说明：本题中，我们将空字符串定义为有效的回文串。
//
// 示例 1:
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
//
//
// 示例 2:
//
// 输入: "race a car"
//输出: false
//
// Related Topics 双指针 字符串


public class s125 {


    public boolean isPalindrome(String s) {

//        ========================================111111111111111111111111111111
        //暴力
        char[] bs = new char[s.length()];
        int length = 0;

        //移除所有除字母 , 数字 外的字符
        for (int i=0;i<s.length();++i){
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                bs[length++] = s.charAt(i);
            }else if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                bs[length++] = (char) (s.charAt(i) - 'A' + 'a');
            }else if (s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                bs[length++] = s.charAt(i);
            }
        }


        //判断是否是回文  双指针  前后扫

        for (int i=0; i< length / 2; ++i){
            if (bs[i] != bs[length - i -1]){
                return false;
            }
        }

        return true;



        }






        public boolean isPalindrome2(String s){
//        ========================================222222222222222222222222222222
            //双指针 一次扫描

            int head = 0;//
            int tail = s.length() - 1;
            char chead;
            char ctail;

            //最大步长限定 时间复杂度 T = O(n)
            for (int i=0;i<s.length();++i){
                //截止条件
                if (head >= tail)
                    break;



                //获取 chead
                while(true){
                    chead = s.charAt(head);
                    if (chead >= 'a' && chead <= 'z'){
                        break;
                    }else if (chead >= 'A' && chead <= 'Z'){
                        chead = (char) (chead - 'A' + 'a');
                        break;
                    }else if (chead >= '0' && chead <= '9'){
                        break;
                    }else{
                        head++; //非法字符
                    }
                    if (head >= tail){
                        return true;
                    }
                }

                //获取 ctail

                while(true){
                    ctail = s.charAt(tail);
                    if (ctail >= 'a' && ctail <= 'z'){
                        break;
                    }else if (ctail >= 'A' && ctail <= 'Z'){
                        ctail = (char) (ctail - 'A' + 'a');
                        break;
                    }else if (ctail >= '0' && ctail <= '9'){
                        break;
                    }else{
                        tail--; //非法字符
                    }
                    if (head >= tail)
                        return true;
                }



                //否定条件
                if (chead  != ctail)
                    return false;

                head++;
                tail--;
        }

            return true;

    }


    public static void main(String[] args) {
        s125 s125 = new s125();
        System.out.println(s125.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(s125.isPalindrome("race a car"));
        System.out.println(s125.isPalindrome("0P"));


        System.out.println(s125.isPalindrome2("A man, a plan, a canal: Panama"));
        System.out.println(s125.isPalindrome2("race a car"));
        System.out.println(s125.isPalindrome2("0P"));


    }
}
