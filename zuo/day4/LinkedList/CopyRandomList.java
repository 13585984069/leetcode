package leetcode.zuo.day4.LinkedList;

import java.util.HashMap;

/**
 * @author JJChen
 * @version 1.0
 */
public class CopyRandomList {
    public static void main(String[] args) {
        HashMap<ListNode, ListNode> nodes = new HashMap<>();
        nodes.put(new ListNode(1), new ListNode(2));
        System.out.println(nodes.get(null));
    }

    // 链表一般用额外空间就是数组、哈希表 O(N)  O(N)
    public ListNode copyRandomList(ListNode head) {
        HashMap<ListNode, ListNode> nodes = new HashMap<>();
        ListNode cur = head;
        while (cur != null){
            nodes.put(cur, new ListNode(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null){
            nodes.get(cur).random = nodes.get(cur.random);
            nodes.get(cur).next = nodes.get(cur.next);
            cur = cur.next;
        }
        return nodes.get(head);
    }

    public static ListNode copyRandomList02(ListNode head){
        if(head == null) return null;
        ListNode cur = head;
        while(cur != null){
            ListNode temp = cur.next;
            ListNode copy = new ListNode(cur.val);
            cur.next = copy;
            cur.next.next = temp;
            cur = temp;
        }
        cur = head;
        while(cur != null){
            if(cur.random == null){
                cur.next.random = null;
            }else{
                cur.next.random = cur.random.next;
            }
            cur= cur.next.next;
        }
        cur = head;
        ListNode copyhead = cur.next;
        ListNode copyCur = copyhead;
        while(cur != null){
            ListNode next = cur.next.next;
            copyCur.next = next == null? null:next.next;
            cur.next = next;
            cur = cur.next;
            copyCur = copyCur.next;
        }
        return copyhead;

    }
}
