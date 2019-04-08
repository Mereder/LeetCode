Given two strings *s* and *t* , write a function to determine if *t* is an anagram of *s*.

判断一个字符串是不是另一个字符串的  emmm 就是所含字符一样 顺序不一样的一个



长度不一 直接返回false

维护一个 26个字母的数组，依次代表a-z (均小写)。

对于s中含有的字符    都减去 'a' 在对应位置上++

同时对t中字符  同样操作

eg:     array[s.charat(i)-'a']++

 	array[t.charat(i)-'a']--

```java	
       public boolean isAnagram(String s, String t) {
        int []lowcase = new int[27];
        for (int i = 0; i < lowcase.length; i++) {
            lowcase[i] = 0;
        }
        if (s.length() != t.length()) return false;
        for (int i = 0; i < s.length(); i++){
            lowcase[s.charAt(i) - 'a']++;
            lowcase[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < lowcase.length; i++) {
            if (lowcase[i] == 0) continue;
            else return false;
        }
        return true;
    }
```

















（可以考虑  java hashmap  key = 字母   value 为数值）

