package solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class BinaryTree {

    //从字符串构造
    public static TreeNode buildTree(String target){
        TreeNode root = null;

        if (target.startsWith("[") && target.endsWith("]")){

            target = target.replaceAll(" ","");//去除空格
            target = target.substring(1,target.length()-1);
            System.out.println(target);

            String [] tar = target.split(",");

            if (tar.length == 0)
                return null;

            if (tar.length == 1 && tar[0].equals("null"))
                return null;

            //计算树的高度
            //   一棵 n 个 结点的 完全二叉树 高度为 log 2 N
            int height = (int) (Math.log(tar.length) / Math.log(2)) + 1; // 高度从1 开始

            System.out.println("The tree height = "+height);


            //给定了层次遍历的序列，需要构造二叉树
            //那就直接进行层次遍历赋值

            //java queue 无法加入null 对象 会造成问题
            //Queue<TreeNode> queue = new LinkedBlockingDeque<>();
            Queue<TreeNode> queue = new MyNullQueue<>();

            root = new TreeNode(Integer.valueOf(tar[0]));

            queue.add(root);

            int seq = 1;

            while(!queue.isEmpty()){
                TreeNode cur = queue.remove();

                try {
                    cur.left = new TreeNode(Integer.valueOf(tar[seq++]));
                }catch (Exception e){
                    cur.left = null;
                }

                try {
                    cur.right = new TreeNode(Integer.valueOf(tar[seq++]));
                }catch (Exception e){
                    cur.right = null;
                }

                queue.add(cur.left);
                queue.add(cur.right);



                if (seq >= tar.length)
                    break;
            }





        }else {
            System.out.println("buildTree : err input ");

        }



        return root;
    }



    public static List<String> LevelOrder(TreeNode root){
        // java 自带queue 无法加入 null 造成问题
        //        Queue<TreeNode> queue = new LinkedBlockingDeque<>();

        Queue<TreeNode> queue = new MyNullQueue<>();


        queue.add(root);

        List<String> lst = new ArrayList<>();

        while (!queue.isEmpty()){
            if (queue.size() == 1 && queue.peek() == null){
                break;
            }
            TreeNode cur = queue.remove();
            if (cur != null)
                lst.add(String.valueOf(cur.val));
            else {
                lst.add("null");
                continue;
            }

            if (cur.left != null){
                queue.add(cur.left);
            }else{
                queue.add(null);
                //lst.add("null");
            }

            if (cur.right != null){
                queue.add(cur.right);
            }else {
                queue.add(null);
                //lst.add("null");
            }




        }

        return lst;
    }


}
