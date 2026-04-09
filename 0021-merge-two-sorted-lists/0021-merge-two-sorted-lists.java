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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy=new ListNode(-1);
        ListNode ans=dummy;
        ListNode head1=list1;
        ListNode head2=list2;
        while(list1!=null&&list2!=null)
        {
            if(list1.val<list2.val)
            {
                list1=list1.next;
                head1.next=null;
                dummy.next=head1;
                dummy=dummy.next;
                head1=list1;
            }
            else
            {
                list2=list2.next;
                head2.next=null;
                dummy.next=head2;
                dummy=dummy.next;
                head2=list2;
            }
        }
        while(list1!=null)
            {
                list1=list1.next;
                head1.next=null;
                dummy.next=head1;
                dummy=dummy.next;
                head1=list1;
            }
            while(list2!=null)
            {
                list2=list2.next;
                head2.next=null;
                dummy.next=head2;
                dummy=dummy.next;
                head2=list2;
            }
            return ans.next;
    }
}