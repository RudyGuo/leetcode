/*Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
*/
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
    	unordered_map<char,int> ump;
    	int res = 0;
    	int start = 0;
    	for(string::size_type i=0;i<s.size();i++){
    		if(ump.find(s[i])!=ump.end()){
    			res = max(res,(int)i-start);
    			start = max(ump[s[i]]+1,start);
    		}
    		ump[s[i]] = i;
    	}
    	res = max(res,(int)s.size()-start);
    	return res;
    }
};


