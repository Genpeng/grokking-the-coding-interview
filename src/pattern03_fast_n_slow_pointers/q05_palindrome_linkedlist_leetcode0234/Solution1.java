package pattern03_fast_n_slow_pointers.q05_palindrome_linkedlist_leetcode0234;

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
        // 思路：
        // 1. 找到链表的中间结点
        // 2. 逆序后半截的链表
        // 3. 比较前半截和后半截链表
        if (head == null || head.next == null) {
            return true;
        }
        ListNode mid = getMiddleNode(head);
        ListNode tail = reverse(mid);
        ListNode p1 = head, p2 = tail;
        while (p1 != null && p2 != null) {
            // 注意：当链表的结点数目为偶数时，在比较的时候，前半截会比后半截多一个结点
            if (p1.val != p2.val) {
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        // 比较结束，再次反转，回复链表原状
        reverse(tail);
        return p2 == null;
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