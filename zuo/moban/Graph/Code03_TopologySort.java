package leetcode.zuo.moban.Graph;


import java.util.*;

/**
 * @author JJChen
 * @version 1.0
 */
public class Code03_TopologySort {
    // 这个应用场景在工程编译过程中，比如A包依赖B包，B依赖C，需要把这个顺序里出来
    // 就是一张没有环的有向图
    // 先看哪个点入度为0，那么这个点必定是头节点，然后把这个点的入度和及其影响擦除
    public  static List<Node> sortedTopology(Graph graph){
        List<Node> res = new ArrayList<>();
        // key: 某一个node  value:剩余的入度
        HashMap<Node, Integer> inMap = new HashMap<>();
        Queue<Node> zeroInQueue = new LinkedList<>();
        for(Node node: graph.nodes.values()){
            // 把所有节点和对应的入度放入hashmap
            inMap.put(node, node.in);
            // 因为无环，肯定有一个或多个入度为0
            if(node.in == 0){
                zeroInQueue.add(node);
            }
        }
        while(!zeroInQueue.isEmpty()){
            Node zeroInNode = zeroInQueue.poll();
            res.add(zeroInNode);
            for(Node outNode:zeroInNode.nexts){
                inMap.put(outNode, inMap.get(outNode)-1);
                // 不会重复，因为只有入度为0才加入res，一但为0，那么肯定没有别的会和这个点相连
                if(outNode.in == 0){
                    zeroInQueue.add(outNode);
                }
            }

        }
        return res;

    }
}
