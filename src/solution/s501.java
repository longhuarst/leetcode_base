package solution;



//给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
//
// 假定 BST 有如下定义：
//
//
// 结点左子树中所含结点的值小于等于当前结点的值
// 结点右子树中所含结点的值大于等于当前结点的值
// 左子树和右子树都是二叉搜索树
//
//
// 例如：
//给定 BST [1,null,2,2],
//
//    1
//    \
//     2
//    /
//   2
//
//
// 返回[2].
//
// 提示：如果众数超过1个，不需考虑输出顺序
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
// Related Topics 树


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class s501 {
    Map<Integer,Integer> map;

    void order(TreeNode root){
        if (root == null)
            return;

        Integer cnt = map.get(root.val);
        if (cnt == null)
            map.put(root.val,1);
        else
            map.put(root.val,cnt+1);

        order(root.left);
        order(root.right);

    }

    public int[] findMode(TreeNode root) {
        map = new HashMap<>();
        List<Integer> maxList = new ArrayList<>();

        order(root);
        int max = -1;

        for (Map.Entry<Integer,Integer> entry:
             map.entrySet()) {
            int value = entry.getValue();
            if (value > max) {
                max = value;
                maxList.clear();
                maxList.add(entry.getKey());
            }else if (value == max){
                maxList.add(entry.getKey());
            }
        }

        int [] ret = new int[maxList.size()];
        int pos = 0;
        for (Integer value:
             maxList) {
            ret[pos] = maxList.get(pos);
            pos++;
        }

        return ret;
    }



}
