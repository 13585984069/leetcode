package leetcode.zuo.moban.TrieTree;

/**
 * @author JJChen
 * @version 1.0
 */
public class TrieNode {
    public int path; // 有多少个String点经过
    public int end; // 是多少个String的结尾
    public TrieNode[] nexts;

    public TrieNode(){
        path = 0;
        end = 0;
        TrieNode[] nexts = new TrieNode[26];// 一般都是26个小写字母，如果字符数多的话
        // 可以用hashmap<Last, next> 来记录
    }
}
