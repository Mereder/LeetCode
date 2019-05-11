### 问题描述

Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only *distinct* numbers from the original list.

**Example 1:**

```
Input: 1->2->3->3->4->4->5
Output: 1->2->5
```

**Example 2:**

```
Input: 1->1->1->2->3
Output: 2->3
```

### 解题思路





### 题解

```
public static ListNode deleteDuplicates(ListNode head) {
    if(head == null) return null;
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode tail = dummy;
    ListNode p = head;
    int temp;
    while(p.next != null){
        if(p.val == p.next.val){
            temp = p.val;
            while(p!=null && p.val == temp  ){
                p = p.next;
            }
            tail.next = p;
            if(p == null) break;
        }
        else{
            tail.next = p;
            tail = tail.next;
            p = p.next;
        }
    }
    return dummy.next;
}
```