class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

class LC0002_AddTwoNumbers {

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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry= 0;
        while(temp1 != null || temp2 != null){
            int store = 0;
            if(temp2 == null){
                store = temp1.val + carry;
                if(store  >9){
                    carry = store/10;
                    store= store %10;
                }
                else{
                    carry = 0;
                }
                curr.next = new ListNode(store);
                curr = curr.next;
                temp1 = temp1.next;
            }
            else if(temp1 == null){
                store = temp2.val + carry;
                if(store  >9){
                    carry = store/10;
                    store= store %10;
                }
                else{
                    carry = 0;
                }
                curr.next = new ListNode(store);
                curr = curr.next;
                temp2 = temp2.next;
            }
            else{
                store = temp1.val + temp2.val + carry;
                if(store  >9){
                    carry = store/10;
                    store= store %10;
                }
                else{
                    carry = 0;
                }
                curr.next = new ListNode(store);
                curr = curr.next;
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
        }
        if (carry>0){
            curr.next = new ListNode(carry);
        }
        return dummy.next;
    }

    public static void main(String[] args) {

        int[] arr1 = {9,9,9,9,9,9,9};
        int[] arr2 = {9,9,9,9};

        ListNode l1 = arrayToLinkedList(arr1);
        ListNode l2 = arrayToLinkedList(arr2);

        // Print l1
        ListNode temp = l1;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }

        System.out.println();

        // Print l2
        temp = l2;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();

        LC0002_AddTwoNumbers obj = new LC0002_AddTwoNumbers();

        ListNode result = obj.addTwoNumbers(l1, l2);
        while (result!=null){
            System.out.print(result.val + " ");
            result = result.next;
        }


    }
}