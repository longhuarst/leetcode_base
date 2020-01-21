package solution;
//给定一个二叉树，计算整个树的坡度。
//
// 一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。
//
// 整个树的坡度就是其所有节点的坡度之和。
//
// 示例:
//
//
//输入:
//         1
//       /   \
//      2     3
//输出: 1
//解释:
//结点的坡度 2 : 0
//结点的坡度 3 : 0
//结点的坡度 1 : |2-3| = 1
//树的坡度 : 0 + 0 + 1 = 1
//
//
// 注意:
//
//
// 任何子树的结点的和不会超过32位整数的范围。
// 坡度的值不会超过32位整数的范围。
//
// Related Topics 树

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;

public class s563 {



    public int findTilt(TreeNode root) {

        if (root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedBlockingDeque<>();
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, Integer> map = new HashMap<>();

        int sum = 0;

        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode cur = queue.remove();

            stack.push(cur);

            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
        }

        while(!stack.empty()){
            TreeNode cur = stack.pop();

            if (cur.left == null && cur.right == null){
                //叶子🍃
                map.put(cur,cur.val);
                sum += 0;
            }else{
                int left, right;

                if (cur.left != null)
                    left = map.get(cur.left);
                else
                    left = 0;

                if (cur.right != null)
                    right = map.get(cur.right);
                else
                    right = 0;

                map.put(cur,left+right+cur.val);
                sum += Math.abs(left - right);

            }
        }

        return sum;

    }




}
