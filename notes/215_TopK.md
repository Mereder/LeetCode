### 215 Topk 第K大

快排的partition一趟结果将一个数确定到最终位置，以第一个数为枢值，那么一趟快排后，如果枢值>k则在数值左侧进行partition，如果枢值<k 则在枢值右侧进行。

特殊用例 [99,99] 1   [3,3,3,3,3,3,3,3,3,3] 4

```java
public int findKthLargest(int[] nums, int k) {
		k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            final int j = partition(nums, lo, hi);
            if(j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
}
    private int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        while(true) {
            while(i < hi && less(a[++i], a[lo]));
            while(j > lo && less(a[lo], a[--j]));
            if(i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }
```

