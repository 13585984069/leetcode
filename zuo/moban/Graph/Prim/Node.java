package leetcode.zuo.moban.Graph.Prim;

import java.util.ArrayList;

/**
 * @author JJChen
 * @version 1.0
 */
public class Node {
    public int value;
    public int in;
    public int out;
    public ArrayList<Node> nexts;
    public ArrayList<Edge> edges;

    public Node(int value) {
        this.value = value;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
