//给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否
//则返回 -1。 
//
// 
//示例 1: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 9
//输出: 4
//解释: 9 出现在 nums 中并且下标为 4
// 
//
// 示例 2: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 2
//输出: -1
//解释: 2 不存在 nums 中因此返回 -1
// 
//
// 
//
// 提示： 
//
// 
// 你可以假设 nums 中的所有元素是不重复的。 
// n 将在 [1, 10000]之间。 
// nums 的每个元素都将在 [-9999, 9999]之间。 
// 
// Related Topics 数组 二分查找 👍 1093 👎 0

package leetcode.editor.cn;

public class BinarySearch {

//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    // 左闭右闭区间
    public int search(int[] nums, int target) {
        // 对比最大最小值，当目标值压根就不存在的时候就直接返回，避免继续运行
        if (target < nums[0] || target > nums[nums.length-1]) {
            return -1;
        }

        // target落在左闭右闭的区间里 [left, right]
        int left = 0;
        int right = nums.length -1;

        // 当left = right时候，依然在区间[left,right]，所以用<=
        while (left <= right) {
            // 计算中间值，这么写是防止int整形溢出
            int mid = left + (right - left) / 2;
            // 数组中找到目标值，直接返回
            if (nums[mid] == target) {
                return mid;
            }
            // target落在左区间, 缩小右区间为[left, mid-1]
            else if (target < nums[mid]) {
                right = mid - 1;
            }
            // target落在右区间, 缩小左区间为[mid+1, right]
            else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }

    // 左闭右开区间
    public int search1(int[] nums, int target) {
        int left = 0;
        int right = nums.length; // 因为右开，所以right=n, 实际上right取不到n，所以不会有越界错误

        // 当left = right时候，区间[left,right)是无效空间的，所以用<
        while (left < right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == target) {
                return mid;
            }
            // target落在左区间
            // mid已经不是要找的数，所以right要更新为mid的前一个数，由于右开，取right=mid
            else if (target < nums[mid]) {
                right = mid;
            }
            // target落在右区间, 缩小左区间为 [mid+1, right)
            else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new BinarySearch().new Solution();
    }
}