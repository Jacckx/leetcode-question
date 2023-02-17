//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
// Related Topics 链表 👍 1479 👎 0

package leetcode.editor.cn;

public class ReverseLinkedListIi {

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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 如果头结点为空或者没有下一个节点直接返回
        if (head == null || head.next == null) {
            return head;
        }

        // 在头结点前面定义一个虚拟头节点，指向头结点
        ListNode dummyHead = new ListNode(-1, head);

        // 初始化指针
        ListNode pre = dummyHead;
        ListNode cur = dummyHead.next;
        ListNode tmp = null;

        // 将指针移动到相应的位置
        for (int i = 0; i < left-1; i++) {
            pre = pre.next;
            cur = cur.next;
        }

        // 头插法插入节点
        for (int i = 0; i < right-left; i++) {
            tmp = cur.next;
            cur.next = cur.next.next;

            tmp.next = pre.next;
            pre.next = tmp;
        }
        return dummyHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListIi().new Solution();
    }
}