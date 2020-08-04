package LeetCode.utils;

import java.util.List;

/**
 * @program: DataStructureAndAlgorithms
 * @description: 数组转链表
 * @author: mirrorming
 * @create: 2019-01-26 15:11
 **/
public class ArrayToListNode {
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
}


