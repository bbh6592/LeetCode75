class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int count = 0;

        Map<String, Integer> map = new HashMap<>();

        for(int[] row : grid) {
            String key = Arrays.toString(row);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for(int col = 0; col < n; col++) {
            int[] temp = new int[n];
            for(int row = 0; row < n; row++){
                temp[row] = grid[row][col];
            }
            String key = Arrays.toString(temp);
            count += map.getOrDefault(key, 0);
        }
        return count;
    }
}