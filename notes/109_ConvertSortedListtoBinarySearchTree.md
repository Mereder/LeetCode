### 题目描述

Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of *every* node never differ by more than 1.

将一个升序排列的单链表，构建成二叉树。

**Example:**

```
Given the sorted linked list: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
```

### 解题思路

题外话：之前看leetcode讨论版块，解决链表问题，无外乎就是 快慢指针，dummy指针，多几个指针，都能解决问题。不是很难。

这个题也不难，递归解决。建树的过程，就是建根，建左子树，建右子树，而左右子树又相当于建根，建.....

问题的关键就是 划分左右子树。（快慢指针，当快指针到结尾时，慢指针就是根节点，慢指针前面就是左子树，慢指针后边就是右子树）

### 题解

```java
public TreeNode sortedListToBST(ListNode head){
    if(head == null) return null;
    // 开始的起始结点就是 head  null
    return toBST(head,null);
}
public TreeNode toBST(ListNode head,ListNode tail){
    // 递归结束条件
    if(head ==  tail) return null;
    ListNode fast = head;
    ListNode slow = head;
    while(fast!=null && fast.next!=null){
        fast = fast.next.next;
        slow = slow.next;
    }
    TreeNode root = new TreeNode(slow.val);
    root.left = toBST(head,slow);
    root.right = toBST(slow.next,tail);
    return root;
}
```



