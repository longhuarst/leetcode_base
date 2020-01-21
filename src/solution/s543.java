package solution;

//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
//
// 示例 :
//给定二叉树
//
//
//          1
//         / \
//        2   3
//       / \
//      4   5
//
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。
// Related Topics 树


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;

public class s543 {

    Stack<TreeNode> levelOrderGetInvStack(TreeNode root){
        Queue<TreeNode> queue = new LinkedBlockingDeque<>();

        Stack<TreeNode> stack = new Stack<>();

        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode cur = queue.remove();

            stack.push(cur);

            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);

        }
        return stack;
    }


    public int diameterOfBinaryTree(TreeNode root) {

        if (root == null){
            return 0;
        }

        Stack<TreeNode> stack = levelOrderGetInvStack(root);
        Map<TreeNode,Integer> map = new HashMap<>();

        int len = stack.size();
        int max = 0;
        int cur_val = 0;

        for (int i=0; i<len; ++i){
            TreeNode cur = stack.pop();
            int left,right;
            if (cur.left == null)
                left = 0;
            else
                left = map.get(cur.left);

            if (cur.right == null)
                right = 0;
            else
                right = map.get(cur.right);


            if (cur.left == null && cur.right == null){
                cur_val = 1;//叶子结点
            }else{
                cur_val = Math.max(left,right) + 1;//左右子树高度的较大值 + 1 为当前结点的最大 高度;
                int diam = left + right;
                if (diam > max)
                    max = diam;
            }

            map.put(cur, cur_val);
        }
        return max;
    }


    public static void main(String[] args) {

        s543 s543 = new s543();


        TreeNode root = null;

        root = BinaryTree.buildTree("[1,2]");

        System.out.println(s543.diameterOfBinaryTree(root));


        TreeNode root2 = BinaryTree.buildTree("[1,2,3,4,5]");
        System.out.println(s543.diameterOfBinaryTree(root2));

        TreeNode root3 = BinaryTree.buildTree("[0,0,0,0,null,null,0,null,null,null,0]");
        System.out.println(s543.diameterOfBinaryTree(root3));

    }



    /*
    *
    * Wrong Answer
93/106 cases passed (N/A)
Testcase
[0,0,0,0,null,null,0,null,null,null,0]
Answer
6
Expected Answer
5
    *
    * */
}
