import java.util.Arrays;

class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);  // Step 1: Sort the array
        int left = 0, right = nums.length - 1;
        int count = 0;

        // Step 2: Use two pointers to find valid pairs
        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == k) {
                count++;
                left++;
                right--;
            } else if (sum < k) {
                left++;  // Need bigger numbers
            } else {
                right--; // Need smaller numbers
            }
        }

        return count;
    }
}
