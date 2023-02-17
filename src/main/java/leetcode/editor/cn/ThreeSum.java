//给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != 
//k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请 
//
// 你返回所有和为 0 且不重复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//解释：
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
//不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
//注意，输出的顺序和三元组的顺序并不重要。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,1]
//输出：[]
//解释：唯一可能的三元组和不为 0 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [0,0,0]
//输出：[[0,0,0]]
//解释：唯一可能的三元组和为 0 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
// Related Topics 数组 双指针 排序 👍 5616 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 判断边缘条件
        if (nums == null || nums.length < 3) {
            return res;
        }
        // 排序原始数组
        Arrays.sort(nums);
        // 遍历数组中的每一个元素，找出 a + b + c = 0
        // a = nums[i], b = nums[left], c = nums[right]
        // i为遍历的元素, left为i+1, right为数组末尾元素
        for (int i = 0; i < nums.length; i++) {
            // 排序之后如果第一个元素已经大于零，那么无论如何组合都不可能凑成三元组，直接返回
            if (nums[i] > 0) {
                return res;
            }
            // 这题不能有重复的三元组，需要对a进行去重
            // 因为当起始的值等于前一个元素，那么得到的结果将会和前一次相同
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            // 定义left和right下标，也就是b和c
            // 继续遍历数组直到left与right相遇为止
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right) {
                // 将三数进行相加，如果等于0，将结果对应的索引位置的值加入结果集中
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 在将左指针和右指针移动的时候，先对左右指针的值，进行判断
                    // 如果重复，直接跳过
                    // 因为i不变，当此时l和r取的数的值与前一个数相同，就没必要继续计算
                    while (right > left && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    while (right > left && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    right--;
                    left++;
                }
                // 此时三数之和小了，所以left下标要向右移动，这样才能让三数之和大点
                else if (sum < 0) {
                    left++;
                }
                // 此时三数之和大了，所以right下标要向左移动，直到left与right相遇为止
                else if (sum > 0) {
                    right--;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
    }
}