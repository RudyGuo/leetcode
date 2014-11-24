/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]
宽搜
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
    public List<List<Integer>> levelOrder(TreeNode root) {
    	if(root==null) return res;
    	List<TreeNode> list = new ArrayList<TreeNode>();
    	list.add(root);
    	levelOrder(list);
    	return res;
    }

    private void levelOrder (List<TreeNode> list){
    	if(list.size()==0) return;
    	List<TreeNode> tn = new ArrayList<TreeNode>();
    	List<Integer> it = new ArrayList<>();
    	for(int i=0;i<list.size();i++){
    		TreeNode treeNode =list.get(i);
    		it.add(treeNode.val);
    		if(treeNode.left!=null){
    			tn.add(list.get(i).left);
    		}
    		if(treeNode.right!=null){
    			tn.add(list.get(i).right);
    		}
    	}
    	res.add(it);
    	levelOrder(tn);
    }
}


