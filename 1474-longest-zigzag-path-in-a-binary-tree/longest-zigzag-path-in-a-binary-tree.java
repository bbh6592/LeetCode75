class Solution {
    int maxZigzag = 0;

    public int longestZigZag(TreeNode root) {
        dfs(root.left, 1, true);  // start left
        dfs(root.right, 1, false); // start right
        return maxZigzag;
    }

    private void dfs(TreeNode node, int length, boolean isLeft) {
        if (node == null) return;

        maxZigzag = Math.max(maxZigzag, length);

        if (isLeft) {
            // last move was to the left, so next move is right
            dfs(node.right, length + 1, false);
            dfs(node.left, 1, true);  // restart if going same direction
        } else {
            // last move was to the right, so next move is left
            dfs(node.left, length + 1, true);
            dfs(node.right, 1, false);  // restart if going same direction
        }
    }
}
