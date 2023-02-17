//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
// 
// 
// Related Topics 递归 链表 👍 2923 👎 0

package leetcode.editor.cn;

public class ReverseLinkedList {

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList1(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp = null;
        while (cur != null) {
            // tmp用来备份指向cur的下一个节点
            // 否则当cur的下一个节点指向pre后就找不到原本cur后面的节点了
            tmp = cur.next;
            // 反转指针的指向
            cur.next = pre;
            // pre和cur都前进一位
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public ListNode reverseList(ListNode head) {
        // 递归终止条件是当前为空，或者下一个节点为空
        if (head == null || head.next == null) {
            return head;
        }
        // 这里的cur就是最后一个节点
        ListNode cur = reverseList(head.next);
        // 这里请配合动画演示理解
        // 如果链表是 1->2->3->4->5，那么此时的cur就是5
        // 而head是4，head的下一个是5，下下一个是空
        // 所以head.next.next 就是5->4
        head.next.next = head;
        // 防止链表循环，需要将head.next设置为空
        head.next = null;
        // 每层递归函数都返回cur，也就是最后一个节点
        return cur;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();
    }
}