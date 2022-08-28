package leetcode.zuo.moban.Graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author JJChen
 * @version 1.0
 */
public class Node {
    // 自己的数据项  比如城市0， 那么它的value就是0；A城市的话就改成string
    public int value ;
    // 入度，从其他点指向本身
    public int in;
    // 出度， 本身指向其他点
    // 无向图 入度出度相同
    public int out;
    // 邻居节点有哪些, 发散出去的边直接相连的点
    public ArrayList<Node> nexts;
    // 发散出去的边
    public ArrayList<Edge> edges;

    public Node(int value) {
        this.value = value;
        this.in = 0;
        this.out = 0;
        this.nexts = new ArrayList<>();
        this.edges = new ArrayList<>();
    }
}
