package leetcode.zuo.moban.Graph.Dijkstra;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author JJChen
 * @version 1.0
 */
public class Dijkstra {
    public static HashMap<Node, Integer> dijkstra1(Node head){
        // 从head 出发到所有点的最小距离
        // key: 从head出发到达哪个点
        // value 从head 出发到key点的距离
        // 如果在表中，没有点T的记录，含义就是从head出发到T这个点的距离为正无穷
        HashMap<Node, Integer> distanceMap = new HashMap<>();
        distanceMap.put(head, 0);
        // 锁住点的记录用hashSet
        HashSet<Node> selectedNodes = new HashSet<>();
        // 选一个没选过并且到head最短的那个点
        Node minNode = getMinDistanceAndUnseletedNode(distanceMap, selectedNodes);
        while(minNode != null){
            // 拿距离
            int distance = distanceMap.get(minNode);
            for(Edge edge : minNode.edges){
                Node toNode = edge.to;
                if(!distanceMap.containsKey(toNode)){
                    distanceMap.put(toNode, distance+edge.weight);
                }
                if(distance + edge.weight < distanceMap.get(toNode)){
                    distanceMap.put(toNode, distance + edge.weight);
                }
            }
            selectedNodes.add(minNode);
            minNode = getMinDistanceAndUnseletedNode(distanceMap,selectedNodes);
        }
        return distanceMap;
    }

    // 找表中最短记录的那个点
    public static Node getMinDistanceAndUnseletedNode(HashMap<Node, Integer> distanceMap, HashSet<Node> selectedNodes){
        int minDistance = Integer.MAX_VALUE;
        Node minNode = null;
        for(Map.Entry<Node, Integer> entry: distanceMap.entrySet()){
            Node node = entry.getKey();
            int distance = entry.getValue();
            if(!selectedNodes.contains(node) && distance< minDistance){
                minDistance = distance;
                minNode = node;
            }
        }
        return minNode;
    }
}
