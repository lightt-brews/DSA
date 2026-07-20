public class LC0143_ReorderList {
    public static ListNode arrayToLinkedList(int[] arr) {
        if (arr.length == 0) return null;

        ListNode head = new ListNode(arr[0]);
        ListNode current = head;

        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }

        return head;
    }

    public ListNode reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = slow.next;
        ListNode prev = null;

        while(slow != null){
            ListNode next = slow.next;

            slow.next = prev;

            prev = slow;
            slow = next;
        }
        ListNode temp = head;
        while(prev != null){
            ListNode next = temp.next;
            ListNode secondNext = prev.next;

            temp.next = prev;
            prev.next = next;

            prev = secondNext;
            temp = next;
        }
        temp.next = null;
        return head;
    }


    public static void main(String[] args){
        int[] nums = {1,2,3,4,5};

        ListNode l1 = arrayToLinkedList(nums);

        LC0143_ReorderList obj = new LC0143_ReorderList();

        ListNode result = obj.reorderList(l1);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
