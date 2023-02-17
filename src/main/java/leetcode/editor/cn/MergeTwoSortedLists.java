//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 👍 2312 👎 0

package leetcode.editor.cn;

import java.util.List;

public class MergeTwoSortedLists {

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
    // 合并两个有序链表
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = iterationMethod(list1,list2);
        //ListNode res = recursionMethod(list1,list2);
        //ListNode res = recursionMethod1(list1,list2);
        return res;
    }

    // 迭代 - 判断 l1 和 l2 哪一个链表的头节点的值更小，将较小值的节点添加到结果里，
    // 当一个节点被添加到结果里之后，将对应链表中的节点向后移一位。
    public ListNode iterationMethod(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);

        ListNode pre = res;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        pre.next = l1 == null ? l2 : l1;

        return res.next;
    }

    // 递归
    public ListNode recursionMethod(ListNode l1, ListNode l2){
        // 终止条件：当两个链表都为空时，表示我们对链表已合并完成。
        if (l1 == null) {
            return l2;
        }
        if (l2 == null){
            return l1;
        }

        // 我们判断 l1 和 l2 头结点哪个更小，然后较小结点的 next 指针指向其余结点的合并结果。
        if (l1.val < l2.val) {
            l1.next = recursionMethod(l1.next, l2);
            return l1;
        }

        else {
            l2.next = recursionMethod(l1, l2.next);
            return l2;
        }
    }


    // 面试时可能要求去重 - 解法以下
    public ListNode recursionMethod1(ListNode l1, ListNode l2){

        // 链表去重，如果发现单个链表中有重复数字，直接跳到最后一个
        while(l1.next != null && l1.val == l1.next.val) {
            l1 = l1.next;
        }
        while(l2.next != null && l2.val == l2.next.val){
            l2 = l2.next;
        }

        // 有可能会出现list1与list2有相同元素，跳过其中的一个
        if (l1.val == l2.val) {
            if (l2.next != null) {
                l2 = l2.next;
            } else {
                // l1: 1 -> 2 -> 3
                // l2: 1
                return l1;
            }
        }


        // 终止条件：当两个链表都为空时，表示我们对链表已合并完成。
        if (l1 == null) {
            return l2;
        }
        if (l2 == null){
            return l1;
        }


        // 我们判断 l1 和 l2 头结点哪个更小，然后较小结点的 next 指针指向其余结点的合并结果。
        if (l1.val < l2.val) {
            l1.next = recursionMethod(l1.next, l2);
            return l1;
        }

        else {
            l2.next = recursionMethod(l1, l2.next);
            return l2;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();

        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(1);
        ListNode a3 = new ListNode(2);

        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(3);
        ListNode b3 = new ListNode(3);
        ListNode b4 = new ListNode(4);

        a1.next = a2;
        a2.next = a3;
        b1.next = b2;
        b2.next = b3;
        b3.next = b4;

        solution.mergeTwoLists(a1,b1);
    }
}