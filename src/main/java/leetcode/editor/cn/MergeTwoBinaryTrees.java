//给你两棵二叉树： root1 和 root2 。 
//
// 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠
//，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。 
//
// 返回合并后的二叉树。 
//
// 注意: 合并过程必须从两个树的根节点开始。 
//
// 
//
// 示例 1： 
//
// 
//输入：root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
//输出：[3,4,5,5,4,null,7]
// 
//
// 示例 2： 
//
// 
//输入：root1 = [1], root2 = [1,2]
//输出：[2,2]
// 
//
// 
//
// 提示： 
//
// 
// 两棵树中的节点数目在范围 [0, 2000] 内 
// -10⁴ <= Node.val <= 10⁴ 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1205 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class MergeTwoBinaryTrees {

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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        //return DFS(root1, root2);
        return BFS(root1, root2);
    }

    private TreeNode DFS(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        // 中
        root1.val += root2.val;
        // 左右
        root1.left = DFS(root1.left, root2.left);
        root1.right = DFS(root1.right, root2.right);
        return root1;
    }

    public TreeNode BFS(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root1);
        queue.add(root2);
        while(!queue.isEmpty()) {
            //从队列中取出两个节点，再加一起
            TreeNode node1 = queue.remove();
            TreeNode node2 = queue.remove();
            node1.val += node2.val;
            // 如果两棵树的左节点都不为空，入队
            if (node1.left != null && node2.left != null) {
                queue.add(node1.left);
                queue.add(node2.left);
            }
            // 如果两棵树的右节点都不为空，入队
            if (node1.right != null && node2.right != null) {
                queue.add(node1.right);
                queue.add(node2.right);
            }
            // 若node1的左节点为空，取node2的节点
            if (node1.left == null && node2.left != null) {
                node1.left = node2.left;
            }
            // 若node1的右节点为空，取node2的节点
            if (node1.right == null && node2.right != null) {
                node1.right = node2.right;
            }
        }
        return root1;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new MergeTwoBinaryTrees().new Solution();
    }
}