### 题目描述

Given a linked list, rotate the list to the right by *k* places, where *k* is non-negative.

**Example 1:**

```
Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
```

**Example 2:**

```
Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL
```

### 解题思路

自己的：

从第二个例子可以看到，当k==n时候，其实相当于没有做任何改变，转了一圈又回来了。

总体思路可以分为  k<n  和 k>=n   如果k<n 就是 移动k次，如果k大于n就是移动 k-n次（有一个测试没过，所以这里并不是k-n，而是  k%n  eg：[1],99 测试），既然需要n 则肯定需要先把n 算出来。

然后就是 循环k次，每次都把最后一个结点移动到最前面。

### 题解

```java
public static ListNode rotateRight(ListNode head, int k) {
    if(head == null || k <= 0) return head;
    int n = 0;
    ListNode p = head;
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    while(p != null){
        p = p.next;
        n++;
    }
    if(k >= n) k = k % n;
    while(k != 0){
        p = dummy.next;
        ListNode pre = dummy;
        while(p.next != null){
            p = p.next;
            pre = pre.next;
        }
        p.next = dummy.next;
        dummy.next = p;
        pre.next = null;
        k--;
    }
    return dummy.next;
}
```

自己的想法  写出来。然后又观摩了大神的写法：

```java
public ListNode rotateRight(ListNode head, int n) {
    if (head==null||head.next==null) return head;
    ListNode dummy=new ListNode(0);
    dummy.next=head;
    ListNode fast=dummy,slow=dummy;

    int i;
    for (i=0;fast.next!=null;i++)//Get the total length 
    	fast=fast.next;
    
    for (int j=i-n%i;j>0;j--) //Get the i-n%i th node
    	slow=slow.next;
    
    fast.next=dummy.next; //Do the rotation
    dummy.next=slow.next;
    slow.next=null;
    
    return dummy.next;
}
```

大神的思路是，直接判定需要移动的部分，将一个链表划分了两部分，以 12 3 4 5 k=2为例

那么就找到  1 2 3 的首位结点  以及  4 5 的首；

然后拼接在一起    4 5 | 1 2 3。