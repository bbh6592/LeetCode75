class Solution {
    public int compress(char[] chars) {
        int index = 0;  // index to place the compressed result
        int i = 0;

        while (i < chars.length) {
            char currentChar = chars[i];
            int count = 0;

            // Count how many times the current character repeats
            while (i < chars.length && chars[i] == currentChar) {
                i++;
                count++;
            }

            // Place the character
            chars[index++] = currentChar;

            // If count > 1, place each digit of the count
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[index++] = c;
                }
            }
        }

        return index;
    }
}
