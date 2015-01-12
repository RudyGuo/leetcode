/*
Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactlyL characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.

Return the formatted lines as:

[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Note: Each word is guaranteed not to exceed L in length.

click to show corner cases.

Corner Cases:
A line other than the last line might contain only one word. What should you do in this case?
In this case, that line should be left-justified.
注意最后的corner case即可。
*/
public class Solution {
    public List<String> fullJustify(String[] words, int L) {
        List<String> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        int i=0,len = 0,strLen = 0;
        while(i<words.length){
        	int wLen = words[i].length();
        	if(len ==0){
        		len += wLen;
        	}else{
        		len +=wLen+1;
        	}
        	strLen += wLen;
        	list.add(words[i]);
        	if(i<words.length-1&&len<L){
        		i++;
        		continue;
        	}else if(i==words.length-1&&len<=L){
        		StringBuilder sb = new StringBuilder();
        		sb.append(list.get(0));
        		for(int j=1;j<list.size();j++){
        			sb.append(" "+list.get(j));
        		}
        		for(int j=0;j<L-sb.length();i++){
        			sb.append(" ");
        		}
        		res.add(sb.toString());
        		break;
        	}
        	if(len==L){
        		res.add(help(list,L,strLen));
        		list.clear();
            	len = 0;
            	strLen = 0;
            	i++;
            	continue;
        	}
        	list.remove(list.size()-1);
        	res.add(help(list,L,strLen-wLen));
        	list.clear();
        	len = 0;
        	strLen = 0;
        }
        return res;
    }
    
    private String help(List<String> list,int L,int strLen){
    	if(list.size()==1){
    		StringBuilder sb = new StringBuilder();
    		for(int i=0;i<L-strLen;i++){
    			sb.append(" ");
    		}
    		return list.get(0)+sb;
    	}
    	int bLen = (L-strLen)/(list.size()-1);
    	int mod = (L-strLen)%(list.size()-1);
    	StringBuilder res = new StringBuilder();
    	StringBuilder sb = new StringBuilder();
    	for(int i=0;i<bLen;i++){
    		sb.append(" ");
    	}
    	res.append(list.get(0));
    	for(int i=1;i<=mod;i++){
    		res.append(sb+" "+list.get(i));
    	}
    	for(int i=mod+1;i<list.size();i++){
    		res.append(sb+list.get(i));
    	}
    	return res.toString();
    }
}
