import java.util.List;

//Exercise 8
public class SortList {
    public ListNode sortList(ListNode head){
        if(head==null || head.next ==null) return head;

        ListNode temp=new ListNode(-1);
        ListNode curr= head;

        while(curr!=null){
            ListNode next = curr.next;
            ListNode prev=temp;

            while(prev.next != null && prev.next.val<curr.val){
                prev=prev.next;
            }
            curr.next=prev.next;
            prev.next=curr;
            curr=next;
        }
        return temp.next;
    }

    public static void main(String[] args) {
        SortList list=new SortList();
        ListNode head= new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        ListNode sorted =list.sortList(head);

        ListNode curr=sorted;
        while(curr!=null){
            System.out.println(curr.val+",");
            curr=curr.next;
        }
    }
}
