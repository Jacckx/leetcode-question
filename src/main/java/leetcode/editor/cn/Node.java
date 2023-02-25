package leetcode.editor.cn;

import java.util.List;

/**
 * @author Shaojun Chen
 * @version 1.0
 * @since 2023/2/25 16:08
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}
    public Node(int val) {
        this.val = val;
    }
    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}
