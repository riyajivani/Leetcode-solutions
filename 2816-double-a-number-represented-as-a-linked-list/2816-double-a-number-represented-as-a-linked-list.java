import java.math.BigInteger;

class Solution {
    public ListNode doubleIt(ListNode head) {
        if (head == null) return null;

        // Initialize num as BigInteger
        BigInteger num = BigInteger.ZERO;
        
        ListNode temp = head;
        while (temp != null) {
            num = num.multiply(BigInteger.TEN).add(BigInteger.valueOf(temp.val));
            temp = temp.next;
        }
        
        // Double the number
        num = num.multiply(BigInteger.valueOf(2));
        
        // Convert the number back to a linked list
        if (num.equals(BigInteger.ZERO)) return new ListNode(0);

        ListNode newHead = null;
        while (!num.equals(BigInteger.ZERO)) {
            BigInteger[] divRem = num.divideAndRemainder(BigInteger.TEN);
            int digit = divRem[1].intValue(); // Extract the remainder as digit
            num = divRem[0]; // Update num
            ListNode newNode = new ListNode(digit);
            newNode.next = newHead;
            newHead = newNode;
        }
        
        return newHead;
    }
}
