package pattern03_fast_n_slow_pointers.q05_palindrome_linkedlist;

import entities.ListNode;

/**
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given the head of a Singly LinkedList, write a method to check if the LinkedList is a palindrome or not.
 *
 * Your algorithm should use constant space and the input LinkedList should be in the original form
 * once the algorithm is finished. The algorithm should have O(N) time complexity where ‘N’ is
 * the number of nodes in the LinkedList.
 *
 * Example 1:
 * Input: 2 -> 4 -> 6 -> 4 -> 2 -> null
 * Output: true
 *
 * Example 2:
 * Input: 2 -> 4 -> 6 -> 4 -> 2 -> 2 -> null
 * Output: false
 * ==========================================================================================================
 * <p>
 * Difficulty: Medium
 * Tags: linked list; fast & slow pointers
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    public boolean isPalindromic(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        // 找出链表的中间结点
        ListNode middle = getMiddleNode(head);
        // 反转后半截的链表，用于和前半截比较
        ListNode tail = reverse(middle);
        ListNode tailCopy = tail; // 保存链表尾结点，用于比较结束再次反转，使得函数结束链表保持原状
        while (head != null && tail != null) {
            // 注意：当链表的结点数目为偶数时，在比较的时候，前半截会比后半截多一个结点
            if (head.val != tail.val) {
                break;
            }
            head = head.next;
            tail = tail.next;
        }
        // 比较结束，再次反转，回复链表原状
        reverse(tailCopy);
        return tail == null;
    }

    public ListNode getMiddleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}