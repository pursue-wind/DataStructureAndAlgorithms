package LeetCode;

import java.util.HashMap;

/**
 * @program: DataStructureAndAlgorithms
 * @description: 206. 反转链表
 * @author: mirrorming
 * @create: 2019-01-25 10:21
 **/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

class LeetCode_206_ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode nextNode = null;
        ListNode cur = head;
        while (cur != null) {
            nextNode = cur.next;    //存储下一个节点
            cur.next = pre;         //让当前节点指向前一个节点
            pre = cur;              //pre存储当前节点
            cur = nextNode;         //当前节点前移
        }
        return pre;
    }
}
