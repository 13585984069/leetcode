package leetcode.zuo.moban.Graph;

/**
 * @author JJChen
 * @version 1.0
 */
public class Edge {
    // 表示这条边距离
    public int weight;
    // 无向边有一个就行
    // 从哪里出来的
    public Node from;
    // 到哪里去
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
