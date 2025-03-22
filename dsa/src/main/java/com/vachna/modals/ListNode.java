package dsa.src.main.java.com.vachna.modals;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next;}

    public void printNodes(){
        ListNode head = this;
        while (head!=null){
            System.out.print(head.val);
            head = head.next;
            String str = (head == null) ? "\n" : " -> ";
            System.out.print(str);
        }
    }
}
