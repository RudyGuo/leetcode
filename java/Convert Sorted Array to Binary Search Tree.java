/*Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
深搜+递归

思想：每次将数组中最中间的数作为根节点，然后递归
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
    public TreeNode sortedArrayToBST(int[] num) {  
        return sortedArrayToBST(num,0,num.length-1);  
    }  
      
    private TreeNode sortedArrayToBST(int []num,int start,int end){  
        if(start>end||num.length<1) return null;  
        int mid = (start+end)/2;  
        TreeNode tn = new TreeNode(num[mid]);  
        tn.left = sortedArrayToBST(num,start,mid-1);  
        tn.right = sortedArrayToBST(num,mid+1,end);  
        return tn;  
    }  
}  