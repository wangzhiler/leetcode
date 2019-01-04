package leetcodeJava;

public class SwapNodesinPairs {

    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode l1 = dummy;
        ListNode l2 = head;

        /*
              l2
         l1-> 1 -> 2 -> 3 -> 4

         l1 -> 2 -> 3 -> 4
                l2

         */

        while (l2 != null && l2.next != null) {
            l1.next = l2.next;
            l2.next = l2.next.next;
            l1.next.next = l2;

            l1 = l2;
            l2 = l1.next;
        }

        return dummy.next;
    }
}
