# leetcode-question

算法题集合，配合LeetCode Editor IDEA 插件使用体验感最佳。

使用前需配置好插件，例如：

1. LeetCode 用户名和密码

2. 选中 Custom Template、Show Tool Icon、Show Topic、Plugin Update、showEditorSign，其他关闭

3. 文件名模板

   ```java
   $!velocityTool.camelCaseName(${question.titleSlug})
   ```

   

4. 代码模板

   ```java
   ${question.content}
   package leetcode.editor.cn;
   
   public class $!velocityTool.camelCaseName(${question.titleSlug}) {
   
   ${question.code}
       
       public static void main(String[] args) {
           Solution solution = new $!velocityTool.camelCaseName(${question.titleSlug})().new Solution();
       }
   }
   ```

   
