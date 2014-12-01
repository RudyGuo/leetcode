/*
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

深搜
*/
Path Sum
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
boolean res = false;
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return res;
        pathSum(root,sum,0);
        return res;
    }
    
    private void pathSum(TreeNode root,int sum,int val){ 
    if((root.left==null&&root.right==null)||res){
    if(val+root.val==sum) res = true;
    return;
    }
    if(root.left!=null){
    pathSum(root.left,sum,val+root.val);
    }
    if(root.right!=null){
    pathSum(root.right,sum,val+root.val);