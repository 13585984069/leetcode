package leetcode.zuo.moban.Graph.Prim;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author JJChen
 * @version 1.0
 */
public class Prim {
    public static class EdgeComparator implements Comparator<Edge>{
        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }
    public static Set<Edge> primMST(Graph graph){
        Set<Edge> edges = new HashSet<>();
        PriorityQueue<Edge> queue = new PriorityQueue<>(new EdgeComparator());
        HashSet<Node> record = new HashSet<>();
        // 这个外层循环是为了防止整个图是森林，即有些部分不联通，如果是联通的，那就不需要这个
        // K算法中本来就是森林连成树
        for(Node node : graph.nodes.values()){
            if(!record.contains(node)){
                record.add(node);
                queue.addAll(node.edges);
                while(!queue.isEmpty()){
                    Edge edge = queue.poll();
                    if(!record.contains(edge.to)){
                        edges.add(edge);
                        record.add(edge.to);
                        queue.addAll(edge.to.edges);
                    }
                }
            }

        }


        return edges;
    }

    public static Graph generateGraph(Integer[][] matrix){
        Graph graph = new Graph();
        for(int i = 0; i < matrix.length; i++){
            Integer from = matrix[i][0];
            Integer to = matrix[i][1];
            Integer weight = matrix[i][2];

            if(!graph.nodes.containsKey(from)){
                graph.nodes.put(from, new Node(from));
            }
            if(!graph.nodes.containsKey(to)){
                graph.nodes.put(from, new Node(to));
            }
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge edge = new Edge(weight, fromNode, toNode);
            graph.edges.add(edge);
            fromNode.out++;
            fromNode.nexts.add(toNode);
            fromNode.edges.add(edge);
            toNode.in++;
        }
        return graph;
    }
}
