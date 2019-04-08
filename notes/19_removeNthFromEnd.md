### 题目描述

Given a linked list, remove the *n*-th node from the end of list and return its head.

**Example:**

```
Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
```

**Note:**

Given *n* will always be valid.



### 解题思路

是找到链表倒数第N个结点的变种。

如果需要删掉倒数第n个结点 那么在  删掉结点的前面 还应该有一个指针，以便删掉结点后能链接上后边

1. 总体思路 ：找到链表倒数第N个结点的思路；
2. 多加一个pre结点 始终位于slow结点前一个  方便做删除操作  pre.next = slow.next（删掉了slow）

Trick：

​	因为想到需要令pre在slow的前一个，那么如果 pre = head; slow = head。需要让slow,fast先走一步 然后 再 pre slow fast同时走。

这里加了一个 伪头结点temp   -1->head ,这样 pre = temp， 然后 三个节点同时走 就ok 了。

（不加也可以的，抖个机灵，不加就按照上面说的 先单走一步slow 和fast） 

### 题解

```java
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) return null;
		//  伪头结点
        ListNode temp = new ListNode(-1);
        temp.next = head;
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = temp;
        while (fast != null){
            fast = fast.next;
            n--;
            if (n == 0){
                break;
            }
        }
        // 如果fast到尾  n>0  那么 链表长度<n
        if (n > 0 ) return null;
        
        while (fast != null ){
            fast = fast.next;
            slow = slow.next;
            pre = pre.next;
        }
        pre.next = slow.next;
        // 注意返回
        return temp.next;
    }
```

