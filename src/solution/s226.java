package solution;


//翻转一棵二叉树。
//
// 示例：
//
// 输入：
//
//      4
//   /   \
//  2     7
// / \   / \
//1   3 6   9
//
// 输出：
//
//      4
//   /   \
//  7     2
// / \   / \
//9   6 3   1
//
// 备注:
//这个问题是受到 Max Howell 的 原问题 启发的 ：
//
// 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
// Related Topics 树





public class s226 {


    void order(TreeNode root){
        if (root == null)
            return;

        TreeNode pTmp = root.left;
        root.left = root.right;
        root.right = pTmp;

        order(root.left);
        order(root.right);

    }

    public TreeNode invertTree(TreeNode root) {


        order(root);


        return root;

    }


    public static void main(String[] args) {

        s226 s226 = new s226();

        TreeNode root = null;

        root = BinaryTree.buildTree("[4,2,7,1,3,6,9]");




        s226.invertTree(root);

        System.out.println(BinaryTree.LevelOrder(root));


    }

}
