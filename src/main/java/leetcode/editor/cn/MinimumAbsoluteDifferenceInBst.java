//给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。 
//
// 差值是一个正数，其数值等于两值之差的绝对值。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [4,2,6,1,3]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：root = [1,0,48,null,null,12,49]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目范围是 [2, 10⁴] 
// 0 <= Node.val <= 10⁵ 
// 
//
// 
//
// 注意：本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-
//nodes/ 相同 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 二叉树 👍 441 👎 0

package leetcode.editor.cn;

import java.util.Stack;

public class MinimumAbsoluteDifferenceInBst {

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
    // 记录上一个遍历的节点
    TreeNode pre = null;
    int res = Integer.MAX_VALUE;
    public int getMinimumDifference2(TreeNode root) {
        if (root == null) return 0;
        traversal(root);
        return res;
    }

    private void traversal(TreeNode node) {
        if (node == null) return;
        // 左
        traversal(node.left);
        // 中
        if (pre != null) {
            res = Math.min(res, node.val - pre.val);
        }
        // 记录前一个节点
        pre = node;
        // 右
        traversal(node.right);
    }

    // 迭代
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            // 将当前节点的左子树所有节点入栈
            while(root != null) {
                stack.push(root);
                // 遍历左子树
                root = root.left;
            }
            // 取出栈顶元素
            root = stack.pop();
            // 如果当前节点有前驱节点，计算当前节点与前驱节点的差值，并更新res变
            if (pre != null) {
                res = Math.min(res, root.val - pre.val);
            }
            // 将pre指向当前节点，用于下一次比较
            pre = root;
            // 遍历右子树
            root = root.right;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new MinimumAbsoluteDifferenceInBst().new Solution();
    }
}