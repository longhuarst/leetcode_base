package solution;

//给定一个二叉树，检查它是否是镜像对称的。
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
//
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
//
//
// 说明:
//
// 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
// Related Topics 树 深度优先搜索 广度优先搜索

public class s101 {

    boolean order(TreeNode p, TreeNode q){
        if (p == null || q == null){
            if (p == null && q== null) return true;
            return false;
        }

        if (p.val != q.val) return false;

        if (order(p.left, q.right) == false) return false;
        if (order(p.right, q.left) == false) return false;

        return true;
    }



    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return order(root.left, root.right);
    }



    public static void main(String[] args) {
        s101 s101 = new s101();

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(s101.isSymmetric(root));

    }
}
