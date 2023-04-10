//给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。 
//
// 有效 二叉搜索树定义如下： 
//
// 
// 节点的左子树只包含 小于 当前节点的数。 
// 节点的右子树只包含 大于 当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [2,1,3]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [5,1,4,null,null,3,6]
//输出：false
//解释：根节点的值是 5 ，但是右子节点的值是 4 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围在[1, 10⁴] 内 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 1970 👎 0

package leetcode.editor.cn;

import java.util.Stack;

public class ValidateBinarySearchTree {

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
    TreeNode pre = null;

    public boolean isValidBST2(TreeNode root) {
        // 二叉搜索树可以有空节点，所以遇到空节点返回true
        if (root == null) return true;

        // 访问左子树
        boolean left = isValidBST(root.left);

        // 访问当前节点，如果当前节点小于等于中序遍历的前一个节点，说明不满足BST
        if (pre != null && pre.val >= root.val) return false;
        pre = root;

        // 访问右子树
        boolean right = isValidBST(root.right);
        return left && right;
    }

    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while(root != null || !stack.isEmpty()) {
            // 左节点入栈
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            // 中
            TreeNode node = stack.pop();
            if (pre != null && pre.val >= node.val) return false;
            pre = node;

            // 右
            root = node.right;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new ValidateBinarySearchTree().new Solution();
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(5);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(6);
        b.left = a;
        b.right = c;
        c.left = d;
        c.right = e;
        solution.isValidBST(b);
    }
}