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

    TreeNode rootx;
    int [] nums2;


    void buildTreeLeft(TreeNode root, int min, int max){
        if(min == max) {
            root.left = new TreeNode(nums2[min]);
        }else if (min < max){
            root.left = new TreeNode(nums2[min + (max - min + 1) / 2]);
            buildTreeLeft(root.left,min,min + (max - min + 1) / 2-1);
            buildTreeRight(root.left,min + (max - min + 1) / 2+1, max);
        }

    }

    void buildTreeRight(TreeNode root, int min, int max){
        if(min == max) {
            root.right = new TreeNode(nums2[min]);
        }else if (min < max){
            root.right = new TreeNode(nums2[min + (max - min + 1) / 2]);
            buildTreeLeft(root.right,min,min + (max - min + 1) / 2-1);
            buildTreeRight(root.right,min + (max - min + 1) / 2+1, max);
        }

    }



    public TreeNode sortedArrayToBST(int[] nums) {

        //root = new TreeNode(nums[nums.length/2]);

        nums2 = nums;

        if (nums.length != 0){
            rootx = new TreeNode(nums[(nums.length)/2]);
            buildTreeLeft(rootx,0, (nums.length)/2 - 1);
            buildTreeRight(rootx,(nums.length)/2 + 1 , nums.length-1);
        }





        return rootx;

    }


    public static void main(String[] args) {



        s108 s108 = new s108();

        int [] nums = {-10,-3,0,5,9};
        s108.sortedArrayToBST(nums);


    }

}
