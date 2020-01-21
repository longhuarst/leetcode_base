package solution;

//给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例:
//给定如下二叉树，以及目标和 sum = 22，
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \      \
//        7    2      1
//
//
// 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
// Related Topics 树 深度优先搜索


// [5,4,8,11,null,13,4,7,2,null,null,null,null,null,1]



public class s112 {

    int target = 0;
    boolean flag = false;
    //和 题111 一样
    // 都是 利用二叉树的遍历算法 递归方式， 记录当前结点的路径和


    void order(TreeNode root, int cur) {
        if (root == null) {
            return;
        }

        cur += root.val;

        if (cur == target && root.left == null && root.right == null) {
            flag = true;
            return;
        }

        order(root.left, cur);
        if (flag == true)
            return;
        order(root.right, cur);


    }

    public boolean hasPathSum(TreeNode root, int sum) {

        if (root == null)
            return false;
        target = sum;
        order(root,0);

        return flag;

    }

    public static void main(String[] args) {


        s112 s112 = new s112();

        TreeNode root = null;

        root = BinaryTree.buildTree("[5,4,8,11,null,13,4,7,2,null,null,null,null,null,1]");

        System.out.println(s112.hasPathSum(root,22));

    }
}
