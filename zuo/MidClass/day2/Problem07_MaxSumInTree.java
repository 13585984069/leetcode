package leetcode.zuo.MidClass.day2;

import leetcode.zuo.day6.TreeNode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author JJChen
 * @version 1.0
 */
public class Problem07_MaxSumInTree {
    public static int maxSumRecursive(TreeNode head){
        return process(head,  0);
    }
    public static int process(TreeNode head, int pre){
        if(head == null) return 0;
        if(head.left == null && head.right == null){
            return pre + head.val;
        }
        int leftCount = process(head.left, pre + head.val);
        int rightCount = process(head.right,  pre + head.val);
        return Math.max(leftCount, rightCount);
    }
    public static int maxSumNoRecursive(TreeNode head){
        if(head == null) return 0;
        Deque<TreeNode> stack = new LinkedList<>();
        HashMap<TreeNode, Integer> sumMap = new HashMap<>();
        stack.push(head);
        sumMap.put(head, head.val);
        int max = 0;
        while(!stack.isEmpty()){
            head = stack.pop();
            if(head.left == null && head.right == null){
                max = Math.max(max, sumMap.get(head));
            }
            if(head.right != null){
                sumMap.put(head.right, sumMap.get(head) + head.right.val);
                stack.push(head.right);
            }
            if(head.left != null){
                sumMap.put(head.left, sumMap.get(head) + head.left.val);
                stack.push(head.left);
            }

        }
        return max;
    }
    public static void main(String[] args) {
        TreeNode head = new TreeNode(4);
        head.left = new TreeNode(1);
        head.left.right = new TreeNode(5);
        head.right = new TreeNode(-7);
        head.right.left = new TreeNode(3);
        System.out.println(maxSumRecursive(head));
        System.out.println(maxSumNoRecursive(head));

    }
}
