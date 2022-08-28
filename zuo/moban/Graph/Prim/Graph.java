package leetcode.zuo.moban.Graph.Prim;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author JJChen
 * @version 1.0
 */
public class Graph {
    public HashMap<Integer, Node> nodes;
    public HashSet<Edge> edges;

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}
