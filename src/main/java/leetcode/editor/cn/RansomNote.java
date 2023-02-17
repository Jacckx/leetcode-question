//给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。 
//
// 如果可以，返回 true ；否则返回 false 。 
//
// magazine 中的每个字符只能在 ransomNote 中使用一次。 
//
// 
//
// 示例 1： 
//
// 
//输入：ransomNote = "a", magazine = "b"
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：ransomNote = "aa", magazine = "ab"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：ransomNote = "aa", magazine = "aab"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= ransomNote.length, magazine.length <= 10⁵ 
// ransomNote 和 magazine 由小写英文字母组成 
// 
// Related Topics 哈希表 字符串 计数 👍 633 👎 0

package leetcode.editor.cn;

public class RansomNote {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // 定义一个数组哈希表，用来存放26个英文字母
        int[] record = new int[26];

        // 遍历magazine，将magazine中的每个字符放入record中
        for (char c : magazine.toCharArray()) {
            record[c - 'a'] += 1;
        }
        // 遍历ransomNote，将ransomNote中的每个字符从record中进行减一
        for (char c : ransomNote.toCharArray()) {
            record[c - 'a'] -= 1;
        }

        // 对record进行遍历，如果小于0，则说明ransomNote不能由magazine中的字符组成，返回false
        for (int i : record) {
            if(i < 0) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new RansomNote().new Solution();
    }
}