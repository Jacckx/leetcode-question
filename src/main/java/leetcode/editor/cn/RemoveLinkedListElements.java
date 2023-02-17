//给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,6,3,4,5,6], val = 6
//输出：[1,2,3,4,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [], val = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [7,7,7,7], val = 7
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 列表中的节点数目在范围 [0, 10⁴] 内 
// 1 <= Node.val <= 50 
// 0 <= val <= 50 
// 
// Related Topics 递归 链表 👍 1141 👎 0

package leetcode.editor.cn;

public class RemoveLinkedListElements {

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
    public ListNode removeElements(ListNode head, int val) {
        // 判断头结点是否为空
        if (head == null) {
            return head;
        }
        // 链表中移除头节点和移除其他节点的操作方式是不同的，所以这里为了统一操作方式，
        // 在头节点的前面创建一个虚拟头节点，令其指向头节点
        ListNode dummyHead = new ListNode(-1, head);
        ListNode cur = dummyHead;
        while (cur.next != null) {
            if (cur.next.val == val) {
                // 移除链表中的节点，就是将当前节点的指针指向要移除元素的下一个节点
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        // 返回虚拟头节点指向的头节点
        return dummyHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new RemoveLinkedListElements().new Solution();
    }
}