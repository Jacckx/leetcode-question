//给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。 
//
// 如果树中有不止一个众数，可以按 任意顺序 返回。 
//
// 假定 BST 满足如下定义： 
//
// 
// 结点左子树中所含节点的值 小于等于 当前节点的值 
// 结点右子树中所含节点的值 大于等于 当前节点的值 
// 左子树和右子树都是二叉搜索树 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 
//输入：root = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内） 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 619 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class FindModeInBinarySearchTree {

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
    int count = 0;
    int maxCount = 0;
    List<Integer> list = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        traversal(root);
        // 转换数组
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void traversal(TreeNode node) {
        if (node == null) return;
        // 遍历左子树
        traversal(node.left);

        // 第一个节点没有前驱节点，频率为1
        if (pre == null) count = 1;
        // 如果当前节点的值与前驱节点一样，频率加1
        else if (node.val == pre.val) count++;
        // 如果不一样，重置为1
        else count = 1;

        // 如果频率大于最大值，清空目前的list
        if (count > maxCount) {
            maxCount = count;
            list.clear();
            list.add(node.val);
        } else if (count == maxCount) {
            list.add(node.val);
        }

        pre = node;

        // 遍历右子树
        traversal(node.right);
    }


}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new FindModeInBinarySearchTree().new Solution();
    }
}