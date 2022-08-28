package leetcode.zuo.day4.Tree;

import leetcode.zuo.day4.LinkedList.ListNode;

import java.util.*;

/**
 * @author JJChen
 * @version 1.0
 */
public class TreeUtility {
    public static TreeNode createTree(){
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
//        head.left.left = new TreeNode(4);
//        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);
//        head.left.left.left = new TreeNode(8);
//        head.left.left.right = new TreeNode(9);
        return head;
    }
    public static void preOrder01(TreeNode root){
        if(root == null) return;
        System.out.print(root.val + " ");
        preOrder01(root.left);
        preOrder01(root.right);
    }
    // 先序遍历，压栈顺序 右左， 这样出栈时候左右并打印
    public static void preOrder02(TreeNode root){
        if(root == null) return;
        Stack<TreeNode> treeNodes = new Stack<>();
        treeNodes.push(root);
        while (!treeNodes.empty()){
            TreeNode node = treeNodes.pop();
            System.out.print(node.val + " ");
            if(node.right != null){
                treeNodes.push(node.right);
            }
            if(node.left != null){
                treeNodes.push(node.left);
            }
        }
    }

    // 左中右
    public static void InOrder01(TreeNode root){
        if(root == null){
            return;
        }
        InOrder01(root.left);
        System.out.print(root.val +" ");
        InOrder01(root.right);
    }

    public static void Inorder02(TreeNode root){
        if(root == null) return;
        Stack<TreeNode> nodes = new Stack<>();
        while(!nodes.empty() || root !=null){
            if(root != null){
                nodes.push(root);
                root = root.left;
            }else {
                root = nodes.pop();
                System.out.print(root.val +" ");
                root = root.right;
            }
        }

    }

    public static void postOrder01(TreeNode root){
        if(root == null)return;
        postOrder01(root.left);
        postOrder01(root.right);
        System.out.print(root.val +" ");
    }
    public static void postOrder02(TreeNode root){
        if(root == null) return;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while(!stack1.empty()){
            root = stack1.pop();
            stack2.push(root);
            if(root.left != null){
                stack1.push(root.left);
            }
            if(root.right != null){
                stack1.push(root.right);
            }
        }
        while(!stack2.empty()){
            System.out.print(stack2.pop().val + " ");
        }
    }

    public static void BreadthTravel(TreeNode root){
        if(root == null) return;
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);
        while(!treeNodes.isEmpty()){
            root = treeNodes.pop();
            System.out.print(root.val + " ");
            if(root.left != null){
                treeNodes.add(root.left);
            }
            if(root.right != null){
                treeNodes.add(root.right);
            }
        }
    }
    // 哈希表法
    public static  int getMaxWidth(TreeNode root){
        if (root == null) return 0;
        int maxWidth = 0;
        int curWidth = 0;
        int curLevel = 1;
        HashMap<TreeNode, Integer> hashMap = new HashMap<>();
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);
        hashMap.put(root, 1);
        while (!treeNodes.isEmpty()){
            root = treeNodes.poll();
            if(root.left != null){
                treeNodes.add(root.left);
                hashMap.put(root.left, hashMap.get(root) + 1);
            }
            if(root.right !=null){
                treeNodes.add(root.right);
                hashMap.put(root.right, hashMap.get(root) + 1);
            }
            if(hashMap.get(root) > curLevel){
                curWidth = 1;
                curLevel = hashMap.get(root);
            }else {
                curWidth++;
            }
            maxWidth = Math.max(curWidth, maxWidth);
        }
        return maxWidth;
    }

    // 不用hashtable
    public static int getMaxWidth02(TreeNode root){
        if(root == null) return 0;
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        int maxWidth = 0;
        int curWidth = 0;
        TreeNode curLevelEnd = root;
        TreeNode nextLevelEnd = null;
        treeNodes.add(root);
        while (!treeNodes.isEmpty()){
            root = treeNodes.poll();
            if(root.left != null){
                treeNodes.add(root.left);
                nextLevelEnd = root.left;
            }
            if(root.right != null){
                treeNodes.add(root.right);
                nextLevelEnd = root.right;
            }
            curWidth++;
            if(root == curLevelEnd){
                maxWidth = Math.max(curWidth, maxWidth);
                curWidth = 0;
                curLevelEnd = nextLevelEnd;
            }

        }
        return maxWidth;
    }
}
