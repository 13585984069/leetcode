package leetcode.zuo.day6;

import java.security.interfaces.ECKey;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @author JJChen
 * @version 1.0
 */
public class UnionFind {
    public static class Element<V> {
        public V value;

        public Element(V value) {
            this.value = value;
        }
    }

    public static class UnionFindSet<V>{
        public HashMap<V, Element<V>> elementMap;
        public HashMap<Element<V>, Element<V>> fatherMap;
        public HashMap<Element<V>, Integer> rankMap;

        public UnionFindSet(List<V> list) {
            elementMap = new HashMap<>();
            fatherMap = new HashMap<>();
            rankMap = new HashMap<>();
            for(V v: list){
                Element<V> element = new Element<>(v);
                elementMap.put(v, element);
                fatherMap.put(element, element);
                rankMap.put(element, 1);
            }
        }

        public Element<V> findHead(Element<V> element){
            Stack<Element<V>> stack = new Stack<>();
            // 如果该元素不是头元素，不断网上找
            while(element != fatherMap.get(element)){
                stack.push(element); // 用于扁平化优化
                element = fatherMap.get(element);
            }
            // 将所有遍历到的元素，直接指向head元素，后面再查询起来就快了， 经过证明，在查询次数多于1000？大概这个数往上
            // 时间复杂度是O(1);
            while (!stack.isEmpty()){
                fatherMap.put(stack.pop(), element);
            }
            return element;
        }

        public boolean isSameSet(V a, V b){
            if(elementMap.containsKey(a) && elementMap.containsKey(b)){
                return findHead(elementMap.get(a)) == findHead(elementMap.get(b));
            }
            return false;
        }

        public void union(V a, V b){
            if(elementMap.containsKey(a) && elementMap.containsKey(b)){
                Element<V> aHead = findHead(elementMap.get(a));
                Element<V> bHead = findHead(elementMap.get(b));
                // 如果两个头不相等，说明是两片区域，那么联通
                if(aHead != bHead){
                    Element<V> big = rankMap.get(aHead) >= rankMap.get(bHead)? aHead: bHead;
                    Element<V> small = big == aHead? bHead:aHead;
                    // 两个区域联通
                    fatherMap.put(small, big);
                    rankMap.put(big, rankMap.get(big) + rankMap.get(small));
                    rankMap.remove(small);
                }
            }
        }



    }
}
