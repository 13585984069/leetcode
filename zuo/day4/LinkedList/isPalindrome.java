package leetcode.zuo.day4.LinkedList;

import java.util.Stack;

/**
 * @author JJChen
 * @version 1.0
 */
public class isPalindrome {
    public static void main(String[] args) {
//        int[] arr = new int[] {1,2,3,4,5};
        int[] arr = new int[] {1, 2};

        ListNode head = List.createList(arr);
        ListNode cur = move02(head);
        System.out.println(cur.val);
//        List.printList(head);
//        System.out.println(isPalindrome(head));
    }
    // 空间复杂度O(N)
    public static boolean isPalindrome(ListNode head){
        Stack<ListNode> nodes = new Stack<>() ;
        ListNode cur = head;
        while(cur != null){
            nodes.push(cur);
            cur = cur.next;
        }
        cur = head;
        while(cur != null){
            if(cur.val != nodes.pop().val){
                return false;
            }
            cur = cur.next;
        }
        return true;
    }
    // 后半部分压栈
    public  static boolean isPalindrome02(ListNode head){
        if(head == null || head.next == null) return true;
        ListNode fast = head;
        ListNode slow = head.next;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        Stack<ListNode> listNodeStack = new Stack<>();
        while(slow != null){
            listNodeStack.push(slow);
            slow = slow.next;
        }
        slow = head;
        while(!listNodeStack.empty()){
            if(slow.val != listNodeStack.pop().val){
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
    // 使用快慢指针，将后半部分逆序，逆序以后进行比较，完成后恢复
    public static boolean isPalindrome03(ListNode head){
        if(head == null || head.next == null) return true;
        //这里用指针走到中间
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = slow.next;
        // 将中间断开方便遍历
        slow.next = null;
        ListNode tail = reverse(fast);
        fast = tail;
        ListNode h = head;
        boolean isP = true;
        while (tail != null){
            if(h.val != tail.val){
                isP = false;
                break;
            }
            tail = tail.next;
            h = h.next;
        }
        // 恢复链表再把后面链表转回去
        fast = reverse(fast);
        h = head;
        while(h.next!=null){
            h = h.next;
        }
        h.next = fast;
        return isP;
    }

    public static ListNode reverse(ListNode head){
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

    // 快慢指针，当快指针走到底，如果奇数，慢指针在中间，如果偶数，慢指针在中间的前面那个
    public static ListNode move01(ListNode head){
        if (head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next !=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // 快慢指针，当快指针走到底，如果奇数，慢指针在中间后一位，如果偶数，慢指针在中间的后面那个
    public static ListNode move02(ListNode head){
        if (head == null || head.next == null) return head;
        ListNode fast = head;
        ListNode slow = head.next; // 慢指针先走一步
        while(fast.next != null && fast.next.next !=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


}
