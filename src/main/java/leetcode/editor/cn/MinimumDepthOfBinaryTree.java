//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 10⁵] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 938 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {

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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int lHeight = minDepth(root.left); // 左
        int rHeight = minDepth(root.right); // 右

        // 当一个左子树为空，右不为空，这时并不是最低点
        if (root.left == null && root.right != null) {
            return 1 + rHeight;
        }
        // 当一个右子树为空，左不为空，这时并不是最低点
        if (root.left != null && root.right == null) {
            return 1 + lHeight;
        }

        int result = 1 + Math.min(lHeight, rHeight);
        return result;
    }

    public int minDepth1(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while(!queue.isEmpty()) {
            int len = queue.size();
            depth++;
            for (int i = 0; i < len; i++) {
                root = queue.remove();
                // 是叶子结点，直接返回depth，因为从上往下遍历，所以该值就是最小值
                if (root.left == null && root.right == null) {
                    return depth;
                }
                if (root.left != null) queue.add(root.left);
                if (root.right != null) queue.add(root.right);
            }
        }
        return depth;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new MinimumDepthOfBinaryTree().new Solution();
    }
}