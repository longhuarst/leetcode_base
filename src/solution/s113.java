package solution;

//给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例:
//给定如下二叉树，以及目标和 sum = 22，
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
//
//
// 返回:
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
//
// Related Topics 树 深度优先搜索





        import java.util.ArrayList;
        import java.util.List;

public class s113 {


    int target;
    List<List<Integer>> lst;
    List<Integer> curlist;//当前的路径表

    void order(TreeNode root, int cur){

        if (root == null)
            return;

        cur += root.val;

        //保存当前路径表
        curlist.add(root.val);


        if (root.left == null && root.right == null && cur == target){

            List<Integer> curlist_cpy = new ArrayList<>();//当前的路径表
            for (int i=0;i<curlist.size();++i){
                curlist_cpy.add(curlist.get(i));
            }

            lst.add(curlist_cpy);//保存当前路径表
        }

        order(root.left, cur);
        order(root.right, cur);

        //递归正常退出一层则清楚最后一个路径
        curlist.remove(curlist.size() - 1);

    }


    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        lst = new ArrayList<>();
        curlist = new ArrayList<>();

        if (root == null)
            return lst;

        target = sum;
        order(root,0);

        return lst;
    }




    public static void main(String[] args) {


        String hello = "123";

        List<String> list = new ArrayList<>();

        list.add(hello);

        hello = "456";


        System.out.println(hello);

        System.out.println(list.get(0));

        s113 s113 = new s113();

        TreeNode root = null;

        root = BinaryTree.buildTree("[5,4,8,11,null,13,4,7,2,null,null,null,null,5,1]");

        System.out.println(s113.pathSum(root,22));
    }
}
