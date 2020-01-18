package solution;

//给定一个二叉树，找出其最大深度。
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例：
//给定二叉树 [3,9,20,null,null,15,7]，
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// 返回它的最大深度 3 。
// Related Topics 树 深度优先搜索

public class s104 {

    int max;
    int cur;



    void order(TreeNode root){
        cur++;
        if (cur > max){
            max = cur;
        }

        if (root == null) {
            cur--;
            return;
        }

        order(root.left);
        order(root.right);

        cur--;
    }


    public int maxDepth(TreeNode root) {

        max = 0;
        cur = 0;

        order(root);

        return max-1;
    }


    public static void main(String[] args) {

        s104 s104 = new s104();

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);


        System.out.println(s104.maxDepth(root));

    }
}
