package leetcode.zuo.MidClass.day1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JJChen
 * @version 1.0
 */
public class GeneratorTree {
    public static List<TreeNode> generateTrees(int n){
        return generate(1, n);
    }
    public static List<TreeNode> generate(int start, int end){
        ArrayList<TreeNode> res = new ArrayList<>();
        if(start > end) res.add(null);
        TreeNode head = null;
        for (int i = start; i < end + 1; i++) {
            head = new TreeNode(i);
            List<TreeNode> lsub = generate(start, i - 1);
            List<TreeNode> rsub = generate(i + 1, end);
            for (TreeNode left : lsub) {
                for (TreeNode right : rsub) {
                    head.left = left;
                    head.right = right;
                    res.add(cloneTree(head));
                }
            }
        }
        return res;
    }

    public static TreeNode cloneTree(TreeNode head){
        if(head == null){
            return null;
        }
        TreeNode node = new TreeNode(head.val);
        node.left = cloneTree(head.left);
        node.right = cloneTree(head.right);
        return node;
    }
    public static void printTree(TreeNode head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(TreeNode head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.val + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(Problem06_UniqueBST.tree(n));
        List<TreeNode> res = generateTrees(n);
        for (TreeNode node : res) {
            printTree(node);
        }
    }

}
