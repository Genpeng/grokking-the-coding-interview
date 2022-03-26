package pattern03_fast_n_slow_pointers.q02_linkedlist_cycle_length;

import entities.ListNode;

/**
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given the head of a LinkedList with a cycle, find the length of the cycle.
 * ==========================================================================================================
 * <p>
 * Difficulty: Easy
 * Tags: linked list; fast & slow pointers
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    public int findCycleLength(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode slow2 = slow.next;
                int len = 0;
                while (slow2 != slow) {
                    slow2 = slow2.next;
                    ++len;
                }
                return len;
            }
        }
        return 0;
    }
}