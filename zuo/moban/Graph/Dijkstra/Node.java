package leetcode.zuo.moban.Graph.Dijkstra;

import java.util.ArrayList;

/**
 * @author JJChen
 * @version 1.0
 */
public class Node {
    public int val;
    public int in;
    public int out;
    public ArrayList<Node> nexts;
    public ArrayList<Edge> edges;

    public Node(int val) {
        this.val = val;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<Edge>();
    }
}
