package solution;

//给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节
//点值之和。
//
// 例如：
//
//
//输入: 二叉搜索树:
//              5
//            /   \
//           2     13
//
//输出: 转换为累加树:
//             18
//            /   \
//          20     13
//
// Related Topics 树


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

public class s538 {
    Map<Integer,Integer> map;
    List<Integer> list;

    void order(TreeNode root){
        if (root == null)
            return;

        list.add(root.val);

        order(root.left);
        order(root.right);

    }

    void order2(TreeNode root){
        if (root == null)
            return;

        root.val = map.get(root.val);

        order2(root.left);
        order2(root.right);
    }

    public TreeNode convertBST(TreeNode root) {
        map = new HashMap<>();
        list = new ArrayList<>();

        order(root);

        Integer [] arr = new Integer[list.size()];
        list.toArray(arr);

        Arrays.sort(arr);

        int sum = 0;
        for (int i=arr.length-1;i>= 0; i--){
            sum += arr[i];
            map.put(arr[i],sum);
        }

        order2(root);

        return  root;
    }


    public static void main(String[] args) {
        s538 s538 = new s538();


        TreeNode root = null;
        root = BinaryTree.buildTree("[5,2,13]");

        s538.convertBST(root);


    }


}
