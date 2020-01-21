package solution;

//给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看
//做它自身的一棵子树。
//
// 示例 1:
//给定的树 s:
//
//
//     3
//    / \
//   4   5
//  / \
// 1   2
//
//
// 给定的树 t：
//
//
//   4
//  / \
// 1   2
//
//
// 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
//
// 示例 2:
//给定的树 s：
//
//
//     3
//    / \
//   4   5
//  / \
// 1   2
//    /
//   0
//
//
// 给定的树 t：
//
//
//   4
//  / \
// 1   2
//
//
// 返回 false。
// Related Topics 树


public class s572 {

    boolean isMatch(TreeNode p, TreeNode q){
        if (p == null && q == null)
            return true;
        else if (p != null && q != null){
            if (p.val == q.val){
                if (isMatch(p.left,q.left) == false) return false;
                if (isMatch(p.right,q.right) == false) return false;
                return true;
            }else
                return false;
        }else{
            return false;
        }
    }


    boolean order(TreeNode root,TreeNode t){
        if (root == null)
            return false;

        if (isMatch(root,t) == true){
            return true;
        }

        if (order(root.left,t) == true) return true;
        if (order(root.right,t) == true) return true;

        return false;
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        return  order(s,t);
    }


    public static void main(String[] args) {

    }





}
