package leetcode.AllSolve.LinkedList;

/**
 * @author JJChen
 * @version 1.0
 */
public class ReverseLink206 {
    public static void main(String[] args) {

    }

    // iteration方式 Time O(N) SpaceO(1)
    public static ListNode ReverseLinkedList01(ListNode head){
        ListNode cur = head;
        ListNode prev = null;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    // recursion 方法
    public static ListNode ReverseLinkedList02(ListNode head){
        // head==null 表示原先链表就是空的，直接返回
        // head.next == null 递归到这个条件说明到尾部了
        if(head == null || head.next == null) return head;
        // 不断压栈找到尾部
        ListNode cur = ReverseLinkedList02(head.next);
        // 找到尾部后，head.next 就是尾部，尾部->倒数第二个节点
        head.next.next = head;
        // 原倒数第二个节点指向空
        head.next = null;
        //返回尾部节点
        return cur;
    }

    // iteration另一种双指针法 头节点一直指向next.next，用来记录后面的节点
    public static ListNode ReversLinkedList03(ListNode head){
        if(head == null) return null;
        ListNode cur = head;
        while(head.next != null){
            ListNode temp = head.next;
            head.next = head.next.next;
            temp.next = cur;
            cur = temp;
        }
        return cur;
    }
}
