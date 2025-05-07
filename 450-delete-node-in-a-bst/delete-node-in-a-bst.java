/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val == key) {
            //no child
            if(root.right == null && root.left == null) return null;
            //only 1 child
            if(root.left == null && root.right != null) return root.right;
            if(root.right == null && root.left != null) return root.left;
            //has 2 children
            TreeNode node = helper(root.right, root);
            root.val = node.val;
        }else if(root.val < key){
            root.right = deleteNode(root.right, key);
        }else{
        root.left = deleteNode(root.left, key);
        }
        return root;
    }

    private TreeNode helper(TreeNode root, TreeNode parent){
        TreeNode pre = parent, cur = root;
        while(cur.left != null) {
            pre = cur;
            cur = cur.left;
        }
        deleteNode(pre, cur.val);
        return cur;
    }
}