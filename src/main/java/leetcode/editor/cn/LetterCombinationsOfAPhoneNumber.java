//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 哈希表 字符串 回溯 👍 2478 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    StringBuilder sb = new StringBuilder();
    List<String> res = new ArrayList<>();
    // 数字和字母的映射
    String[] letterMap = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {
        // 边缘条件处理
        if (digits == null || digits.length() == 0) {
            return res;
        }
        backTracking(digits, 0);
        return res;
    }

    private void backTracking(String digits, int index) {
        // 终止条件
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }

        // 将index指向的数字转为int
        int digit = digits.charAt(index) - '0';
        // 从映射表中获取对应的字符集
        String str = letterMap[digit];

        // 遍历该字符集
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            // 注意这里使用index而不是i是因为我们要在不同的集合里查找
            backTracking(digits, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
    }
}