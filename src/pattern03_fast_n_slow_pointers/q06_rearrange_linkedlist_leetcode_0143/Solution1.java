package pattern03_fast_n_slow_pointers.q06_rearrange_linkedlist_leetcode_0143;

import entities.ListNode;

/**
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given the head of a Singly LinkedList, write a method to modify the LinkedList such that the nodes from
 * the second half of the LinkedList are inserted alternately to the nodes from the first half
 * in reverse order. So if the LinkedList has nodes 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null, your method should
 * return 1 -> 6 -> 2 -> 5 -> 3 -> 4 -> null.
 *
 * Your algorithm should not use any extra space and the input LinkedList should be modified in-place.
 *
 * Example 1:
 * Input: 2 -> 4 -> 6 -> 8 -> 10 -> 12 -> null
 * Output: 2 -> 12 -> 4 -> 10 -> 6 -> 8 -> null
 *
 * Example 2:
 * Input: 2 -> 4 -> 6 -> 8 -> 10 -> null
 * Output: 2 -> 10 -> 4 -> 8 -> 6 -> null
 * ==========================================================================================================
 * <p>
 * Difficulty: Medium
 * Tags: linked list; fast & slow pointers
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode mid = getMiddleNode(head);
        ListNode p1 = head, p2 = reverse(mid);
        ListNode next;
        while (p1 != p2 && p1.next != p2) {
            next = p1.next;
            p1.next = p2;
            p1 = next;

            next = p2.next;
            p2.next = p1;
            p2 = next;
        }
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
            // update to next iteration
            prev = curr;
            curr = next;
        }
        return prev;
    }
}