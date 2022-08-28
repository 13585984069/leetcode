package leetcode.zuo.day6;

import java.util.HashMap;

/**
 * @author JJChen
 * @version 1.0
 */
public class RandomPool<T> {
    HashMap<T, Integer> keyIndexMap;
    HashMap<Integer, T> indexKeyMap;
    int size;
    public RandomPool() {
        this.keyIndexMap = new HashMap<>();
        this.indexKeyMap = new HashMap<>();
        this.size = 0;
    }

    public void insert(T key){
        if(!keyIndexMap.containsKey(key)){
            keyIndexMap.put(key, size);
            indexKeyMap.put(size++, key);
        }
    }
    public T getRandom(){
        if(size == 0){
            return null;
        }
        int index = (int)(Math.random() *size);
        return indexKeyMap.get(index);
    }

    public void delete(T key){
        if(keyIndexMap.containsKey(key)){
            int index = keyIndexMap.get(key);
            int last = size - 1;
            T lastNode = indexKeyMap.get(last);
            keyIndexMap.put(lastNode, index);
            indexKeyMap.put(index,lastNode);
            indexKeyMap.remove(last);
        }
    }
}
