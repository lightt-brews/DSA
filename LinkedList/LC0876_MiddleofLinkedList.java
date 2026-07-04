public class LC0876_MiddleofLinkedList {
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
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main (String[] args) {

        int[] nums = {1,2,3,4,5};

        ListNode l1 = arrayToLinkedList(nums);

        LC0876_MiddleofLinkedList obj = new LC0876_MiddleofLinkedList();

        ListNode result = obj.middleNode(l1);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
