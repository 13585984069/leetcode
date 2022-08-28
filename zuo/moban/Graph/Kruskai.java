package leetcode.zuo.moban.Graph;

import java.util.*;

/**
 * @author JJChen
 * @version 1.0
 * 会用到并查集，但是这里先用简单方法替代
 */
public class Kruskai {
    public static class mySets{
        public HashMap<Node, List<Node>> setMap;
        // 把所有节点与各自对应的set 放进hashtable
        public mySets(List<Node> nodes){
            for(Node cur: nodes){
                List<Node> set = new ArrayList<>();
                set.add(cur);
                setMap.put(cur, set);
            }
        }
        public void ceshi(){
            Node node = new Node(3);
        }
        public boolean isSameSet(Node from, Node to){
            return (setMap.get(from) == setMap.get(to));
        }

        public void union(Node from, Node to){
            List<Node> fromSet = setMap.get(from);
            List<Node> toSet = setMap.get(to);
            for(Node toNode: toSet){
                fromSet.add(toNode);
                setMap.put(toNode, fromSet);
            }
        }
    }

    public static Set<Edge> kruskalMST(Graph graph){
        // 将所有边从小到大排序，取一条边，看这个边是否和已经连在一起的区域会形成环，如果不形成环，把这个边加入
        // 如何判断是否形成环： 并查集，主要就是看edge 已经连玩的from对应有很多连在一起的node，如果to所连接的节点都不在这个集合中，
        // 就加入并且把所有节点加到from中
        mySets mysets = new mySets((List<Node>) graph.nodes.values());
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });
        for(Edge edge:graph.edges){
            priorityQueue.add(edge);
        }
        Set<Edge> result = new HashSet<>();
        while(!priorityQueue.isEmpty()){
            Edge edge = priorityQueue.poll();
            if(!mysets.isSameSet(edge.from, edge.to)){
                result.add(edge);
                mysets.union(edge.from, edge.to);
            }
        }
        return result;
    }
}
