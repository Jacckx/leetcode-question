//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回 滑动窗口中的最大值 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 1 <= k <= nums.length 
// 
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 👍 2124 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindowMaximum {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        int[] res = new int[nums.length - k + 1];
        int num = 0;
        // 自定义队列
        MonotonicQueue queue = new MonotonicQueue();

        // 将前k的元素放入队列
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }
        // 记录第一个窗口的最大值
        res[num++] = queue.max();
        for (int i = k; i < nums.length; i++) {
            // 滑动窗口移除最前面元素
            queue.poll(nums[i - k]);
            // 窗口向前滑动，加入新数字
            queue.add(nums[i]);
            // 记录当前窗口的最大值
            res[num++] = queue.max();
        }
        return res;
    }
}

class MonotonicQueue {
    // 双链表，支持头部和尾部增删元素
    private LinkedList<Integer> list = new LinkedList<>();

    // 添加元素时，如果要添加的元素大于入口处的元素，就将入口元素弹出
    // 保证了队列元素的单调递减
    public void add(int n) {
        while (!list.isEmpty() && list.getLast() < n) {
            list.removeLast();
        }
        list.addLast(n);
    };

    // 弹出元素时，比较当前要弹出的数值是否等于队列出口的数值，如果相等则弹出
    // 这里相等才弹出是因为比队列出口小的元素在push的时候就已经被弹出了
    public void poll(int n) {
        if (!list.isEmpty() && n == list.getFirst()) {
            list.removeFirst();
        }
    }

    // 队头的元素始终为最大值
    public int max() {
        return list.getFirst();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();
    }
}