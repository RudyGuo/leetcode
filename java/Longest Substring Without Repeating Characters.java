// Given a string, find the length of the longest substring without repeating characters. 
// For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
// which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        
        Map<Character,Integer> ha=new HashMap<Character,Integer>();
        int length=0;
        int max=0;
        
        for(int i =0;i<s.length();i++){
            length++;
            if(ha.containsKey(s.charAt(i))){
                length=Math.min(length,i-ha.get(s.charAt(i)));
            }
            ha.put(s.charAt(i),i);
            max=Math.max(length,max);
        }
        return max;
    }
}