//给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: [1,2,3,null,5,null,4]
//输出: [1,3,4]
// 
//
// 示例 2: 
//
// 
//输入: [1,null,3]
//输出: [1,3]
// 
//
// 示例 3: 
//
// 
//输入: []
//输出: []
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,100] 
// -100 <= Node.val <= 100 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 648 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

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

    List<Integer> res = new ArrayList<Integer>();
    
    public List<Integer> rightSideView(TreeNode root) {
        DFSMethod(root,0);
        //BFSMethod(root);
        return res;
    }
    
    public void BFSMethod(TreeNode node) {
        if (node == null){
            return;
        }

        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.add(node);
        
        while(!que.isEmpty()) {

            int len = que.size();

            for (int i = 0; i < len; i++) {
                TreeNode tmp = que.remove();

                if (tmp.left != null){
                    que.add(tmp.left);
                }
                if (tmp.right != null){
                    que.add(tmp.right);
                }

                if (i == len -1){
                    res.add(tmp.val);
                }

            }
        }
    }

    // 迭代 - 前序遍历左右相反，跟-右-左
    public void DFSMethod(TreeNode node, int depth){
        if(node == null) {
            return;
        }
        // 如果==，说明当前层数里还没有节点添加到res中，所以加入res
        // 如果!=, 说明当前节点是左节点，右节点已经被加入过，所以不用加入
        if (depth == res.size()) {
            res.add(node.val);
        }
        depth++;
        DFSMethod(node.right,depth);
        DFSMethod(node.left,depth);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new BinaryTreeRightSideView().new Solution();
    }
}