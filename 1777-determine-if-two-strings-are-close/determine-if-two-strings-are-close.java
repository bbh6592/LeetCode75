import java.util.*;

class Solution {
    public boolean closeStrings(String word1, String word2) {
        // Step 1: If lengths differ, can't be close
        if (word1.length() != word2.length()) return false;

        // Step 2: Count character frequency in both strings
        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for (char c : word1.toCharArray()) count1[c - 'a']++;
        for (char c : word2.toCharArray()) count2[c - 'a']++;

        // Step 3: Check if both strings use the same characters
        for (int i = 0; i < 26; i++) {
            if ((count1[i] == 0 && count2[i] != 0) || (count1[i] != 0 && count2[i] == 0))
                return false;
        }

        // Step 4: Sort frequency arrays and compare
        Arrays.sort(count1);
        Arrays.sort(count2);

        return Arrays.equals(count1, count2);
    }
}
