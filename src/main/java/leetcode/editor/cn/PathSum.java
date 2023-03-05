//给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和
// targetSum 。如果存在，返回 true ；否则，返回 false 。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
//输出：true
//解释：等于目标和的根节点到叶节点路径如上图所示。
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,3], targetSum = 5
//输出：false
//解释：树中存在两条根节点到叶子节点的路径：
//(1 --> 2): 和为 3
//(1 --> 3): 和为 4
//不存在 sum = 5 的根节点到叶子节点的路径。 
//
// 示例 3： 
//
// 
//输入：root = [], targetSum = 0
//输出：false
//解释：由于树是空的，所以不存在根节点到叶子节点的路径。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [0, 5000] 内 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1124 👎 0

package leetcode.editor.cn;

import java.util.Stack;

public class PathSum {

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
    // 递归
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        targetSum -= root.val;
        // 找到叶子节点
        if (root.left == null && root.right == null) {
            // 判断相减后结果是否为0整
            return targetSum == 0;
        }

        // 左
        if (root.left != null) {
            // 找到路径了不需要遍历其他的了，直接返回
            if (hasPathSum(root.left, targetSum)) return true;
        }
        // 右
        if (root.right != null) {
            if (hasPathSum(root.right, targetSum)) return true;
        }
        return false;
    }

    // 迭代
    public boolean hasPathSum1(TreeNode root, int targetSum) {
        if (root == null) return false;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        stack1.push(root);
        stack2.push(root.val);
        while(!stack1.isEmpty()) {
            int len = stack1.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = stack1.pop();
                int sum = stack2.pop();
                // 如果该节点是叶子节点了，同时该节点的路径数值等于sum，那么就返回true
                if (node.left == null && node.right == null && sum == targetSum) {
                    return true;
                }
                if (node.right != null) {
                    stack1.push(node.right);
                    stack2.push(sum + node.right.val);
                }
                if (node.left != null) {
                    stack1.push(node.left);
                    stack2.push(sum + node.left.val);
                }
            }
        }
        return false;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new PathSum().new Solution();
    }
}