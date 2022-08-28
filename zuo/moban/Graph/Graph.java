package leetcode.zuo.moban.Graph;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author JJChen
 * @version 1.0
 */
public class Graph {

    // 一张图   有点集 和 边集
    // Integer 编号以及点的 状况
    // 如果只有1000个城市，这里的hashmap也可以用数组来表示，通过寻址来找，更快
    public HashMap<Integer, Node> nodes;
    public HashSet<Edge> edges;

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }
}
