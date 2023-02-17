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
        // recursionTraverse(root);
         iterationTraverse1(root);
        // iterationTraverse2(root);
        return res;
    }

    // 前序遍历 - 递归
    public void recursionTraverse(TreeNode root) {
        if (root == null) {
            return;
        }

        res.add(root.val);
        recursionTraverse(root.left);
        recursionTraverse(root.right);
    }

    // 前序遍历 - 迭代
    // 前序遍历顺序 中->左->右
    // 入栈顺序：中->右->左
    // 出栈顺序：中->左->右
    public void iterationTraverse1(TreeNode root) {
        if (root == null){
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            res.add(tmp.val);
            if (tmp.right != null) {
                stack.push(tmp.right);
            }
            if (tmp.left != null){
                stack.push(tmp.left);
            }
        }
    }

    // 前序遍历 - 迭代 （统一写法，适合前中后序迭代遍历）
    public void iterationTraverse2(TreeNode root) {
        if (root == null){
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tmp = stack.peek();
            if (tmp != null) {
                stack.pop();
                if (tmp.right != null){
                    stack.push(tmp.right);
                }
                if (tmp.left != null){
                    stack.push(tmp.left);
                }
                stack.push(tmp);
                stack.push(null);

            } else {
                stack.pop();
                tmp = stack.peek();
                stack.pop();
                res.add(tmp.val);
            }
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new BinaryTreePreorderTraversal().new Solution();
    }
}