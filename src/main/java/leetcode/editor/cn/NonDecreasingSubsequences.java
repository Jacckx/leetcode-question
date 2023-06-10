//给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。 
//
// 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,6,7,7]
//输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,4,3,2,1]
//输出：[[4,4]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 15 
// -100 <= nums[i] <= 100 
// 
// Related Topics 位运算 数组 哈希表 回溯 👍 666 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NonDecreasingSubsequences {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);
        return res;
    }

    private void backtracking(int[] nums, int startIndex) {
        // 结束条件，当结果大于1就收集
        if (path.size() > 1) {
            res.add(new ArrayList<>(path));
        }

        Set<Integer> set = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            // 自增规则：所取的元素不小于最后的一个元素
            // 去重：用set来记录同一层下使用过的数
            if (!path.isEmpty() && nums[i] < path.get(path.size() - 1) || set.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            set.add(nums[i]);
            backtracking(nums, i + 1);
            // set只用于存放每层递归的元素，所以set不用回溯
            path.remove(path.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new NonDecreasingSubsequences().new Solution();
    }
}