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
    public static boolean f(TreeNode root,int sum,int target)
    {
        if(root==null)
        return false;
        if(root.left==null&&root.right==null)
        {
            sum+=root.val;
            if(sum==target)
            return true;
        }
        if(f(root.left,sum+root.val,target))
        return true;
        if(f(root.right,sum+root.val,target))
        return true;
        return false;
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // if(root==null)
        // return false;
        return f(root,0,targetSum);
    }
}