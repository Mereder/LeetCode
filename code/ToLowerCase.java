/*
 * Date :  2019.
 * Author : Mereder
 */

package code;

public class ToLowerCase {
    public String toLowerCase(String str) {
        String temp = "";
        for (int i = 0; i < str.length(); i++) {
            char letter = str.charAt(i);
            if (Character.isUpperCase(letter)){
                letter = Character.toLowerCase(letter);
                temp += letter;
            }
            else {
                temp += letter;
            }
        }
        return temp;
    }

}
