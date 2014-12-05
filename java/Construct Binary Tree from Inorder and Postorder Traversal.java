/*Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

基本思想和知道前序与中序的思想一样，中序的某一节点的左节点一定是该节点的左子树，而后序遍历的某一节点的左节点一定是该节点的右子树，然后递归
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {  
        return buildTree(inorder,postorder,0,inorder.length-1,0,postorder.length-1);  
    }  
      
    private TreeNode buildTree(int []inorder, int []postorder,int inst,int inend,int postst, int postend){  
        if(inst>inend||postst>postend||inorder.length<1){  
            return null;  
        }  
        TreeNode tn =new TreeNode(postorder[postend]);  
        int index = Arrays.binarySearch(inorder, inst, inend+1, postorder[postend]);  
        tn.left = buildTree(inorder,postorder,inst,inst+index-1,postst,postst+index-inst-1);  
        tn.right = buildTree(inorder,postorder,index+1,inend,postst+index-inst,postend-1);  
        return tn;  
    }  
}  