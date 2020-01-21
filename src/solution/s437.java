package solution;



//给定一个二叉树，它的每个结点都存放着一个整数值。
//
// 找出路径和等于给定数值的路径总数。
//
// 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
//
// 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
//
// 示例：
//
// root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
//
//      10
//     /  \
//    5   -3
//   / \    \
//  3   2   11
// / \   \
//3  -2   1
//
//返回 3。和等于 8 的路径有:
//
//1.  5 -> 3
//2.  5 -> 2 -> 1
//3.  -3 -> 11
//
// Related Topics 树





public class s437 {

    int cnt;
    int target;
    int cur;

    void order(TreeNode root){
        if (root == null)
            return;

        cur += root.val;

        if (cur == target) //匹配
            cnt++;


        order(root.left);
        order(root.right);

        cur -= root.val;
    }


    void orderOut(TreeNode root){
        if (root == null)
            return;

        //从当前结点开始遍历子树 🌲
        cur = 0;
        order(root);

        orderOut(root.left);
        orderOut(root.right);
    }




    public int pathSum(TreeNode root, int sum) {
        target = sum;
        cnt = 0;
        orderOut(root);
        return cnt;
    }

}
