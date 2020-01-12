package solution;

//将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
// 示例：
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
//
// Related Topics 链表




//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class s021 {


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
       ListNode l3,lp;

       //找到头     将 l3 指向 两个链表较小的那个头 并将较小的 引用 那个向后移动
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        if (l1.val >= l2.val){
            l3 = l1;
            l1 = l1.next;
        }else {
            l3 = l2;
            l2 = l2.next;
        }

        lp = l3;


        while(true){
            if (l1 == null){
                lp.next = l2;
                return l3;
            }
            if (l2 == null){
                lp.next = l1;
                return l3;
            }
            if (l1.val <= l2.val){
                lp.next = l1;
                l1 = l1.next;
                lp = lp.next;

            }else {
                lp.next = l2;
                l2 = l2.next;
                lp = lp.next;
            }
        }




    }



    public static void main(String[] args) {
        s021  s021 = new s021();

        //[1,2,4]
        //[1,3,4]

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);


        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);


        ListNode l3 = s021.mergeTwoLists(l1,l2);

        System.out.print(l3.val);
        l3 = l3.next;
        while (l3!= null){
            System.out.print("->"+l3.val);
            l3 = l3.next;
        }


    }
}
