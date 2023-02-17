//给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。 
//
// 
// 如果剩余字符少于 k 个，则将剩余字符全部反转。 
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abcdefg", k = 2
//输出："bacdfeg"
// 
//
// 示例 2： 
//
// 
//输入：s = "abcd", k = 2
//输出："bacd"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由小写英文组成 
// 1 <= k <= 10⁴ 
// 
// Related Topics 双指针 字符串 👍 416 👎 0

package leetcode.editor.cn;

public class ReverseStringIi {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] arr = s.toCharArray();
        // 每隔 2k 个字符
        for (int i = 0; i < n; i+=2*k) {
            // 如果剩余字符小于2k但大于或等于k个，则反转前 k 个字符
            if (i + k <= n) {
                reverse(arr, i, i + k - 1);
            }
            // 剩余字符少于 k 个，则将剩余字符全部反转
            else {
                reverse(arr, i, n - 1);
            }
        }
        return new String(arr);
    }

    private void reverse(char[] s, int left, int right) {
        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new ReverseStringIi().new Solution();
        String s = "abcdefg";
        solution.reverseStr(s, 2);
    }
}