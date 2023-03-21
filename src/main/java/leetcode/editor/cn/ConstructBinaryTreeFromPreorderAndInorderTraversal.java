//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。 
//
// 
//
// 示例 1: 
//
// 
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均 无重复 元素 
// inorder 均出现在 preorder 
// preorder 保证 为二叉树的前序遍历序列 
// inorder 保证 为二叉树的中序遍历序列 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1897 👎 0

package leetcode.editor.cn;

import java.util.HashMap;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

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
    int[] preorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 用哈希表来保存中序遍历数组中 元素和索引 的映射
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        this.inorder = inorder;
        this.preorder = preorder;

        // 左闭右闭区间
        return traversal(0, inorder.length - 1, 0, preorder.length - 1);
    }

    private TreeNode traversal(int is, int ie, int ps, int pe) {
        // 左右区间中都遍历完了，返回空树
        if (is > ie || ps > pe) return null;

        // 找到前序数组中第一位元素在中序数组中的位置
        int ri = map.get(preorder[ps]);
        // 构造节点
        TreeNode node = new TreeNode(inorder[ri]);

        // 递归处理左右子树，参考示例图
        node.left = traversal(is, ri-1, ps+1, ps+ri-is);
        node.right = traversal(ri+1, ie, ps+ri-is+1, pe);
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
    }
}