/*
Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,

         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:

         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL

利用宽搜顺序搜索每一行的二叉树，然后利用深搜搜索该节点的下一个next节点。
*/
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
	Queue<TreeLinkNode> que = new LinkedList<>();
	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		que.offer(root);
		while (!que.isEmpty()) {
			TreeLinkNode tln = que.poll();
			if (tln.left != null) {
				que.offer(tln.left);
				tln.left.next = dfs2(tln);
			}
			if (tln.right != null) {
				que.offer(tln.right);
				tln.right.next = dfs3(tln.next);
			}
		}
	}
	
	private TreeLinkNode dfs2(TreeLinkNode root){
		if(root == null) return null;
		if(root.right!=null) return root.right;
		if(root.next!=null&&root.next.left!=null){
			return root.next.left;
		}
		return dfs2(root.next);
	}
	
	private TreeLinkNode dfs3(TreeLinkNode root){
		if(root ==null) {
			return null;
		}else{
			if(root.left!=null) return root.left;
			if(root.right!=null)return root.right;
		}
		return dfs3(root.next);
	}
}
