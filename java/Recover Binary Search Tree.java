
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.


OJ's Binary Tree Serialization:
The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.

Here's an example:

   1
  / \
 2   3
    /
   4
    \
     5
The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".

中序遍历，用一个List存储每个节点的位置，然后双指针一个从左往右，一个从右往左找到连个错误的位置，然后交换连个节点的值。

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
	List<TreeNode> list = new ArrayList<>();
    public void recoverTree(TreeNode root) {
    	mid(root);
    	int left = -1;
    	int right = -1;
    	for(int i=0;i<list.size()-1;i++){
    		if(list.get(i).val>list.get(i+1).val){
    			left = i;
    			break;
    		}
    	}
    	for(int j=list.size()-1;j>0;j--){
    		if(list.get(j).val<list.get(j-1).val){
    			right = j;
    			break;
    		}
    	}
    	int temp = list.get(left).val;
    	list.get(left).val = list.get(right).val;
    	list.get(right).val = temp;
    }
    
    private void mid (TreeNode root){
    	if(root==null) return;
    	mid(root.left);
    	list.add(root);
    	mid(root.right);
    }
}
