## 经常用到Hash的一些算法

### 1 TwoSum

Java  hashmap的用法 类似于Python  里面的 dict 字典

先将 数组 进行 hashmap 

再从 hashmap中寻找   目标值和另一个加数的差值

如果找到 且 index ！= i 则说明存在 TwoSum

算法复杂度 为O（n）



three sum 的问题 也是 类似这样求解 复杂度 降低到o（n^2）



### 167 TwoSum sorted

双指针，lo++，hi--

sum > target    hi--

sum< target    lo++ 

  