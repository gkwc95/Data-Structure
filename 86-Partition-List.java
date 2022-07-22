class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode();
        ListNode dummy2 = new ListNode();
        ListNode res1 = dummy1;
        ListNode res2 = dummy2;
        while (head != null){
            if (head.val < x){
                res1.next = head;
                res1 = res1.next;
            }
            else{
                res2.next = head;
                res2 = res2.next;
            }
            head = head.next;
        }
        res2.next = null;
        res1.next = dummy2.next;
        return dummy1.next;
    }
}
