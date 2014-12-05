/*Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.


简单的思想：正序排列时，某节点的右节点一定是该节点的右子树，中序排列，某节点的左节点一定是该节点的左子树；

深搜递归
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {  
        return buildTree(preorder,inorder,0,preorder.length-1,0,inorder.length-1);  
    }  
      
    private TreeNode buildTree(int []preorder, int []inorder,int pst,int pend,int inst, int inend){  
        if(pst>pend||inst>inend||preorder.length<1){  
            return null;  
        }  
        TreeNode tn =new TreeNode(preorder[pst]);  
        int index = -1;  
        for(int i=inst;i<=inend;i++){  
            if(inorder[i] == preorder[pst]){  
                index = i;  
                break;  
            }  
        }  
        tn.left = buildTree(preorder,inorder,pst+1,pst+index-inst,inst,inst+index-1);  
        tn.right = buildTree(preorder,inorder,pst+index-inst+1,pend,index+1,inend);  
        return tn;  
    }  
}  