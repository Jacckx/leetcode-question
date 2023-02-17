//给定一个含有 n 个正整数的数组和一个正整数 target 。 
//
// 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长
//度。如果不存在符合条件的子数组，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
// 
//
// 示例 2： 
//
// 
//输入：target = 4, nums = [1,4,4]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target <= 10⁹ 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 
//
// 
//
// 进阶： 
//
// 
// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。 
// 
// Related Topics 数组 二分查找 前缀和 滑动窗口 👍 1528 👎 0

package leetcode.editor.cn;

public class MinimumSizeSubarraySum {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // 这里将滑动窗口的大小初始化为int类型的最大值
        int res = Integer.MAX_VALUE;
        // 定义滑动窗口的数值之和
        int sum = 0;
        // 定义滑动窗口的长度
        int len = 0;
        // 定义滑动窗口的起始位置
        int left = 0;

        // right为滑动窗口的终止位置，移动j，直到窗口内的数值之和大于等于目标值
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            // 只有当滑动窗口内的数值之和大于等于目标值时，开始收缩窗口
            while(sum >= target) {
                // 获取当前滑动窗口的长度
                len = right - left + 1;
                // 不断获取滑动窗口的最小值
                res = Math.min(res, len);
                // 移动滑动窗口的起始位置，收缩窗口，并且sum不断减少
                sum -= nums[left++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        int[] num = {2,3,1,2,4,3};
        Solution solution = new MinimumSizeSubarraySum().new Solution();
        solution.minSubArrayLen(7,num);
    }
}