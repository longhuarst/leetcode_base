package solution;

//给定一个二叉树，返回所有从根节点到叶子节点的路径。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例:
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
// Related Topics 树 深度优先搜索

import java.util.ArrayList;
import java.util.List;

public class s257 {

    List<String> lst;
    List<Integer> curPathlst;

    void order(TreeNode root){

        if (root == null)
            return;

        curPathlst.add(root.val);

        if (root.left == null && root.right == null){
            String str = "";
            str = curPathlst.get(0).toString();
            for (int i=1;i<curPathlst.size();++i){
                str += "->"+curPathlst.get(i);
            }

            lst.add(str);

        }else{
            order(root.left);
            order(root.right);
        }



        curPathlst.remove(curPathlst.size()-1);

    }



    public List<String> binaryTreePaths(TreeNode root) {

        lst = new ArrayList<>();
        curPathlst = new ArrayList<>();

        if (root != null)
            order(root);


        return lst;
    }


    public static void main(String[] args) {


    }
}
