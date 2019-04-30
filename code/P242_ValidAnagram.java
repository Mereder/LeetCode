package code;

public class P242_ValidAnagram {
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
}
