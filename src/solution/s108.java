package solution;

//将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
//
// 示例:
//
// 给定有序数组: [-10,-3,0,5,9],
//
//一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
//
// Related Topics 树 深度优先搜索


public class s108 {

    TreeNode root;
    int [] nums2;


    void buildTree(int value){

    }


    public TreeNode sortedArrayToBST(int[] nums) {

        root = new TreeNode(nums[nums.length/2]);

        nums2 = nums;




        return root;

    }


    public static void main(String[] args) {



        s108 s108 = new s108();

        int [] nums = {-10,-3,0,5,9};
        s108.sortedArrayToBST(nums);
    }

}
