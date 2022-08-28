package leetcode.zuo.moban.Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author JJChen
 * @version 1.0
 */
public class BFS {
    public static void bfs(Node node){
        if(node == null) return;
        Queue<Node> queue = new LinkedList<>();
        // 防止无向图或者有环导入死循环
        HashSet<Node> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            System.out.println(cur.value);
            for(Node next : cur.nexts){
                if(!set.contains(next)){
                    set.add(next);
                    queue.add(next);
                }
            }
        }
    }
}
