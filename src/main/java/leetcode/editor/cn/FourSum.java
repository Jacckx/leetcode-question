//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[
//b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）： 
//
// 
// 0 <= a, b, c, d < n 
// a、b、c 和 d 互不相同 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// 你可以按 任意顺序 返回答案 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,2,2], target = 8
//输出：[[2,2,2,2]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics 数组 双指针 排序 👍 1495 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return res;
        }
        Arrays.sort(nums);

        // 遍历数组中的每一个元素，找出 a + b + c + d = 0
        for (int i = 0; i < nums.length; i++) {
            // 剪枝操作，因为目标值不是0了，所以要添加判断条件
            // 比如说target是-10，不能因为-4 > -10而跳过
            if (nums[i] > 0 && nums[i] > target) {
                break;
            }
            // 对a进行去重
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            // 添加的另一个循环
            for (int j = i + 1; j < nums.length; j++) {
                // 对a进行去重
                if (j > i + 1 && nums[j] == nums[j-1]) {
                    continue;
                }

                // 以下和三数之和代码一样
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j],nums[left],nums[right]));
                        // 去重cd
                        while(left < right && nums[right] == nums[right-1]) {
                            right--;
                        }
                        while(left < right && nums[left] == nums[left+1]) {
                            left++;
                        }
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    }
                }
            }

        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new FourSum().new Solution();
    }
}