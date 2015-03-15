/*
All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].
使用位存储，每个char型占两个字节，这样可以节省很多空间
*/
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
    	List<String> list = new ArrayList<>();
    	Map<Integer,Integer> map = new HashMap<>();
    	for(int i=0;i<s.length()-9;i++){
    		int bit =0;
    		for(int j=i;j<i+10;j++){
    			switch(s.charAt(j)){
    				case 'A': 
    					bit += 0;
    					break;
    				case 'C':
    					bit += 1;
    					break;
    				case 'G':
    					bit += 2;
    					break;
    				case 'T':
    					bit += 3;
    					break;
    			}
    			bit<<=2;
    		}
    		Integer value = map.get(bit);
    		if(value==null){
    			map.put(bit, 1);
    		}else if(value == 1){
    			list.add(s.substring(i,i+10));
    			map.put(bit, 2);
    		}
    	}
    	return list;
    }
}


