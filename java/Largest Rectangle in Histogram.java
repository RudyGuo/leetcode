/*Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given height = [2,1,5,6,2,3],
return 10.
*/
public class Solution {
    public int largestRectangleArea(int[] height) {
    	if(height.length == 0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int []arr= Arrays.copyOf(height, height.length+1);
        arr[height.length] = 0;
        int res = 0;
        for(int i=0;i<arr.length;){
            if(stack.isEmpty()||arr[stack.peek()]<arr[i]){
            	stack.push(i++);
            }else{
            	int temp = arr[stack.pop()];
            	res = Math.max(res, temp*(stack.isEmpty()?i:i-stack.peek()-1));
            }
        }
        return res;
    }
}



