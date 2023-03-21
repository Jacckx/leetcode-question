//给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并
//返回这颗 二叉树 。 
//
// 
//
// 示例 1: 
//
// 
//输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//输出：[3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入：inorder = [-1], postorder = [-1]
//输出：[-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= inorder.length <= 3000 
// postorder.length == inorder.length 
// -3000 <= inorder[i], postorder[i] <= 3000 
// inorder 和 postorder 都由 不同 的值组成 
// postorder 中每一个值都在 inorder 中 
// inorder 保证是树的中序遍历 
// postorder 保证是树的后序遍历 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 953 👎 0

package leetcode.editor.cn;

import java.util.HashMap;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

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
    HashMap<Integer, Integer> map = new HashMap<>();
    int[] inorder;
    int[] postorder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 用哈希表来保存中序遍历数组中 元素和索引 的映射
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        this.inorder = inorder;
        this.postorder = postorder;

        // 左闭右闭区间
        return traversal(0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode traversal(int is, int ie, int ps, int pe) {
        // 左右区间中都遍历完了，返回空树
        if (is > ie || ps > pe) return null;

        // 找到后序数组中最后一位元素在中序数组中的位置
        int ri = map.get(postorder[pe]);
        // 构造节点
        TreeNode node = new TreeNode(inorder[ri]);

        // 递归处理左右子树，参考示例图
        node.left = traversal(is, ri-1, ps, ps+ri-is-1);
        node.right = traversal(ri+1, ie, ps+ri-is, pe-1);
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        solution.buildTree(inorder, postorder);
    }
}