### 题目描述

We are given a linked list with `head` as the first node.  Let's number the nodes in the list: `node_1, node_2, node_3, ...` etc.

Each node may have a *next larger* **value**: for `node_i`, `next_larger(node_i)` is the `node_j.val` such that `j > i`, `node_j.val > node_i.val`, and `j` is the **smallest** possible choice.  If such a `j` does not exist, the next larger value is `0`.

Return an array of integers `answer`, where `answer[i] = next_larger(node_{i+1})`.

Note that in the example **inputs** (not outputs) below, arrays such as `[2,1,5]` represent the serialization of a linked list with a head node value of 2, second node value of 1, and third node value of 5.

简而言之：找下一个比`node_i`大的值`node_j`，且`j`最小。如果没有则置0

**Example 1:**

```
Input: [2,1,5]
Output: [5,5,0]
```

**Example 2:**

```
Input: [2,7,4,3,5]
Output: [7,0,5,5,0]
```

**Example 3:**

```
Input: [1,7,5,1,9,2,5,1]
Output: [7,9,9,9,0,5,0,0]
```

**Note:**

1. `1 <= node.val <= 10^9` for each node in the linked list.
2. The given list has length in the range `[0, 10000]`.

### 解题思路

很简单，一开始想复杂了。。。

只需要找到下一个比`node_i`大的值即可。两个循环，外层循环标记当前节点`node_i`，内层循环遍历`node_i`之后的结点，只要找到第一个比`node_i`大的结点就退出内层循环，然后给结果数组赋值。时间复杂度`O(n^2)`。

### 题解

```java
    public static int[] nextLargerNodes(ListNode head) {
        // 异常处置部分
        if (head == null ) return null;
        int n = 0;
        ListNode p = head;
        while(p != null){
            p = p.next;
            n++;
        }
        if (n == 0 ) return null;
        // 以上
        int []result = new int[n];
        ListNode tail = head;
        // i来标记返回数组的位置，以tail是同步的
        int i = 0;
        // tail 为 node_i
        while(tail != null){
            int max = 0;
            p = tail;
            // p 为 node_j
            while(p != null){
                if (p.val > tail.val){
                    max = p.val;
                    break;
                }
                p=p.next;
            }
            // 如果存在较大值 则max就是，不存在 则max默认为0；
            result[i] = max;
            i++;
            tail = tail.next;
        }
        return result;
    }
```



### 大神解法

借助栈来实现，时间复杂度`O(n)`,空间复杂度`O(n)`。

思路：栈内存放的是 `结点的编号`。 每压入一个编号前，先检查该编号对应元素是否大于栈顶的编号对应元素，、如果大于，则栈顶编号出列，且栈顶编号对应元素的greater为 当前编号对应元素。如果不大于，则继续压栈。

使用ArrayList方便获取编号和元素的对应关系，且无需固定长度数组。

```java
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> A = new ArrayList<>();
        for (ListNode node = head; node != null; node = node.next)
            A.add(node.val);
        int[] res = new int[A.size()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.size(); ++i) {
            while (!stack.isEmpty() && A.get(stack.peek()) < A.get(i))
                res[stack.pop()] = A.get(i);
            stack.push(i);
        }
        return res;
    }
```



