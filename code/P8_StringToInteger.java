package code;

public class P8_StringToInteger {
    public int myAtoi(String str) {
        long ans = 0L;
        int index = 0;
        long max = 0x80000000L;
        boolean flag = false;
        while (index < str.length() && str.charAt(index) == ' ' ) {
            index++;
        }
        if( index < str.length()){
            if (str.charAt(index) == '+') {
                flag = false;
                index++;
            } else if (str.charAt(index) == '-') {
                flag = true;
                index++;
            }
            for (int i = index; i < str.length(); i++) {
                if (str.charAt(i) <= '9' && str.charAt(i) >= '0') {
                    ans = ans * 10 + (str.charAt(i) - '0');
                    if (ans > max ) {
                        ans = max;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (flag) ans = -ans;
            if (ans > Integer.MAX_VALUE) ans = Integer.MAX_VALUE;
            if (ans < Integer.MIN_VALUE) ans = Integer.MIN_VALUE;
            return (int) ans;
        }
        else return (int)ans;
    }
    public static void main(String[] args) {

        long test = 0x80000000L;
        System.out.println(test);
    }

}
