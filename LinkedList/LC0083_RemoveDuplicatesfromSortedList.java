public class LC0083_RemoveDuplicatesfromSortedList {
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while(curr.next!=null){
            if(curr.val == curr.next.val){
                curr.next = curr.next.next;
            }
            else{
                curr = curr.next;
            }
        }
        return head;
    }

    public static void main(String[] args){
        int[] nums = {1,1,2,3,4,4,5,5};

        ListNode l1 = arrayToLinkedList(nums);

        LC0083_RemoveDuplicatesfromSortedList obj = new LC0083_RemoveDuplicatesfromSortedList();

        ListNode result = obj.deleteDuplicates(l1);
        while (result!=null){
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
