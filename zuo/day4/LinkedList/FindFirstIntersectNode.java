package leetcode.zuo.day4.LinkedList;

/**
 * @author JJChen
 * @version 1.0
 * 给定两个可能有环也可能无环的单链表，头节点head1和head2。
 * 请实现一个函数，如果两个链表相交，请返回相交的第一个节点。如果不相交，返回null
 *
 *
 * 1. 分析是否有环
 * 2. 都无环，简单方法都是用哈希表存放值
 * 3. 一个有环一个无环，此情况不可能相交
 * 4. 都有环
 * 4.1 入环前相交
 * 4.2 入环后相交
 * 4.3 不相交
 */
public class FindFirstIntersectNode {
    public static void main(String[] args) {

    }

    public static ListNode getIntersectionNode(ListNode A, ListNode B){
        if(A == null || B == null) return null;
        ListNode cur1 = detectCycle(A);
        ListNode cur2 = detectCycle(B);
        if(cur1 == null && cur2 == null){
            return getNoLoopIntersectionNode(A, B, null);
        }
        if(cur1 !=null && cur2 !=null){
           return getLoopIntersectionNode(A, B, cur1,cur2);
        }
        return null;
    }
    public static ListNode getLoopIntersectionNode(ListNode A, ListNode B, ListNode cur1, ListNode cur2){
        if(cur1 == cur2){
            ListNode res = getNoLoopIntersectionNode(A, B, cur1);
            return res;
        }else {
            ListNode res = A.next;
            while (res != A){
                if(res == B){
                    return res;
                }
                res= res.next;
            }
            return null;
        }

    }

    public static ListNode getNoLoopIntersectionNode(ListNode A, ListNode B, ListNode checkPoint){
        ListNode cur1 = A;
        ListNode cur2 = B;
        int count = 0;
        while(cur1 != checkPoint){
            count++;
            cur1 = cur1.next;
        }
        while(cur2 != checkPoint){
            count--;
            cur2 = cur2.next;
        }
        cur1 = count >=0 ? A: B;
        cur2 = cur1 == A? B:A;
        count = Math.abs(count);
        for (int i = 0; i < count; i++) {
            cur1 = cur1.next;
        }
        while (cur1 != checkPoint){
            if(cur1 == cur2){
                return cur1;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return null;
    }


    //a+(n+1)b+nc=2(a+b)⟹a=c+(n−1)(b+c) ==》 a =c
    public static ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return null;
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while(fast != slow){
            if(fast == null || fast.next == null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
