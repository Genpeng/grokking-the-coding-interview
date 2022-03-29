package pattern03_fast_n_slow_pointers.q05_middle_of_the_linkedlist;

import entities.ListNode;

/**
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given the head of a Singly LinkedList, write a method to return the middle node of the LinkedList.
 *
 * If the total number of nodes in the LinkedList is even, return the second middle node.
 *
 * Example 1:
 * Input: 1 -> 2 -> 3 -> 4 -> 5 -> null
 * Output: 3
 *
 * Example 2:
 * Input: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
 * Output: 4
 *
 * Example 3:
 * Input: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> null
 * Output: 4
 * ==========================================================================================================
 * <p>
 * Difficulty: Easy
 * Tags: linked list; fast & slow pointers
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    public ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}