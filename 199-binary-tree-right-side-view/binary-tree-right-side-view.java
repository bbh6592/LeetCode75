import java.util.*;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();  // number of nodes at current level

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                // Add the rightmost node of each level
                if (i == size - 1) {
                    result.add(node.val);
                }

                // Add child nodes for next level
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }

        return result;
    }
}
