public class LC0021_MergeTwoSortedLists  {
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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2){
        if(list1==null){
            return list2;
        }
        if(list2== null){
            return list1;
        }
        if(list1.val<list2.val){
            list1.next = mergeTwoLists((list1.next),list2);
            return list1;
        }
        else{
            list2.next = mergeTwoLists((list2.next),list1);
            return list2;
        }
    }

    public static void main(String[] args){
        int[] l1 = {1,2,4};
        int[] l2 = {1,3,4};

        ListNode list1 = arrayToLinkedList(l1);
        ListNode list2 = arrayToLinkedList(l2);

        LC0021_MergeTwoSortedLists obj = new LC0021_MergeTwoSortedLists();

        ListNode result = obj.mergeTwoLists(list1, list2);
        while (result!=null){
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}