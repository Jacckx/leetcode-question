//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 
//输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// k 的取值范围是 [1, 数组中不相同的元素的个数] 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的 
// 
//
// 
//
// 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。 
// Related Topics 数组 哈希表 分治 桶排序 计数 快速选择 排序 堆（优先队列） 👍 1461 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 根据出现的频率，构造map，其中key为数字，value为数字出现的评率
        HashMap<Integer, Integer> map = new HashMap();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 构建小顶堆添加map中元素，在堆中按照元素的value值进行排序
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());
        // 取map中元素，并添加到小顶堆里
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(entry);
            // 如果堆中的元素数量大于K，弹出较小的根节点
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // 输出堆中的key值到数组中
        int[] res = new int[k];
        int i = 0;
        while(!pq.isEmpty()) {
            res[i++] = pq.poll().getKey();
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new TopKFrequentElements().new Solution();
    }
}