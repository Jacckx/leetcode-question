//给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。 
//
// 叶子节点 是指没有子节点的节点。 
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3,null,5]
//输出：["1->2->5","1->3"]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：["1"]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 100] 内 
// -100 <= Node.val <= 100 
// 
// Related Topics 树 深度优先搜索 字符串 回溯 二叉树 👍 895 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

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

    List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        traversal(root, "");
        return res;
    }

    private void traversal(TreeNode node, String paths) {
        // 中，拼接节点值
        StringBuilder sb = new StringBuilder(paths);
        sb.append(node.val);

        // 遇到叶子节点时候，把拼接的结果加入到res中
        if (node.left == null && node.right == null) {
            res.add(sb.toString());
        }

        sb.append("->"); // 当前还是处于中节点，只有当其有左或右子节点是才添加 ->

        // 左
        if (node.left != null) {
            traversal(node.left, sb.toString());
        }

        // 右
        if (node.right != null) {
            traversal(node.right, sb.toString());
        }
    }


}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new BinaryTreePaths().new Solution();
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(5);

        a.left = b;
        b.right = d;
        a.right = c;

        solution.binaryTreePaths(a);
    }
}