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
class Solution {
    public ListNode removeNodes(ListNode head) { 
        Stack<ListNode> stack = new Stack<>();
        ListNode current = head;
        
        while (current != null) {
            while (!stack.isEmpty() && stack.peek().val < current.val) {
                stack.pop();
            }
            
            stack.push(current);
            current = current.next;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        
        for (ListNode node : stack) {
            prev.next = node;
            prev = prev.next;
        }
        
        prev.next = null;
        
        return dummy.next;
    }
}