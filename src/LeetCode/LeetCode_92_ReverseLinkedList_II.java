package LeetCode;

/**
 * @program: DataStructureAndAlgorithms
 * @description: 92. 反转链表 II
 * @author: mirrorming
 * @create: 2019-01-26 12:33
 **/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

class LeetCode_92_ReverseLinkedList_II {
    public static void main(String[] args) {
        LeetCode_92_ReverseLinkedList_II test = new LeetCode_92_ReverseLinkedList_II();
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ListNode listNode = LeetCode_92_ReverseLinkedList_II.ArrayToLinkedList(arr);
        LeetCode_92_ReverseLinkedList_II.soutListNode(listNode);

        LeetCode_92_ReverseLinkedList_II.soutListNode(test.reverseBetween(listNode, 3, 5));
    }


    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n)    //链表只有0或1个节点或是只要求反转一个节点，直接返回原表头
            return head;
        System.out.println("----------------------------------------------------------------1----------------------------------------------------------------");

        ListNode dummy = new ListNode(0);  //虚拟头节点
        dummy.next = head;      //虚拟头节点指向头结点
        ListNode cur = head;    //记录遍历的当前节点
        ListNode pre = dummy;   //记录当前节点的前一个节点
        while (0 < m--) {
            cur = cur.next;
            pre = pre.next;
        }
        System.out.println("----------------------------------------------------------------2----------------------------------------------------------------");
        ListNode mNode = cur;   //记录第m个节点
        ListNode nextNode = cur;
        System.out.println("----------------------------------------------------------------3----------------------------------------------------------------");
        ListNode preNode = pre;
        //cur = cur.next;
        while (n > m++) {
            nextNode = cur.next;
            nextNode.next = cur;
            cur = cur.next;
        }
        pre.next = nextNode;
        System.out.println("----------------------------------------------------------------4----------------------------------------------------------------");
        mNode.next = nextNode.next;
        System.out.println("----------------------------------------------------------------5----------------------------------------------------------------");
        return dummy.next;
    }


    public static ListNode ArrayToLinkedList(int[] arr) {
        ListNode headNode = new ListNode(arr[0]);
        ListNode cur = headNode;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return headNode;
    }

    public static void soutListNode(ListNode listNode) {
        ListNode cur = listNode;
        StringBuilder sb = new StringBuilder("HEAD: ");
        while (cur != null) {
            sb.append(cur.val + " -> ");
            cur = cur.next;
        }
        sb.append(" NULL");
        System.out.println(sb.toString());
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("ListNode{");
            sb.append("val=").append(val);
            sb.append(", next=").append(next);
            sb.append('}');
            return sb.toString();
        }
    }

}

