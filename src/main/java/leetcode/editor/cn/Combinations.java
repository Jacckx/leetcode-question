//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
// Related Topics 回溯 👍 1390 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    List<Integer> path = new ArrayList<>(); // 用来存放符合条件单一结果
    List<List<Integer>> res = new ArrayList<>(); // 存放符合条件结果的集合

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return res;
    }

    private void backtracking(int n, int k, int startIndex) {
        // 确定终止条件
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 单层搜索过程
        for (int i = startIndex; i <= n; i++) {
            // 剪枝
            if (i <= n - (k - path.size()) + 1) {
                path.add(i); // 处理节点
                backtracking(n, k, i + 1); // 递归：控制树的纵向遍历，注意下一层搜索要从i+1开始
                path.remove(path.size() - 1); // 回溯，还原之前的状态
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new Combinations().new Solution();
        solution.combine(4,2);
    }
}