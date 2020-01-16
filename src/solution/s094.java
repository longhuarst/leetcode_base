package solution;

//给定一个二叉树，返回它的中序 遍历。
//
// 示例:
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2]
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树 哈希表


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */



public class s094 {

//    MidOrder( root ):
//        if (root == null)
//            return;
//        MidOrder(root.left);
//        get val;
//        midorder(root.right);

    //递归
    void MidOrder(TreeNode root,List<Integer> list){
        if (root == null)
            return;
        MidOrder(root.left,list);
        list.add(root.val);
        MidOrder(root.right,list);

    }




    public List<Integer> inorderTraversal(TreeNode root) {

//        1.递归实现
        /*
            Accepted
            68/68 cases passed (1 ms)
            Your runtime beats 71.5 % of java submissions
            Your memory usage beats 39.36 % of java submissions (34.8 MB)
        */

        List<Integer> list = new ArrayList<>();
        MidOrder(root, list);

        return list;







    }



    public List<Integer> inorderTraversal2(TreeNode root) {
        //非递归中序遍历

        //中序遍历 left - root - right   利用栈

        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();

        while(!stack.empty() || root != null){
            if (root != null){
                stack.push(root);
                root = root.left;
            }else{
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }

        }

        return list;

    }
    public static void main(String[] args) {
        s094 s094 = new s094();

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);


        System.out.println(s094.inorderTraversal2(root));

    }
}
