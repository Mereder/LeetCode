### 问题描述

Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

注意是交换的 结点序的  奇数偶数 而不是 结点的值的奇偶数

**Example 1:**

```
Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL
```

**Example 2:**（令第1,3,5...奇数结点在前）

```
Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL
```

**Note:**

- The relative order inside both the even and odd groups should remain as it was in the input.
- The first node is considered odd, the second node even and so on ...

### 解题思路

由于第一个结点认为是odd的，只需要再构建一个even的链表，把even链表提取出来，最后再链接到odd的末尾即可。

构建even链表则需要两个指针，一个even头指针，一个指向even链表尾，可以保证将结点加到链表尾部。

### 题解

```java
    public static ListNode oddEvenList(ListNode head) {
        if(head == null) return null;
        // 相当于odd链表的尾指针
        ListNode odd = head;
        // even 链表的尾指针
        ListNode even = head.next;
        // even 链表的头指针
        ListNode evenhead = even;

        while(even != null && even.next!=null){
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenhead;
        return head;
    }
```

