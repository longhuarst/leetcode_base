package solution;

//你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
//
// 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
//
// 示例 1:
//
//
//输入: 二叉树: [1,2,3,4]
//       1
//     /   \
//    2     3
//   /
//  4
//
//输出: "1(2(4))(3)"
//
//解释: 原本将是“1(2(4)())(3())”，
//在你省略所有不必要的空括号对之后，
//它将是“1(2(4))(3)”。
//
//
// 示例 2:
//
//
//输入: 二叉树: [1,2,3,null,4]
//       1
//     /   \
//    2     3
//     \
//      4
//
//输出: "1(2()(4))(3)"
//
//解释: 和第一个示例相似，
//除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。
//
// Related Topics 树 字符串


//leetcode submit region begin(Prohibit modification and deletion)



public class s606 {

    String str;

    void order(TreeNode root){
        if (root == null)
            return;

        str += root.val;

        str += "(";

        order(root.left);

        str+= ")";

        str+= "(";

        order(root.right);

        str+= ")";

        if (str.charAt(str.length()-2) == '('){
            str = str.substring(0,str.length()-2);
            if (str.charAt(str.length()-2) == '('){
                str = str.substring(0,str.length()-2);
            }
        }

    }


    public String tree2str(TreeNode t) {
        str = "";

        if (t == null)
            return str;

        order(t);


        return str;
    }


    public static void main(String[] args) {


        s606 s606 = new s606();

        TreeNode root = BinaryTree.buildTree("[1,2,3,null,5]");

        System.out.println(s606.tree2str(root));


    }
}
