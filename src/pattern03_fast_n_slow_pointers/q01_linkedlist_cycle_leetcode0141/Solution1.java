package pattern03_fast_n_slow_pointers.q01_linkedlist_cycle_leetcode0141;

import entities.ListNode;

/**
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given the head of a Singly LinkedList, write a function to determine if the LinkedList has a cycle in it or not.
 * ==========================================================================================================
 * <p>
 * Difficulty: Easy
 * Tags: linked list; fast & slow pointers
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}