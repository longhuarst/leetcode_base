package solution;

//给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
//
// 例如：
//给定二叉树 [3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回其自底向上的层次遍历为：
//
// [
//  [15,7],
//  [9,20],
//  [3]
//]
//
// Related Topics 树 广度优先搜索


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class s107 {

    int cur;
    int max;
    Map<Integer,List<Integer>> map;

    //先序遍历
    void order(TreeNode root){
        cur++;
        if (cur > max){
            max = cur;
        }

        if (root == null){
            cur--;
            return;
        }


        List list = map.get(cur);
        if (list!=null)
            list.add(root.val);
        else{
            list = new ArrayList();
            list.add(root.val);
            map.put(cur,list);
        }


        order(root.left);
        order(root.right);

        cur--;
        return;
    }


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        cur = 0;
        max = 0;
        map = new HashMap<>();

        order(root);

        List list = new ArrayList();

        for (int i=map.size(); i>0; --i){
            list.add(map.get(i));
        }

        return list;
    }


    public static void main(String[] args) {


        Map<Integer, List> map2 = new HashMap<>();
        List list = new ArrayList();
        list.add(1);
        map2.put(1,list);
        map2.get(1).add(2);

        System.out.println(map2);




        s107 s107 = new s107();

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);


        System.out.println(s107.levelOrderBottom(root));

    }
}
