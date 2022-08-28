package leetcode.zuo.day4.LinkedList;

/**
 * @author JJChen
 * @version 1.0
 */
public class ReverseLink {
    public static void main(String[] args) {
        ListNode head = List.createList(9);
        List.printList(head);
        head = reverse01(head);
        List.printList(head);
        head = reverse02(head);
        List.printList(head);
        head= reverse03(head);
        List.printList(head);
    }

    public static ListNode reverse01(ListNode head){
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
    public static ListNode reverse02(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode tail = reverse02(head.next);
        head.next.next = head;
        head.next = null;
        return tail;
    }

    public static ListNode reverse03(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode cur = null;
        ListNode next = head;
        while(head.next != null){
            cur = head.next;
            head.next = head.next.next;
            cur.next = next;
            next = cur;
        }
        return next;
    }
}
