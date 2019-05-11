### 题目描述

Sort a linked list using insertion sort.

![img](https://upload.wikimedia.org/wikipedia/commons/0/0f/Insertion-sort-example-300px.gif)

A graphical example of insertion sort. The partial sorted list (black) initially contains only the first element in the list.
With each iteration one element (red) is removed from the input data and inserted in-place into the sorted list
 插入排序：黑色部分表示有序，每一次迭代，红色元素从inputdata中删掉，插入到正确的排序位置

**Algorithm of Insertion Sort:**

1. Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
2. At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
3. It repeats until no input elements remain.
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

基本思想很简单，每一次迭代从head中拿出一个结点，然后插入到有序链表中。

从head每一次拿出一个结点需要一个辅助指针

插入有序链表过程，需要从前向后遍历，也需要辅助指针。

同时插入的时候需要判断什么情况下可以插入

### 题解

```java
public static ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        ListNode sortList = new ListNode(Integer.MIN_VALUE);
        ListNode p = head;

        while(head != null){
            p = head;
            head = head.next;
            p.next = null;
            if(sortList.next == null){
                sortList.next = p;
                continue;
            }
            ListNode q = sortList.next;
            if (q.val >= p.val){
                p.next = sortList.next;
                sortList.next = p;
                continue;
            }
            while(q != null){

                if (q.val < p.val && q.next == null){
                    q.next = p;
                    break;
                }
                if (q.val < p.val && q.next.val >= p.val){
                    p.next = q.next;
                    q.next = p;
                    break;
                }
                q = q.next;
            }
        }
        return sortList.next;
    }
```

更简洁的答案（来自leetcode高分答案）
差距就是在 判断条件上，还是思维不够。

```java
public ListNode insertionSortList(ListNode head) {
		if( head == null ){
			return head;
		}
		
		ListNode helper = new ListNode(0); //new starter of the sorted list
		ListNode cur = head; //the node will be inserted
		ListNode pre = helper; //insert node between pre and pre.next
		ListNode next = null; //the next node will be inserted
		//not the end of input list
		while( cur != null ){
			next = cur.next;
			//find the right place to insert
			while( pre.next != null && pre.next.val < cur.val ){
				pre = pre.next;
			}
			//insert between pre and pre.next
			cur.next = pre.next;
			pre.next = cur;
			pre = helper;
			cur = next;
		}
		
		return helper.next;
	}
```

