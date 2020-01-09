package solution;

import java.util.HashMap;
import java.util.Map;

/*
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
* */
public class s003 {


    public int lengthOfLongestSubstring(String s) {

//        if (s.length() == 0)
////            return 0;
////        //
////        int max = 1;
////        int head = 0;
////        int tail = 0;
////
////        char [] cs = s.toCharArray();
////        // a b c d e f
////        // 0 1 2 3 4 5     ----6
////
////
////        for (int i=1;i<s.length();++i){
////            tail++;
////            //下一个和之前的相等则指向下一个，否则计算当前长度与max比较
////            if (cs[head] != cs[tail]){
////                max = Math.max(max,tail-head);
////                head = tail;
////            }else if (i==s.length()-1)
////                tail++;
////        }
////        max = Math.max(max,tail-head);
////
////        return max;


        /*
        *
        *   |
        *   abcabcbb
        *   |
        * */

        int head = 0;
        int max = 1;

        if (s.length() <= 1)
            return s.length();

        char [] cs = s.toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        int i=0;

        Integer pos=0;

        for (;i<s.length();++i){
            pos = map.get(cs[i]);//获取位置
            if (pos != null){//map中存在
                max = Math.max(max,i-head);
                for (int j=head;j<pos;++j) {
                    map.remove(cs[j]);
                }
                head = pos+1;
            }


            map.put(cs[i],i);

        }

        //if (pos == null)
        max = Math.max(max,i-head);

        return max;

    }

    public static void main(String[] args) {
        s003 s003 = new s003();

        System.out.println(s003.lengthOfLongestSubstring("abcabcdd"));  //4

        System.out.println(s003.lengthOfLongestSubstring("abcabcbb"));//3

        System.out.println(s003.lengthOfLongestSubstring("bbbbb"));//1

        System.out.println(s003.lengthOfLongestSubstring("pwwkew"));//3


        System.out.println(s003.lengthOfLongestSubstring(" "));//1

        System.out.println(s003.lengthOfLongestSubstring("au"));//2


        System.out.println(s003.lengthOfLongestSubstring("aab"));//2

        System.out.println(s003.lengthOfLongestSubstring("cdd"));//2

    }
}
