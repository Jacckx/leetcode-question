//给定一个二叉树，判断它是否是高度平衡的二叉树。 
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在范围 [0, 5000] 内 
// -10⁴ <= Node.val <= 10⁴ 
// 
// Related Topics 树 深度优先搜索 二叉树 👍 1251 👎 0

package leetcode.editor.cn;

public class BalancedBinaryTree {

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
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    public int getHeight(TreeNode node) {
        if (node == null) return 0;
        // 左子树中存在高度差大于1，直接返回 false
        int lHeight = getHeight(node.left);
        if (lHeight == -1) return -1;

        // 右子树中存在高度差大于1，直接返回 false
        int rHeight = getHeight(node.right);
        if (rHeight == -1) return -1;

        // 如果左右子树高度差大于1，返回 false
        if (Math.abs(lHeight - rHeight) > 1) {
            return -1;
        }

        // 返回以当前节点为根节点的树的最大高度
        return 1 + Math.max(lHeight, rHeight);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new BalancedBinaryTree().new Solution();
    }
}