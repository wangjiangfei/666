import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String mStr = in.nextLine();
        String pStr = in.nextLine();
        char[] mid = mStr.toCharArray();
        char[] post = pStr.toCharArray();

        TreeNode root = buildTreeWithMidAndPost(mid, post);
        String res = preTraversal(root);
        System.out.println(res);
    }

    /**
     * 根据中序序列、后序序列建立一颗二叉树
     * @param mid
     * @param post
     * @return
     *
     * 0123
     * BADC
     *
     * 0123
     * BDCA
     */
    public static TreeNode buildTreeWithMidAndPost(char[] mid, char[] post) {
        if (mid.length <= 0 || post.length <= 0) {
            return null;
        }
        char postEndStr = post[post.length - 1];// 返回后序序列的最后一个字符
        TreeNode root = new TreeNode(postEndStr);
        int index = locateElemOfMid(mid, postEndStr);
        root.left = buildTreeWithMidAndPost(
                Arrays.copyOfRange(mid, 0, index),
                Arrays.copyOfRange(post, 0, index)
        );
        root.right = buildTreeWithMidAndPost(
                Arrays.copyOfRange(mid, index + 1, post.length),
                Arrays.copyOfRange(post, index, post.length - 1)
        );
        return root;
    }

    /**
     * 返回中序序列中某字符的位置
     * @param mid
     * @param ch
     * @return
     */
    public static int locateElemOfMid(char[] mid, char ch) {
        for (int i = 0; i < mid.length; i++) {
            if (mid[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 先序遍历二叉树
     * @param root
     * @return
     */
    public static String preTraversal(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helper(root, sb);
        return sb.toString();
    }

    public static void helper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val);
        if (root.left != null) {
            helper(root.left, sb);
        }
        if (root.right != null) {
            helper(root.right, sb);
        }
    }

}

class TreeNode {

    char val;
    TreeNode left;
    TreeNode right;

    public TreeNode(char val) {
        this.val = val;
    }
}
