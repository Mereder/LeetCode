package code;

public class P342_isPowerOfFour {
    public boolean isPowerOfFour(int n) {
        if(n <= 0 ) return false;
        else return ((n&(n-1)) == 0 && ((n&0x5555555)!=0)) ;

    }
}
