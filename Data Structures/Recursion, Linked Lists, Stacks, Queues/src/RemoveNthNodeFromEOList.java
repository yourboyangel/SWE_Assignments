public class RemoveNthNodeFromEOList {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){ this.val=val; }
        ListNode(int val, ListNode next) {this.val=val; this.next=next;}
    }

    public static ListNode removeFromEnd(int n, ListNode head){
        ListNode dummyHead=new ListNode(0);
        dummyHead.next=head;

        ListNode first=dummyHead;
        ListNode second=dummyHead;

        for(int i=1;i<=n+1;i++){
            second=second.next;
        }

        while(second!=null){
            first=first.next;
            second=second.next;
        }

        first.next=first.next.next;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode head=list1;
        ListNode result=removeFromEnd(2,head);
        ListNode resultHead=result;
        while(resultHead!=null){
            System.out.println(resultHead.val);
            resultHead=resultHead.next;
        }
    }
}
