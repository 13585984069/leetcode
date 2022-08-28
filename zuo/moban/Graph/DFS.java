package leetcode.zuo.moban.Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

/**
 * @author JJChen
 * @version 1.0
 */
public class DFS {
    public static void DFS(Node node){
        if(node == null) return;
        HashSet<Node> set = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        set.add(node);
        System.out.println(node.value);
        while(!stack.empty()){
            Node cur = stack.pop();
            // 这个才是真正递归方式
            for(Node next : cur.nexts){
                if(!set.contains(next)){
                    // 找到一条道走到底，再回来
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.value);
                    // 一个节点就够了后面返回再找下面节点
                    break;
                }
            }
        }
    }
}
