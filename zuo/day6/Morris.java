package leetcode.zuo.day6;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JJChen
 * @version 1.0
 */
public class Morris {
    public static void morris(TreeNode root){
        if(root == null) return;
        TreeNode cur = root;
        TreeNode rightMost = null;
        while(cur != null){
            rightMost = cur.left;
            if(rightMost != null){
                while(rightMost.right != null && rightMost.right != cur){
                    rightMost = rightMost.right;
                }
                if(rightMost.right == null){
                    rightMost.right = cur;
                    cur = cur.left;
                    continue;
                }else{
                    rightMost.right = null;
                }
            }
            cur = cur.right;
        }

    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        TreeNode cur = root;
        TreeNode rightMost = null;
        while(cur != null){
            rightMost = cur.left;
            if(rightMost != null){
                while(rightMost.right != null && rightMost.right != cur){
                    rightMost = rightMost.right;
                }
                // 第一次到
                if(rightMost.right == null){
                    rightMost.right = cur;
                    res.add(cur.val);
                    cur = cur.left;
                    continue;
                }else{ // 第二次到
                    rightMost.right = null;
                }
            }else{
                res.add(cur.val);
            }
            cur = cur.right;
        }
        return res;
    }

}
