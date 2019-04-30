### 题目描述

We are given `head`, the head node of a linked list containing **unique integer values**.

We are also given the list `G`, a subset of the values in the linked list.

Return the number of connected components in `G`, where two values are connected if they appear consecutively in the linked list.

通俗的讲 就是有几个相连的片段：以example2为例子，G=[0, 3, 1, 4] ，但是在head中，0-1连在一起，3-4连在一起，所以 是两个。

**Example 1:**

```
Input: 
head: 0->1->2->3
G = [0, 1, 3]
Output: 2
Explanation: 
0 and 1 are connected, so [0, 1] and [3] are the two connected components.
```

**Example 2:**

```
Input: 
head: 0->1->2->3->4
G = [0, 3, 1, 4]
Output: 2
Explanation: 
0 and 1 are connected, 3 and 4 are connected, so [0, 1] and [3, 4] are the two connected components.
```

**Note:**

- If `N` is the length of the linked list given by `head`, `1 <= N <= 10000`.
- The value of each node in the linked list will be in the range` [0, N - 1]`.
- `1 <= G.length <= 10000`.
- `G` is a subset of all values in the linked list.

### 解题思路

要找的就是component的部分，判断component的部分是关键。

 即  扫描head链表过程，如果结点的值在G中，则是一个component，直到下一个结点不在G中或者下个结点为NULL，那么才是一个component的结尾，计数+1.

首先用一个hashmap来存放G中的数据，这样再扫描表时候，可以O（1）的时间判断是否存在于G中。

### 题解

```java
    public int numComponents(ListNode head, int[] G) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < G.length; i++) {
            hashMap.put(G[i], i);
        }
        ListNode p = head;
        int cnt = 0;
        boolean flag = false;
        while(p != null){
            if (hashMap.containsKey(p.val)){
                flag = true;
            }
            else flag =false;

            if (flag && (p.next == null || !hashMap.containsKey(p.next.val) )){
                cnt++;
                flag = false;
            }
            p = p.next;
        }
        return cnt;
    }
```

