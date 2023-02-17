//给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4]
//解释：[4,9] 也是可通过的
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 1000 
// 
// Related Topics 数组 哈希表 双指针 二分查找 排序 👍 708 👎 0

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }

        Set<Integer> set = new HashSet<>();
        Set<Integer> res = new HashSet<>();

        // 将num1放入set
        for (int i : nums1) {
            set.add(i);
        }
        // 遍历nums2，判断哈希表中是否存在该元素
        for (int i : nums2) {
            // 存在的话就添加到res中
            if (set.contains(i)) {
                res.add(i);
            }
        }

        // 将结果res转换成数组
        return res.stream().mapToInt(x -> x).toArray();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoArrays().new Solution();
    }
}