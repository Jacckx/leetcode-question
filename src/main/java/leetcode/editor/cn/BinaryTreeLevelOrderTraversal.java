//给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[9,20],[15,7]]
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
// Related Topics 树 广度优先搜索 二叉树 👍 1226 👎 0

package leetcode.editor.cn;


import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        List<List<Integer>> res = new LinkedList<>();

        public List<List<Integer>> levelOrder(TreeNode root) {
            //BFS(root);
            DFS(root, 0);
            return res;
        }

        // 迭代
        public void BFS(TreeNode node) {
            if (node == null) return;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(node);
            while (!queue.isEmpty()) {
                // 记录每一层的节点值
                List<Integer> level = new LinkedList<>();
                // 获取队列的数量，也就是当前一层有多少节点数量
                int len = queue.size();
                // 遍历当前层的每一个节点，查找是否有左右子节点，有的话就交给队列，在下一次while循环里遍历
                for (int i = 0; i < len; i++) {
                    node = queue.remove();
                    level.add(node.val);
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }
                res.add(level);
            }
        }

        // 递归
        public void DFS(TreeNode node, int deep) {
            if (node == null) return;

            // 记录当前遍历第几层
            deep++;
            // 判断当前层的level集合是否已经创建过
            if (res.size() < deep) {
                List<Integer> level = new ArrayList<>();
                res.add(level);
            }
            res.get(deep - 1).add(node.val); // 中
            DFS(node.left, deep); // 左
            DFS(node.right, deep); // 右
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
    }
}