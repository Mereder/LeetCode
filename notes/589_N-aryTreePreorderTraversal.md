### 题目描述

Given an n-ary tree, return the *preorder* traversal of its nodes' values.

For example, given a `3-ary` tree:

 

![img](https://assets.leetcode.com/uploads/2018/10/12/narytreeexample.png)

 

Return its preorder traversal as: `[1,3,5,6,2,4]`.

**Note:**

Recursive solution is trivial, could you do it iteratively?

Accepted

39,527

Submissions

58,923

### 题解

二叉树的拓展，直接上递归和迭代两种解法。

递归解法：需要注意的是每一个结点中需要遍历其所有子结点。

```java
    //  递归解法；
    public List<Integer> result = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if(root == null) return result;
        result.add(root.val);
        // 需要依次递归其所有children 注意是从  children 的下标0开始
        while(!root.children.isEmpty()){
            preorder(root.children.remove(0));
        }
        return result;
    }
```

迭代解法：还是需要栈，每次出栈一个的同时需要把其children安装逆序压入栈中。

```java
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
```

