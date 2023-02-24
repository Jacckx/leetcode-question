//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 👍 778 👎 0

package leetcode.editor.cn;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> res = new LinkedList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        preorder(root);
        return res;
    }

    public void preorder(TreeNode root) {
        if (root == null) return;
        // 中->左->右
        res.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }


    public List<Integer> preorderTraversal1(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        if (node == null) {
            return res;
        }
        // 先往栈里压入元素，让循环开始
        stack.push(node);
        while (!stack.empty()) {
            // 弹出栈顶元素，判断是否为空
            node = stack.pop();
            if (node != null) {
                if (node.right != null) stack.push(node.right); // 右节点入栈
                if (node.left != null) stack.push(node.left); // 左节点入栈
                stack.push(node); // 中节点入栈
                stack.push(null); // 中后压入空值标记，说明该中节点已遍历过，但是还不急着处理
            }
            // 发现栈顶为空，说明栈里上一个节点之前已经被遍历过，
            // 并且它的左右子节点已经被压入栈中等待处理，说明这个节点无需保留了，直接弹出加入返回集中即可
            else {
                res.add(stack.pop().val);
            }
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new BinaryTreePreorderTraversal().new Solution();
    }
}