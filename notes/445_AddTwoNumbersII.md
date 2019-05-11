### 题目描述

You are given two **non-empty** linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

与第2题类似，只不过这次的链表顺序跟2题链表顺序不一样。

**Follow up:**
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

**Example:**

```
Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7
```

### 解题思路

#### 方案一（不可以）：

将链表转为数字，然后进行数字加减，再将数字转为链表。以example为例，就是写成7243+564=7807

再将7807 构建为链表：7 -> 8 -> 0 -> 7

问题：当给一个特别大的数（大于Integer.MAX_VALUE）就发生了越界。方案行不通。

#### 方案二

链表问题还是按照链表的方法进行处理。由于低位在末尾，需要先加低位然后再高位。想到使用栈（先进后出）的特点。先将两个链表依次入栈，然后再同时出栈 相加。

关键点：对于进位的处理。使用一个变量sum，当和>=10时候，sum/=10是等于1的。当sum<10，sum/=10 是等于0 的，而下一位运算会在sum基础上继续。

### 题解

从题2中受到启发，循环条件是：

(!stack1.isEmpty() || !stack2.isEmpty() || sum != 0)

```java
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        ListNode p = l1;
        while(p != null){
            stack1.push(p);
            p =p .next;
        }
        p =  l2;
        while(p != null){
            stack2.push(p);
            p = p.next;
        }
        ListNode dummy = new ListNode(-1);
        int sum = 0;
        while(!stack1.isEmpty() || !stack2.isEmpty() || sum != 0){
            if (!stack1.isEmpty()) sum+= stack1.pop().val;
            if (!stack2.isEmpty()) sum+= stack2.pop().val;
            ListNode node = new ListNode(sum % 10);
            node.next = dummy.next;
            dummy.next = node;
            sum = sum / 10;
        }
        return  dummy.next;
    }
```



实际上每次将进位的1加到了第一个栈的栈顶元素上，如果没有则创建一个为1的结点。整体思路跟上面差不多，leetcode判题这个内存较小。。。

```java
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        ListNode p = l1;
        while(p != null){
            stack1.push(p);
            p =p .next;
        }
        p =  l2;
        while(p != null){
            stack2.push(p);
            p = p.next;
        }
        ListNode dummy = new ListNode(-1);
        int add = 0;
        int sum = 0;
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            if (!stack1.isEmpty()) sum+= stack1.pop().val;
            if (!stack2.isEmpty()) sum+= stack2.pop().val;
            if (sum >= 10){
                if (!stack1.isEmpty()){
                    stack1.peek().val += sum /10;
                }
                else {
                    stack1.push(new ListNode(sum/10));
                }
            }
            ListNode node = new ListNode(sum % 10);
            node.next = dummy.next;
            dummy.next = node;
            sum = 0;
        }
        return  dummy.next;
    }
```

