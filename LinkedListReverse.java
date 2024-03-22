package test1;

//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
public class LinkedListReverse {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;  //前驱结点赋值为null方便直接反转
        ListNode cur = head;
        ListNode temp = null;  //临时结点,用来暂时保存cur.next的结点
        while (cur!=null) {   //循环结束的条件是cur指向null
            temp = cur.next;
            cur.next = pre;  //此处进行了结点的反转操作
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
