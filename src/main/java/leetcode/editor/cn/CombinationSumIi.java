//给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用 一次 。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
// Related Topics 数组 回溯 👍 1353 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumIi {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        used = new boolean[candidates.length];
        Arrays.fill(used, false);
        // 剪枝操作：先进行排序，然后在for循环里进行剪枝
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, 0, used);
        return res;
    }

    private void backtracking(int[] candidates, int target, int sum, int startIndex, boolean[] used) {
        // 确认终止条件
        if (sum > target) {
            return;
        }
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 单层搜索逻辑
        // 剪枝操作：添加for循环执行条件，如果下一层的sum大于target就不结束循环
        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
            // 去重 跳过第一个树枝
            if (i > 0 && candidates[i] == candidates[i - 1] && used[i-1] == false) {
                continue;
            }
            path.add(candidates[i]);
            sum+=candidates[i];
            used[i] = true;
            backtracking(candidates, target, sum, i+1, used);
            used[i] = false;
            sum-=candidates[i];
            path.remove(path.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new CombinationSumIi().new Solution();
    }
}