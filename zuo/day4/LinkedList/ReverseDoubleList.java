package leetcode.zuo.day4.LinkedList;

/**
 * @author JJChen
 * @version 1.0
 */
public class ReverseDoubleList {
    public static void main(String[] args) {
        DoubleNode head = DoubleNode.createList(9);
        DoubleNode.printFromHead(head);
        head = reverse03(head);
        DoubleNode.printFromHead(head);
        head = DoubleNode.getTail(head);
        DoubleNode.printFromTail(head);
    }

    public static DoubleNode reverse01(DoubleNode head){
        DoubleNode cur = head;
        DoubleNode prev = null;
        while (cur != null){
             DoubleNode temp = cur.next;
             cur.next = prev;
             cur.prev = temp;
             prev = cur;
             cur = temp;
        }
        return prev;
    }
    public static DoubleNode reverse02(DoubleNode head){
        if(head == null || head.next == null) {
            if(head.next == null){
                head.prev = null;
            }
            return head;
        }
        DoubleNode tail = reverse02(head.next);
        head.next.next = head;
        head.prev = head.next;
        head.next = null;
        return tail;
    }

    public static DoubleNode reverse03(DoubleNode head){
        if(head == null || head.next == null) return head;
        DoubleNode cur = head;
        while(head.next != null){
            DoubleNode temp = head.next;
            head.next = head.next.next;
            cur.prev = temp;
            temp.next = cur;
            cur = temp;
        }
        cur.prev = null;
        return cur;
    }
}
