package algorithm;

public class ListNode implements Comparable<ListNode>{
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public int compareTo(ListNode node) {
        if (this.val < node.val) {
            return -1;
        } else if ( this.val > node.val) {
            return 1;
        } else {
            return 0;
        }
    }
}
