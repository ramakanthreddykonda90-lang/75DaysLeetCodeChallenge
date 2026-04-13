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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp=head;
        int cnt=0;
        while(temp!=null)
        {
            cnt++;
            temp=temp.next;
        }
        temp=head;
       int a=cnt-n;
       // System.out.print(cnt+" ");
       if(a==0)
       {
        ListNode te=temp.next;
        temp.next=null;
        return te;
       }
        ListNode prev=null;
       prev=temp;
       temp=temp.next;
        while(temp!=null)
        {
            if(a==1)
            {
                prev.next=temp.next;
                break;
            }
            a--;
            prev=temp;
            temp=temp.next;
        }
        return head;
    }
}