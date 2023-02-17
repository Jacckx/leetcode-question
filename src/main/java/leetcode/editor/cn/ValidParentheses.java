//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 每个右括号都有一个对应的相同类型的左括号。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 👍 3736 👎 0

package leetcode.editor.cn;

import java.util.Stack;

public class ValidParentheses {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        // 如果字符串长度为奇数，则肯定不能匹配
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // 碰到左括号将相应的右括号入栈
            if (ch == '(') {
                stack.push(')');
            }
            else if (ch == '[') {
                stack.push(']');
            }
            else if (ch == '{') {
                stack.push(']');
            }
            // 如果栈为空或者栈顶元素不想等，则return false，
            // 这里判断栈是否为空放在前面，避免栈为空的时候取栈顶元素出现异常
            else if (stack.isEmpty() || stack.peek() != ch) {
                return false;
            }
            else {
                stack.pop();
            }
        }
        // 最后判断栈是否为空
        return stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
    }
}