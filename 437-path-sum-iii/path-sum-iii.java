class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        // Count paths starting from current root
        int pathsFromRoot = countPaths(root, targetSum);

        // Recursively count paths in left and right subtrees
        int pathsLeft = pathSum(root.left, targetSum);
        int pathsRight = pathSum(root.right, targetSum);

        return pathsFromRoot + pathsLeft + pathsRight;
    }

    // Helper method to count paths starting at current node
    private int countPaths(TreeNode node, long sum) {
        if (node == null) return 0;

        int count = 0;
        if (node.val == sum) count++;

        count += countPaths(node.left, sum - node.val);
        count += countPaths(node.right, sum - node.val);

        return count;
    }
}
