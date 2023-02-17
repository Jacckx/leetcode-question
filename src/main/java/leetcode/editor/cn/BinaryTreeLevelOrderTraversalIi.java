//给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[15,7],[9,20],[3]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 广度优先搜索 二叉树 👍 543 👎 0

package leetcode.editor.cn;

import java.util.*;

public class BinaryTreeLevelOrderTraversalIi {

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

    List<List<Integer>> res = new ArrayList<List<Integer>>();

    // 二叉树自底向上的层次遍历
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // BFS - 队列
        BFSMethod(root);

        // 翻转列表
        List<List<Integer>> reverseList = new ArrayList<List<Integer>>();
        for (int i = res.size() - 1; i >= 0; i--) {
            reverseList.add(res.get(i));
        }

        return reverseList;
    }

    public void BFSMethod(TreeNode node) {
        if (node == null) {
            return;
        }

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(node);

        while(!q.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>(); // 记录当前层的所有元素
            int len = q.size(); // 取当前level的数量

            for (int i = 0; i < len; i++) {
                TreeNode tmp = q.remove();
                level.add(tmp.val);

                if (tmp.left != null){
                    q.add(tmp.left);
                }
                if (tmp.right != null){
                    q.add(tmp.right);
                }
            }
            res.add(level); // 推送到输出列表
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversalIi().new Solution();
    }
}