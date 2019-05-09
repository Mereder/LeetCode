/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

import java.util.*;

public class P429_NaryTreeLevelOrderTraversal {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    public List<List<Integer>> levelOrder(Node root) {
        // 需要注意 定义问题
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int current = 1;
        int next = 0;
        while(!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < current; i++) {
                Node p = queue.poll();
                temp.add(p.val);
                while(!p.children.isEmpty()){
                    queue.offer(p.children.remove(0));
                    next++;
                }
            }
            current = next;
            next = 0;
            result.add(temp);
        }
        return result;
    }
}
