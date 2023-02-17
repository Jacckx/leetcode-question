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
        // 二叉树层序遍历
        public List<List<Integer>> levelOrder(TreeNode root) {
            DFSMethod(root,0);
            //BFSMethod(root);
            return res;
        }

        List<List<Integer>> res = new ArrayList<List<Integer>>();

        // DFS - 递归方法
        public void DFSMethod(TreeNode node, Integer deep) {
            if (node == null) {
                return;
            }

            deep++;

            if (res.size() < deep) {
                // 当前层级的list没创建过，创建一个空list添加到res
                List<Integer> item = new ArrayList<Integer>();
                res.add(item);
            }
            // 利用deep进行层级界定, 并存储对应层级的node
            res.get(deep -1).add(node.val);

            DFSMethod(node.left, deep);
            DFSMethod(node.right, deep);
        }


        // BFS - 迭代方法 - 队列
        public void BFSMethod(TreeNode node) {
            if (node == null) {
                return;
            }

            Queue<TreeNode> que = new LinkedList<TreeNode>();
            que.add(node);

            while(!que.isEmpty()){
                List<Integer> level = new ArrayList<Integer>();
                int len = que.size(); // 记录当前一层node数量

                for (int i = 0; i < len; i++) { // 遍历当前一层
                    TreeNode tmp = que.remove();
                    level.add(tmp.val);

                    if (tmp.left != null) {
                        que.add(tmp.left);
                    }
                    if (tmp.right != null) {
                        que.add(tmp.right);
                    }
                }
                res.add(level);

            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
    }
}