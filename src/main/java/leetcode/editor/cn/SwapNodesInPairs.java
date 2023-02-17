//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
// Related Topics 递归 链表 👍 1686 👎 0

package leetcode.editor.cn;

public class SwapNodesInPairs {

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
    public ListNode swapPairs1(ListNode head) {
        // 设置一个虚拟头节点，指向头结点
        ListNode dummyHead = new ListNode(-1, head);
        // 定义一个指针指向虚拟节点
        ListNode cur = dummyHead;
        // cur.next和cur.next.next就是要交换的节点，所以都不能为null
        while (cur.next != null && cur.next.next != null) {
            // 定义一个临时节点来存储第一个要交换的节点
            ListNode tmp = cur.next;
            // 定义一个临时节点来存储第二对要交换节点的第一个节点
            ListNode tmp1 = cur.next.next.next;

            // 步骤1
            cur.next = cur.next.next;
            // 步骤2
            cur.next.next = tmp;
            // 步骤3
            cur.next.next.next = tmp1;

            // 交换完成，cur向后移动两位，准备进行下一轮交换
            cur = cur.next.next;
        }
        // 交换完成返回头节点
        return dummyHead.next;
    }

    public ListNode swapPairs(ListNode head) {
        // 终止条件
        if (head == null || head.next == null) {
            return head;
        }
        // 思考步骤1. 定义一个指针指向要交换的节点
        ListNode tmp = head.next;
        // 思考步骤4. head连接交换好的子链接
        head.next = swapPairs(tmp.next);
        // 思考步骤2. 更改指针指向
        tmp.next = head;
        // 思考步骤3. 返回交换好的子链接
        return tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new SwapNodesInPairs().new Solution();
    }
}