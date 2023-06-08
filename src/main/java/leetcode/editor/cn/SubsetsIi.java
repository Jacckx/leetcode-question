//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// 
// 
// 
// Related Topics 位运算 数组 回溯 👍 1105 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsIi {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] canBeUsed;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        canBeUsed = new boolean[nums.length];
        Arrays.fill(canBeUsed, false);
        // 剪枝操作前先排序
        Arrays.sort(nums);
        backtracking(nums, 0);
        return res;
    }

    private void backtracking(int[] nums, int startIndex) {
        // 收集子集，要放在终止添加的上面，否则会漏掉自己
        res.add(new ArrayList<>(path));

        // 结束条件
        if (startIndex >= nums.length) {
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            // 去重 跳过第一个树枝
            if (i > 0 && nums[i] == nums[i-1] && canBeUsed[i-1] == false) {
                continue;
            }
            path.add(nums[i]);
            canBeUsed[i] = true;
            backtracking(nums, i + 1);
            canBeUsed[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new SubsetsIi().new Solution();
    }
}