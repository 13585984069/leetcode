package leetcode.zuo.day4.Tree;

import java.util.LinkedList;

/**
 * @author JJChen
 * @version 1.0
 */
public class isFBT {
    public static void main(String[] args) {
        TreeNode root = TreeUtility.createTree();
//        System.out.println(isFBT01(root));
        System.out.println(findMinDepth(root));
    }

    // 用深度判断
    public static boolean isFBT01(TreeNode root) {
        if (root == null) return false;
        int depth = findDepth(root);
        int size = preOrder(root);
        System.out.println(depth);
        System.out.println(size);
        if (size == (Math.pow(2, depth) - 1)) {
            return true;
        } else {
            return false;
        }

    }

    public static int preOrder(TreeNode root) {
        if (root == null) return 0;
        return preOrder(root.left) + preOrder(root.right) + 1;
    }

    public static int findDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(findDepth(root.left), findDepth(root.right)) + 1;
    }

    public static int findMinDepth(TreeNode root) {
        if (root == null) return 0;
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        int size = 0;
        int depth = 0;
        while (!nodes.isEmpty()) {
            size = nodes.size();
            depth++;
            while (size > 0) {
                root = nodes.poll();
                if (root.left != null) {
                    nodes.add(root.left);
                }
                if (root.right != null) {
                    nodes.add(root.right);
                }
                if (root.left == null && root.right == null) {
                    return depth;
                }
                size--;
            }
        }
        return depth;

    }
}
