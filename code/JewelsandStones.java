/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

public class JewelsandStones {
    public int numJewelsInStones(String J, String S) {
        int []letter = new  int[51];
        for (int i = 0; i < J.length(); i++) {
            char t = J.charAt(i);
            if (Character.isLowerCase(t)){
                letter[t-'a'] = 1;
            }
            else {
                letter[t-'A'+26] = 1;
            }
        }
        int count = 0;
        for (int i = 0; i < S.length() ; i++) {
            char t = J.charAt(i);
            if (Character.isLowerCase(t) && letter[t-'a'] == 1){
                count++;
            }
            else if (Character.isUpperCase(t) && letter[t-'a'+26] == 1){
                count++;
            }
            else continue;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println('A'-'a');
        System.out.println();
    }

}
