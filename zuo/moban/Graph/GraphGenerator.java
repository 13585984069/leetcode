package leetcode.zuo.moban.Graph;

/**
 * @author JJChen
 * @version 1.0
 */
public class GraphGenerator {
    public static Graph createGraph(Integer[][] matrix){
        // matrix[0][0] 表示出点， matrix[0][1]表示入点， matrix [0][1] 表示weight
        Graph graph = new Graph();
        for (int i = 0; i < matrix.length; i++) {
            Integer from = matrix[i][0];
            Integer to = matrix[i][1];
            Integer weight = matrix[i][2];
            // 向图里添加点
            if(!graph.nodes.containsKey(from)){
                // 添加出点信息
                graph.nodes.put(from, new Node(from));
            }
            // 添加入点信息
            if(!graph.nodes.containsKey(to)){
                graph.nodes.put(to, new Node(to));
            }
            // 向点里添加信息
            // 在出点中加入，属于自己的边，自己的邻接点，出度
            // 在入点中更新入度
            // 在图中加入这个边， 点在上面已经加过了
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge edge = new Edge(weight, fromNode, toNode);
            fromNode.out++;
            toNode.in++;
            fromNode.nexts.add(toNode);
            fromNode.edges.add(edge);
            graph.edges.add(edge);
        }
        return graph;
    }
}
