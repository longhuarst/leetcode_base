package solution;

//给定一个二叉树，找出其最小深度。
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例:
//
// 给定二叉树 [3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// 返回它的最小深度 2.
// Related Topics 树 深度优先搜索 广度优先搜索




public class s111 {

    //DFS 遍历

    //利用先序遍历 -- 递归
    // 递归可以知道当前的递归层数，就是当前结点的 离根结点的距离，
    // 只需要记录所有叶子结点 到根结点的 最小值就可以
    // 叶子 结点的特性：  左右 孩子都是null

    int cur = 0;
    int min = Integer.MAX_VALUE;

    void order(TreeNode root){
        cur++;

        if (root == null) {
            cur --;
            return;
        }

        if (root.left == null && root.right == null){
            if (min > cur){
                min = cur;
            }
        }

        order(root.left);
        order(root.right);

        cur--;
    }



    public int minDepth(TreeNode root) {

        if (root == null)
            return 0;

        order(root);

        return min;
    }



    public static void main(String[] args) {

        s111 s111 = new s111();


        TreeNode root = null;

        root = BinaryTree.buildTree("[3,9,20,null,null,15,7]");

        System.out.println(s111.minDepth(root));

    }
}
