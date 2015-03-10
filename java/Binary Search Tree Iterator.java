/*Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.


中续遍历存储在List里即可。
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

public class BSTIterator {
	List<TreeNode> list = new ArrayList<>();
	int len;
	int index = 0;
    public BSTIterator(TreeNode root) {
        inorderTraversal(root);
        len = list.size();
    }
    
    private void inorderTraversal(TreeNode root){
    	if(root==null) return;
    	inorderTraversal(root.left);
    	list.add(root);
    	inorderTraversal(root.right);
    }
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return index<len;
    }

    /** @return the next smallest number */
    public int next() {
        return list.get(index++).val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */


