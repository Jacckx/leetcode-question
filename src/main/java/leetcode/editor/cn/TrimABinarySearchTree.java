//给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。通过修剪二叉搜索树，使得所有节点的值在[low, high]中。修剪树 不
//应该 改变保留在树中的元素的相对结构 (即，如果没有被移除，原有的父代子代关系都应当保留)。 可以证明，存在 唯一的答案 。 
//
// 所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,0,2], low = 1, high = 2
//输出：[1,null,2]
// 
//
// 示例 2： 
//
// 
//输入：root = [3,0,4,null,2,null,null,1], low = 1, high = 3
//输出：[3,2,null,1]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数在范围 [1, 10⁴] 内 
// 0 <= Node.val <= 10⁴ 
// 树中每个节点的值都是 唯一 的 
// 题目数据保证输入是一棵有效的二叉搜索树 
// 0 <= low <= high <= 10⁴ 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 797 👎 0

package leetcode.editor.cn;

public class TrimABinarySearchTree {

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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;

        // 寻找符合区间[low, high]的节点
        // root小于low，root的右子树可能会大于low，所以继续向右遍历
        if (root.val < low) return trimBST(root.right, low, high);
        // root大于high，root的左子树可能小于high，所以继续向左遍历
        if (root.val > high) return trimBST(root.left, low, high);

        // 连接
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new TrimABinarySearchTree().new Solution();
    }
}