/*Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return

[
   [5,4,11,2],
   [5,8,4,5]
]
*/
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
	List<List<Integer>> res = new ArrayList<>();
	public List<List<Integer>> pathSum(TreeNode root, int sum){
        if(root==null) return res;
        pathSum(root,sum,0,new ArrayList<Integer>());
        return res;
    }
    
    private void pathSum(TreeNode root,int sum,int val,List<Integer> list){ 
    	List<Integer> la = new ArrayList<>(list);
    	la.add(root.val);
    	if((root.left==null&&root.right==null)){
    		if(val+root.val==sum) res.add(la);
    		return;
    	}
    	if(root.left!=null){
    		pathSum(root.left,sum,val+root.val,la);
    	}
    	if(root.right!=null){
    		pathSum(root.right,sum,val+root.val,la);
    	}
    }
}



