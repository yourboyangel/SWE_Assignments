//Exercise 5
public class Add2Numbers {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){ this.val=val; }
        ListNode(int val, ListNode next) {this.val=val; this.next=next;}
    }

    public static ListNode sum(ListNode list1, ListNode list2){
        ListNode list3=null;
        ListNode head3=null;
        int carry=0;
        int result=0;
        ListNode head1=list1;
        ListNode head2=list2;
        while(head1!=null || head2!=null || carry!=0){
            int val1=(head1!=null) ? head1.val : 0;
            int val2=(head2!=null) ? head2.val : 0;
            result=val1+val2+carry;

            carry=result/10;
            result=result%10;

            ListNode node=new ListNode(result);
            if(list3==null){
                list3=node;
                head3=list3;
            }
            else{
                head3.next=node;
                head3=node;
            }
            if(head1!=null) head1=head1.next;
            if(head2!=null) head2=head2.next;

        }
        return list3;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode list2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        ListNode result = sum(list1, list2);
        ListNode head=result;
        while(head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }
}

