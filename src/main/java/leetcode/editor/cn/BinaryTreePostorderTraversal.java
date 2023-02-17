//给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[3,2,1]
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
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 👍 795 👎 0

package leetcode.editor.cn;

import java.util.*;

public class BinaryTreePostorderTraversal {

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

    List<Integer> res = new LinkedList<Integer>();

    public List<Integer> postorderTraversal(TreeNode root) {
        //recursionTraverse(root);
        //iterationTraverse1(root);
        iterationTraverse2(root);
        return res;
    }

    // 后序遍历 - 递归
    public void recursionTraverse(TreeNode root) {
        if(root == null) {
            return;
        }

        recursionTraverse(root.left);
        recursionTraverse(root.right);
        res.add(root.val);
    }

    // 后序遍历 - 迭代
    // 后序遍历顺序 左->右->中
    // 入栈顺序：中->左->右
    // 出栈顺序：中->右->左
    // 最后翻转结果
    public void iterationTraverse1(TreeNode root) {
        if (root == null){
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            res.add(tmp.val);
            if (tmp.left != null) {
                stack.push(tmp.left);
            }
            if (tmp.right != null) {
                stack.push(tmp.right);
            }
        }
        Collections.reverse(res);
    }


    // 后序遍历 - 迭代 （统一写法，适合前中后序迭代遍历）
    public void iterationTraverse2(TreeNode root){
        if (root == null){
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode tmp = stack.peek();
            if (tmp != null) {
                stack.pop(); // 将该节点弹出，避免重复操作，下面再将中右左节点添加到栈中
                stack.push(tmp); // 添加中节点
                stack.push(null); // 中节点访问过，但还没有处理，加入空节点作为标记

                if (tmp.right != null) { // 添加右节点（空节点不入栈）
                    stack.push(tmp.right);
                }
                if (tmp.left != null) { // 添加左节点（空节点不入栈）
                    stack.push(tmp.left);
                }

            } else { // 只有遇到空节点的时候，才将下一个节点放进结果集
                stack.pop(); // 将空节点弹出
                tmp = stack.peek(); // 重新取出栈中元素
                stack.pop();
                res.add(tmp.val); // 加入到结果集
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new BinaryTreePostorderTraversal().new Solution();

        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);

        a.left = b;
        a.right = c;
        b.left = d;

        solution.postorderTraversal(a);

    }
}