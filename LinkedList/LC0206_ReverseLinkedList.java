class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class LC0206_ReverseLinkedList {
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

    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev=null;
        while(curr != null){
            ListNode next;
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;

    }

    public static void main(String[] args){
        int[] nums = {1,2,3,4,5};

        ListNode l1 = arrayToLinkedList(nums);

        LC0206_ReverseLinkedList obj = new LC0206_ReverseLinkedList();

        ListNode result = obj.reverseList(l1);
        while (result!=null){
            System.out.print(result.val + " ");
            result = result.next;
        }

    }
}
