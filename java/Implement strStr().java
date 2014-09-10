// Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

// Do not allocate extra space for another array, you must do this in place with constant memory.

// For example,
// Given input array A = [1,1,2],

// Your function should return length = 2, and A is now [1,2].

public class Solution {
    public String strStr(String haystack, String needle) {
    	if(haystack==null||haystack.length()<needle.length()){
    		return null;
    	}
    	int hlen = haystack.length();
    	int nlen = needle.length();
    	for(int i = 0;i<=hlen - nlen;i++){
    		if(haystack.substring(i, i+nlen).equals(needle)){
    			return haystack.substring(i);
    		}
    	}
    	return null;
    }
}