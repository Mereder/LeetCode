/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P589_NaryTreePreorderTraversal {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    //  递归解法；
    public List<Integer> result = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if(root == null) return result;
        result.add(root.val);
        while(!root.children.isEmpty()){
            preorder(root.children.remove(0));
        }
        return result;
    }

    public List<Integer> preorder_iterative(Node root){
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node p = stack.pop();
            result.add(p.val);
            while (!p.children.isEmpty()){
                int n = p.children.size();
                // 压入顺序问题
                stack.push(p.children.remove(n-1));
            }
        }
        return result;
    }
}
