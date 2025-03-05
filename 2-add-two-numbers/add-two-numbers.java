/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 
import java.math.BigInteger;
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            BigInteger list1 = convert2BigInt(l1);
            BigInteger list2 = convert2BigInt(l2);
            System.out.println("l1 " + list1 + " l2 " + list2 + "  = " + (list2.add(list1)));
            return convert2LN(list1.add(list2));
    }

    private static BigInteger convert2BigInt(ListNode l1) {
        BigInteger res = BigInteger.ZERO;
        int count = 0;
        ListNode list = l1;
        while (list != null) {
            res = res.add(BigInteger.valueOf(list.val).multiply(BigInteger.TEN.pow(count)));
            count++;
            list = list.next;
        }
        return res;
    }

    private static ListNode convert2LN(BigInteger a) {
        ListNode temp = new ListNode(a.mod(BigInteger.TEN).intValue());
        a = a.divide(BigInteger.TEN);
        ListNode FA = temp;
        while (a.compareTo(BigInteger.ZERO) > 0) {
            temp.next = new ListNode(a.mod(BigInteger.TEN).intValue());
            a = a.divide(BigInteger.TEN);
            temp = temp.next;
        }
        return FA;
    }
}