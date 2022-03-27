package pattern03_fast_n_slow_pointers.q03_start_of_linkedlist_cycle;

import entities.ListNode;

/**
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given the head of a Singly LinkedList that contains a cycle, write a function to find the starting node of the cycle.
 * ==========================================================================================================
 * <p>
 * Difficulty: Medium
 * Tags: linked list;fast & slow pointers
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    public ListNode findCycleStart(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode slow2 = head;
                while (slow != slow2) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow2;
            }
        }
        return null;
    }
}