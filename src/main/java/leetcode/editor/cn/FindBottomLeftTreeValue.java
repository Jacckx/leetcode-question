//给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。 
//
// 假设二叉树中至少有一个节点。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: root = [2,1,3]
//输出: 1
// 
//
// 示例 2: 
//
// 
//
// 
//输入: [1,2,3,4,null,5,6,null,null,7]
//输出: 7
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [1,10⁴] 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 442 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue {

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

    private int maxDepth = Integer.MIN_VALUE;
    private int res;

    public int findBottomLeftValue1(TreeNode root) {
        traversal(root, 0);
        return res;
    }

    // 递归前序
    private void traversal(TreeNode node, int depth) {
        if (node == null) return;

        // 找到叶子节点
        if (node.left == null && node.right == null) {
            if (depth > maxDepth) {
                maxDepth = depth;
                res = node.val;
            }
        }

        // 左
        if (node.left != null) traversal(node.left, depth + 1); // 左
        if (node.right != null) traversal(node.right, depth + 1); // 右
    }

    // 层序遍历
    public int findBottomLeftValue(TreeNode root) {
        int res = 0;
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.remove();
                // 存储每层的最左边节点值
                if (i == 0) res = node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new FindBottomLeftTreeValue().new Solution();
    }
}