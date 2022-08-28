package leetcode.zuo.moban.TrieTree;

/**
 * @author JJChen
 * @version 1.0
 */
public class TrieTreeCode {
    public static class Trie{
        private TrieNode root; // 头节点
        public Trie(){
            root = new TrieNode();
        }
        public void insert(String word){
            if(word == null) return;
            char[] chars = word.toCharArray();
            TrieNode cur = root;
            root.path++;
            int index = 0;
            for(int i = 0; i < chars.length ;i++){
                index = chars[i] - 'a';
                if(cur.nexts[index] == null){
                    cur.nexts[index] = new TrieNode();
                }
                cur.nexts[index].path++;
                cur = cur.nexts[index];
            }
            cur.end++;
        }

        public int search(String word){
            if(word == null) return 0;
            TrieNode cur = root;
            char[] chars = word.toCharArray();
            int index = 0;
            for(int i = 0; i < chars.length;i++){
                index = chars[i] - 'a';
                if(cur.nexts[index] == null){
                    return 0;
                }
                cur = cur.nexts[index];
            }
            return cur.end;
        }

        public int prefixNumber(String pre){
            if(pre == null) return 0;
            TrieNode cur = root;
            int index = 0;
            char[] chars = pre.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                index = chars[index] - 'a';
                if(cur.nexts[index] == null){
                    return 0;
                }
                cur = cur.nexts[index];
            }
            return cur.path;
        }

        public void delete(String word){
            if(search(word) == 0) return;
            char[] chars = word.toCharArray();
            TrieNode cur = root;
            int index = 0;
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if (--cur.nexts[index].path == 0){
                    // 这里可以直接置null是因为java  GC垃圾回收机制，如果是C++
                    // 那么还得遍历或者用hashset记录删除了哪些点， 然后delete，感觉用递归比较号实现
                    cur.nexts[index] = null;
                    return;
                }
                cur = cur.nexts[index];
            }
            cur.end--;
        }
    }
}
