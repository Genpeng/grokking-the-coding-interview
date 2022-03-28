package pattern03_fast_n_slow_pointers.q04_happy_numbers;

import java.util.HashSet;
import java.util.Set;

/**
 * The description of problem is as follow:
 * ==========================================================================================================
 * Any number will be called a happy number if, after repeatedly replacing it with a number equal to
 * the sum of the square of all of its digits, leads us to number ‘1’. All other (not-happy) numbers
 * will never reach ‘1’. Instead, they will be stuck in a cycle of numbers which does not include ‘1’.
 * ==========================================================================================================
 * <p>
 * Difficulty: Easy
 * Tags: fast & slow pointers;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1) {
            if (seen.contains(n)) {
                return false;
            }
            seen.add(n);
            n = getNext(n);
        }
        return true;
    }

    public int getNext(int num) {
        int result = 0;
        while (num != 0) {
            int digit = num % 10;
            result += digit * digit;
            num /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 10;
        Solution1 solu = new Solution1();
        System.out.println(solu.isHappy(n));
    }
}