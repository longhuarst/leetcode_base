package solution;
//给定一个所有节点为非负值的二叉搜索树，求树中任意两节点的差的绝对值的最小值。
//
// 示例 :
//
//
//输入:
//
//   1
//    \
//     3
//    /
//   2
//
//输出:
//1
//
//解释:
//最小绝对差为1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
//
//
// 注意: 树中至少有2个节点。
// Related Topics 树


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class s530 {

    int min;
    Set<Integer> set;

    void order(TreeNode root){
        if (root==null)
            return;

        set.add(root.val);


        order(root.left);
        order(root.right);
    }

    public int getMinimumDifference(TreeNode root) {

        min = Integer.MAX_VALUE;

        set = new HashSet<>();


        order(root);


        Integer [] arr = new Integer[set.size()];
        set.toArray(arr);

        //Integer [] arr = (Integer[]) set.toArray();

        Arrays.sort(arr);

        for (int i=0;i<arr.length-1;++i){
            int v = arr[i+1] - arr[i];
            if (v < min)
                min = v;
        }

        return min;

    }

    public static void main(String[] args) {

    }
}
