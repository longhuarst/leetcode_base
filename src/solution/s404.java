package solution;


//计算给定二叉树的所有左叶子之和。
//
// 示例：
//
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
//
//
// Related Topics 树

public class s404 {

    int sum;

    void order(TreeNode root, boolean left){
        if (root == null)
            return;

        if (left == true && root.left == null && root.right == null){
            //🍃叶子结点
            sum += root.val;
        }
        order(root.left,true);
        order(root.right,false);

    }

    public int sumOfLeftLeaves(TreeNode root) {
        sum = 0;
        order(root,false);
        return sum;
    }



}
