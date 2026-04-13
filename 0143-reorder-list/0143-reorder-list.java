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
    public static ListNode reverseList(ListNode head)
    {
        ListNode curr=head;
        ListNode prev=null;
        ListNode temp=head;
        while(curr!=null)
        {
            temp=temp.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        if(head==null||head.next==null)
        return;
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null&&fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode middle=slow;
        ListNode head1=head;
        ListNode head2=middle.next;
        middle.next=null;
        head2=reverseList(head2);
        ListNode dummy=new ListNode(-1);
        ListNode prev=null;
      while(head2 != null)
        {
        ListNode t1 = head1.next;
        ListNode t2 = head2.next;

         head1.next = head2;
        head2.next = t1;

        head1 = t1;
        head2 = t2;
        }
    }
}