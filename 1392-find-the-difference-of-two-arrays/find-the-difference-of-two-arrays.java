class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        // Use Sets to store unique elements
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : nums1) set1.add(num);
        for (int num : nums2) set2.add(num);

        // Copy sets to modify
        Set<Integer> onlyIn1 = new HashSet<>(set1);
        Set<Integer> onlyIn2 = new HashSet<>(set2);

        // Remove common elements
        onlyIn1.removeAll(set2); // nums1 elements not in nums2
        onlyIn2.removeAll(set1); // nums2 elements not in nums1

        // Convert sets to lists and return
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(onlyIn1));
        result.add(new ArrayList<>(onlyIn2));

        return result;
    }
}
