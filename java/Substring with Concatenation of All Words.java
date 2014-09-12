/* You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.

For example, given:
S: "barfoothefoobarman"
L: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter). */

public class Solution {
  public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> list = new ArrayList<Integer>(); 
    	if(L.length == 0){
    		return list;
    	}
    	int lslen = L[0].length();
    	int inlen = lslen*L.length;
    	if(S.length()<inlen){
    		return list;
    	}
    	Map<String,Integer> map = new HashMap<>();
    	for(int i =0;i<L.length;i++){
    		if (map.containsKey(L[i])){
    			map.put(L[i], map.get(L[i])+1);
    		}else{
    			map.put(L[i], 1);
    		}
    	}
    	
    	for(int i =0;i<=S.length()-inlen;i++){
    		Map<String,Integer> hmap = new HashMap<>(map);
    		for(int j = i;j<=S.length()-lslen;j+=lslen){
    			String  temp = S.substring(j,j+lslen);
    			if(!hmap.containsKey(temp)) break;
    			if(hmap.get(temp)==1){
    				hmap.remove(temp);
    			}else{
    				hmap.put(temp, hmap.get(temp)-1);
    			}
    		}
    		if(hmap.size()==0){
    			list.add(i);
    		}
    	}
    	return list;
    }
}