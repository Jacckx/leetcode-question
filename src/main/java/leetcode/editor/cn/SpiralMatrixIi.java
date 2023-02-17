//给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
// Related Topics 数组 矩阵 模拟 👍 916 👎 0

package leetcode.editor.cn;

public class SpiralMatrixIi {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        // 定义左边界
        int left = 0;
        // 定义右边界
        int right =  n - 1;
        // 定义上边界
        int top = 0;
        // 定义下边界
        int bottom = n - 1;
        // 定义二维数组
        int[][] matrix = new int[n][n];
        // 定义起始值
        int start = 1;
        // 定义终止值
        int end = n * n;
        while (start <= end) {
            // 1.从左到右
            for (int i = left; i <= right; i++) {
                matrix[top][i] = start++;
            }
            // 第一层填满，top往下移
            top++;

            // 2.从上到下
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = start++;
            }
            // 右侧填满，right往左移
            right--;

            // 3.从右到左
            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = start++;
            }
            // 底部填满，bottom往上移
            bottom--;

            // 4.从下到上
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = start++;
            }
            // 左侧填满，left往右移
            left++;
        }
        return matrix;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new SpiralMatrixIi().new Solution();
        solution.generateMatrix(4);
    }
}