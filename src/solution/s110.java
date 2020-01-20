package solution;


//给定一个二叉树，判断它是否是高度平衡的二叉树。
//
// 本题中，一棵高度平衡二叉树定义为：
//
//
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
//
//
// 示例 1:
//
// 给定二叉树 [3,9,20,null,null,15,7]
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// 返回 true 。
//
//示例 2:
//
// 给定二叉树 [1,2,2,3,3,null,null,4,4]
//
//        1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
//
//
// 返回 false 。
// Related Topics 树 深度优先搜索


public class s110 {

    boolean flag = true;

    int order(TreeNode root){
        if (root == null)
            return 0;

        int hl = order(root.left); //左子树的高度
        int hr = order(root.right);//右子树的高度

        if (Math.abs(hl - hr) >= 2){
            flag = false;
        }

        return Math.max(hl,hr) + 1;//当前结点的高度为 左右子树的高度较大者+1

    }


    //左子树 与 右子树 高度之差不超过 + - 1
    public boolean isBalanced(TreeNode root) {

        order(root);

        return flag;
    }


    public static void main(String[] args) {
        s110 s110 = new s110();

        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(s110.isBalanced(root));



        TreeNode root2;

        root2 = BinaryTree.buildTree("[1,2,2,3,3,null,null,4,4]");

        System.out.println(BinaryTree.LevelOrder(root2));


        System.out.println(s110.isBalanced(root2));




        //
    }

}
