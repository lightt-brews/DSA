public class LC0019_RemoventhNodefromEndofList {
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow= head;
        ListNode fast = head;
        for(int i =0;i<n;i++){
            fast = fast.next;
        }
        if(fast ==null){
            return head.next;
        }
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void main (String[] args) {

        int[] nums = {1,2,3,4,5};
        int n = 2;

        ListNode l1 = arrayToLinkedList(nums);

        LC0019_RemoventhNodefromEndofList obj = new LC0019_RemoventhNodefromEndofList();

        ListNode result = obj.removeNthFromEnd(l1,n);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
