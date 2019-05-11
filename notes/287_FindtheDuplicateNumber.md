题目链接：[Find the Duplicate Number](<https://leetcode.com/problems/find-the-duplicate-number/>)

### 题目描述

Given an array *nums* containing *n* + 1 integers where each integer is between 1 and *n* (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

简而言之：找出数组中重复的数。而且条件给的很好，数都是`1~N`，数组大小是`n+1`

**Example 1:**

```
Input: [1,3,4,2,2]
Output: 2
```

**Example 2:**

```
Input: [3,1,3,4,2]
Output: 3
```

**Note:**（万恶的限制）

1. You **must not** modify the array (assume the array is read only).
2. You must use only constant, *O*(1) extra space.
3. Your runtime complexity should be less than *O*(*n*2).
4. There is only one duplicate number in the array, but it could be repeated more than once.

Accepted

### 解题思路

先抛开限制（note），从这个题目出发，可以有两种基本做法。

方案一：修改数组   时间复杂度O（n）, 破坏了数组

因为数字都是在`1-N`之间，每一次都把一个数和他本身应该在的位置交换。如果其所在位置的数就是他本身，则说明重复了。举个例子：nums = {1，2，2}。首先nums[0] 是1，将1和1的位置数交换，nums={2,1,2}。再次判断nums[0]是2，应该和2的位置进行交换。但是此时nums[2]就是2.。说明发生了碰撞，即有重复。（这个过程像不像hash）。

方案二：不修改数组，但是需要O（N）空间复杂度。时间复杂度也是O（N）

类似桶排序，就是每次把一个数字都放到其对应下标的位置。如果再次放入时候发生碰撞则说明存在重复数字。

还是上面的例子，这时候需要新建一个mem={0,0,0}。遍历过程会先把nums[0]对应数字1放入，即mem={0,1,0}。然后遍历nums[1]对应数字2放入，则mem={0,1,2}。再到Num[2]的时候，对应2放入时发生碰撞。有重复。

上面两个方案都是只满足某一方面，并不能适应于本题的限制条件：

1. 数组只读，不允许修改
2. 仅使用常量空间。
3. 模型复杂度不能超过$O(N^2)$
4. 数组中只有一个重复数字，但是可能重复出现了不止一次。



本题的正确解法：

将其看成是一个有环的链表问题！！！ 然后解决找到环入口的思想，就找到了重复数字。

（如果不清楚如何找到环的入口，请参考：[链表的环以及环的入口](https://www.jianshu.com/p/7608f44e1baf)）

重点是如何将其理解为 **链表问题**

这个题巧妙之处就在于，数字都是`1~N`数组下标是`0~N`。

**问题抽象**（这个过程一定要明白，其实代码很简单）

0号结点相当于头结点，0号里面存的是下一个结点的位置，即nums[0]。之后的nums[i]都是存的i个结点的下个结点。

以{1,3,4,2,2}为例，头结点是0，其对应下标是1，下标为1的值是3，则连接成链表就是：1->3

下标为3的值为2，继续链接：1->3->2

下标为2的值为4，继续链接：1->3->2->4

下标为4的值为2，继续链接，诶！出现环了 。

而且2就是环的入口，且2也是我们要找的重复数字。（如果过程不明白可以看着代码写一写 推一推）

### 题解

```java
public int findDuplicate(int[] nums) {
    int n = nums.length;
    if (n <= 0 ) return 0;
    int slow = nums[nums[0]];
    int fast = nums[nums[nums[0]]];
    while (slow != fast){
        slow = nums[slow];
        fast = nums[nums[fast]];
    }
    fast = nums[0];
    
    while (fast != slow){
        fast = nums[fast];
        slow = nums[slow];
    }
    return slow;
}
```

