package leetcode.zuo.day4.Tree;

import java.util.LinkedList;

/**
 * @author JJChen
 * @version 1.0
 */
public class isCBT {
    public static void main(String[] args) {
        TreeNode head = TreeUtility.createTree();
        System.out.println(isCBT02(head));
    }

    public static boolean isCBT(TreeNode root){
        if(root == null) return false;
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);
        while(!treeNodes.isEmpty()){
            root = treeNodes.pop();
            if(root.left == null && root.right != null){
                return false;
            }
            if(root.right == null){
                while (!treeNodes.isEmpty()){
                    root = treeNodes.pop();
                    if(root.left != null || root.right != null){
                        return false;
                    }
                }
            }else {
                treeNodes.add(root.left);
                treeNodes.add(root.right);
            }

        }
        return true;
    }

    public static boolean isCBT02(TreeNode root){
        if(root == null) return false;
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);
        boolean leaf = false;
        while (!treeNodes.isEmpty()){
            root = treeNodes.poll();
            if((root.left == null && root.right!=null) ||(leaf && (root.left != null||root.right != null))){
                return false;
            }
            if(root.left != null){
                treeNodes.add(root.left);
            }
            if(root.right != null){
                treeNodes.add(root.right);
            }else {
                leaf = true;           }
        }
        return true;
    }
}
