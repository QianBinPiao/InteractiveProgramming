package algorithm;




public class AddTwoNumber {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode resultNode = new ListNode();
        ListNode resultCursor = resultNode;
        ListNode cursor1 = l1;
        ListNode cursor2 = l2;

        int nextAdded = 0;
        int valResult = 0;

        while (cursor1 != null || cursor2 != null) {

            if (cursor1 !=null) {
                valResult = valResult + cursor1.val ;
            }

            if (cursor2 !=null) {
                valResult = valResult + cursor2.val ;
            }


            valResult = valResult + nextAdded;

            if (valResult > 9) {

                resultCursor.val = valResult - 10;
                nextAdded = 1;


            } else {
                resultCursor.val = valResult;
                nextAdded = 0;

            }

            if (cursor1 != null ) {
                cursor1 = cursor1.next;

            }

            if (cursor2 !=null) {
                cursor2 = cursor2.next;
            }

            if ( cursor1 != null || cursor2 != null) {
                resultCursor.next = new ListNode();
                resultCursor = resultCursor.next;
            }

            valResult = 0;

        }

        if (nextAdded == 1) {
            resultCursor.next = new ListNode(1);
        }


        return resultNode;

    }



    public static void main(String[] args) {

        ListNode n3 = new ListNode(3);
        ListNode n2 = new ListNode(4, n3);
        ListNode n1 = new ListNode(2, n2);

        ListNode n7 = new ListNode(4);
        ListNode n6 = new ListNode(6, n7);
        ListNode n5 = new ListNode(5, n6);

        AddTwoNumber a = new AddTwoNumber();

        ListNode result = a.addTwoNumbers(n1, n5);


        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }

        ListNode n8 = new ListNode(1);

        ListNode n10 = new ListNode(9);
        ListNode n9 = new ListNode(9, n10);

        result = a.addTwoNumbers(n8, n9);

        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }


    }

}
