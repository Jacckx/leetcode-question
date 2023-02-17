//给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
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
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1349 👎 0

package leetcode.editor.cn;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

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

    public List<Integer> inorderTraversal(TreeNode root) {
        //recursionTraverse(root);
        iterationTraverse1(root);
        // iterationTraverse2(root);
        return res;
    }

    // 中序遍历 - 递归
    public void recursionTraverse(TreeNode root) {
        if(root == null) {
            return;
        }

        recursionTraverse(root.left);
        res.add(root.val);
        recursionTraverse(root.right);
    }

    // 中序遍历 - 迭代
    // 中序遍历顺序 左->中->右
    // 入栈顺序：左->右
    // 前序遍历中访问节点和处理节点可以同步处理，但是中序就无法做到同步，因此需要指针配合
    public void iterationTraverse1(TreeNode root) {
        if (root == null){
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(!stack.isEmpty() || cur != null) {
            while (cur != null) { // 指针来访问节点，访问到最底层
                stack.push(cur); // 将访问的节点放进栈
                cur = cur.left;  // 左
            }
            cur = stack.pop(); // 从栈里弹出的数据，就是要处理的数据
            res.add(cur.val); // 中
            cur = cur.right; // 右
        }
    }


    // 中序遍历 - 迭代 （统一写法，适合前中后序迭代遍历）
    public void iterationTraverse2(TreeNode root){
        if (root == null){
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode tmp = stack.peek();
            if (tmp != null) {
                stack.pop(); // 将该节点弹出，避免重复操作，下面再将右中左节点添加到栈中

                if (tmp.right != null) { // 添加右节点（空节点不入栈）
                    stack.push(tmp.right);
                }

                stack.push(tmp); // 添加中节点
                stack.push(null); // 中节点访问过，但还没有处理，加入空节点作为标记

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
        Solution solution = new BinaryTreeInorderTraversal().new Solution();
    }
}