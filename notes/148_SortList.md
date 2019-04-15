### 题目描述

Sort a linked list in *O*(*n* log *n*) time using constant space complexity.

**Example 1:**

```
Input: 4->2->1->3
Output: 1->2->3->4
```

**Example 2:**

```
Input: -1->5->3->4->0
Output: -1->0->3->4->5
```

### 解题思路

对链表进行排序，将链表划分为两部分，分别对 链表的两部分进行sort ，然后再merge  （参考）

整体是一个递归的过程。  一个链表分成左右两条  把左边再分..... 

都是用过的知识：

1.划分过程 使用快慢指针，慢指针到的地方就是链表中间

2.merge 过程 就是 P21题 MergeSortedList

### 题解

```java
public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) return head;

    ListNode slow = head;
    ListNode fast = head;
    ListNode p = null;
    while(fast != null && fast.next != null){
        p = slow;
        slow = slow.next;
        fast = fast.next.next;
    }
    p.next = null;
    // 这个地方注意
    ListNode left = sortList(head);
    ListNode right = sortList(slow);

    return mergeLists(left,right);
}

public ListNode mergeLists(ListNode l1, ListNode l2){
    ListNode temp = new ListNode(-1);
    ListNode p = temp;
    while(l1 != null && l2 !=null){
        if (l1.val < l2.val){
            p.next = l1;
            l1 = l1.next;
        }
        else {
            p.next = l2;
            l2 = l2.next;
        }
        p = p.next;
    }
    if (l1 != null) p.next = l1;
    if( l2 != null) p.next = l2;
    return temp.next;
}
```