package algorithm;

import java.util.PriorityQueue;

;

public class MergeListNode {


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newList;
        ListNode firstNode;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>();
        while (l1 != null || l2 != null) {
            priorityQueue.add(l1);
            l1 = l1.next;
            priorityQueue.add(l2);
            l2 = l2.next;
        }
        newList = priorityQueue.poll();
        firstNode = newList;
        do {
            newList.next = priorityQueue.poll();
            if(newList.next == null) break;
            newList = newList.next;



        }while(true);

        return firstNode;

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        node4.next = node5;
        node5.next = node6;

        MergeListNode m = new MergeListNode();
        ListNode result = m.mergeTwoLists(node1, node4);
        ListNode temp = result;
        while(temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
