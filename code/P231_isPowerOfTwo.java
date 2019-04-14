package code;

public class P231_isPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0 ) return false;
        else return ((n&(n-1)) == 0) ;

    }

    public static void main(String[] args) {
            int a = 1;
            int b = 3;

        System.out.println(a&b);
    }
}
