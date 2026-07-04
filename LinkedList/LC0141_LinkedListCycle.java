public class LC0141_LinkedListCycle {
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
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }

    public static void main (String[] args) {

        int[] nums = {1,2,3,4,5};

        ListNode l1 = arrayToLinkedList(nums);

        LC0141_LinkedListCycle obj = new LC0141_LinkedListCycle();

        System.out.println(obj.hasCycle(l1));
    }
}