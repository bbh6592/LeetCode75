class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int groups = (n + k - 1) / k;
        String[] result = new String[groups];

        int index = 0;
        for(int i = 0; i < n; i += k) {
            String group = s.substring(i, Math.min(i + k, n));

            while(group.length() < k) {
                group += fill;
            }
            result[index++] = group;
        }
        return result;
    }
}