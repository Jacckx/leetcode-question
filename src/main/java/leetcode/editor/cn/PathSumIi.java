//给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：[[5,4,11,2],[5,8,4,5]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,3], targetSum = 5
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], targetSum = 0
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点总数在范围 [0, 5000] 内 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
// 
// 
// Related Topics 树 深度优先搜索 回溯 二叉树 👍 919 👎 0

package leetcode.editor.cn;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.ArrayList;
import java.util.List;

public class PathSumIi {

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
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return res;
        List<Integer> path = new ArrayList<>();
        traversal(root, targetSum, path);
        return res;
    }

    private void traversal(TreeNode node, int sum, List<Integer> path) {
        // 中，添加节点值
        path.add(node.val);

        // 递减计数器
        sum -= node.val;

        // 遇到叶子节点时候，判断计数器是否为0，是的话说明找到路径，添加到结果集中
        if (node.left == null && node.right == null) {
            if (sum == 0) res.add(new ArrayList<>(path));
            return;
        }

        // 左
        if (node.left != null) {
            traversal(node.left, sum, path);
            // 回溯删除左子节点添加的节点值
            path.remove(path.size() - 1);
        }

        // 右
        if (node.right != null) {
            traversal(node.right, sum, path);
            // 回溯删除右子节点添加的节点值
            path.remove(path.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new PathSumIi().new Solution();

        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(4);
        TreeNode c = new TreeNode(8);
        TreeNode d = new TreeNode(11);
        TreeNode e = new TreeNode(13);
        TreeNode f = new TreeNode(4);
        TreeNode g = new TreeNode(7);
        TreeNode h = new TreeNode(2);
        TreeNode i = new TreeNode(5);
        TreeNode j = new TreeNode(1);

        a.left = b;
        a.right = c;
        b.left = d;
        c.left = e;
        c.right = f;
        d.left = g;
        d.right = h;
        f.left = i;
        f.right = j;

        solution.pathSum(a, 22);
    }
}