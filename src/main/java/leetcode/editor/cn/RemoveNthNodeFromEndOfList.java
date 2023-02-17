//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针 👍 2377 👎 0

package leetcode.editor.cn;

public class RemoveNthNodeFromEndOfList {

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            return head;
        }
        // 定义虚拟头节点
        ListNode dummyHead = new ListNode(-1, head);
        // 初始化快慢指针
        ListNode slow = dummyHead;
        ListNode fast = dummyHead;
        // 这里fast指针先走n步，走到要删除节点的前一个节点，使快慢指针之间相差n
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        // 同时移动快慢指针
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // 删除slow位置的目标节点
        slow.next = slow.next.next;
        return dummyHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
    }
}