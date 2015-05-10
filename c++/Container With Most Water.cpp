/*
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.
*/

class Solution {
public:
    int maxArea(vector<int>& height) {
    	if(height.size()<2) return 0;
    	int  left = 0,right = height.size()-1;
    	int weigh = height.size() - 1;
    	int res = 0;
    	while(left<right){
    		res = max(min(height[right],height[left])*weigh,res);
    		if(height[left]<=height[right]){
    			int cmp = height[left];
    			weigh--;
    			while(height[++left]<cmp){
    				weigh--;
    			}
    		}else{
    			int cmp = height[right];
    			weigh--;
    			while(height[--right]<cmp){
    				weigh--;
    			}
    		}
    	}
    	return res;
    }
};


