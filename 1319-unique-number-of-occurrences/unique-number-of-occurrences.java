class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        // Count frequency of each number
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Use a Set to check if frequencies are unique
        Set<Integer> freqSet = new HashSet<>(freqMap.values());

        // If sizes are different, some frequencies were duplicates
        return freqMap.size() == freqSet.size();
    }
}
