//字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数
//将返回左旋转两位得到的结果"cdefgab"。 
//
// 
//
// 示例 1： 
//
// 输入: s = "abcdefg", k = 2
//输出: "cdefgab"
// 
//
// 示例 2： 
//
// 输入: s = "lrloseumgh", k = 6
//输出: "umghlrlose"
// 
//
// 
//
// 限制： 
//
// 
// 1 <= k < s.length <= 10000 
// 
// Related Topics 数学 双指针 字符串 👍 356 👎 0

package leetcode.editor.cn;

public class ZuoXuanZhuanZiFuChuanLcof {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseLeftWords(String s, int n) {
        char[] str = s.toCharArray();
        // 1.反转区间为前n的子串
        reverse(str, 0, n - 1);
        // 2.反转区间为n到末尾的子串
        reverse(str, n, s.length() - 1);
        // 3.反转整个字符串
        reverse(str, 0, s.length() - 1);
        return new String(str);
    }

    private void reverse(char[] s, int start, int end) {
        while(start < end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new ZuoXuanZhuanZiFuChuanLcof().new Solution();
    }
}