/*Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".*/

public class Solution {
	public String addBinary(String a, String b) {
    	StringBuilder sb = new StringBuilder();
    	Boolean jin = false;
    	for(int i = a.length()-1,j=b.length()-1;i>=0&&j>=0;i--,j--){
    		char c1 =  a.charAt(i);
    		char c2 = b.charAt(j);
    		if(!jin){
				if (c1 == '1' && c2 == '1') {
					sb.insert(0, 0);
					jin = true;
				} else if (c1 == '0' && c2 == '0') {
					sb.insert(0, 0);
					jin = false;
				} else {
					sb.insert(0, 1);
					jin = false;
				}
    		}else{
				if (c1 == '1' && c2 == '1') {
					sb.insert(0, 1);
					jin = true;
				} else if (c1 == '0' && c2 == '0') {
					sb.insert(0, 1);
					jin = false;
				} else {
					sb.insert(0, 0);
					jin = true;
				}
    		}
    		if(i==0&&j==0){
    			if(jin) sb.insert(0, 1);
    			jin = false;
    		}else if(i==0){
    			for(int k=j-1;k>=0;k--){
    				char c3 = b.charAt(k);
    				if(jin){
    					if(c3=='1'){
	    					sb.insert(0, 0);
	    					jin = true;
    					}else{
    						sb.insert(0, 1);
    						jin = false;
    					}
    				}else{
    					sb.insert(0,c3);
    					jin = false;
    				}
    			}
    		}else if(j==0){
    			for(int k=i-1;k>=0;k--){
    				char c3 = a.charAt(k);
    				if(jin){
    					if(c3=='1'){
	    					sb.insert(0, 0);
	    					jin = true;
    					}else{
    						sb.insert(0, 1);
    						jin = false;
    					}
    				}else{
    					sb.insert(0,c3);
    					jin = false;
    				}
    			}
    		}
    	}
    	if(jin){
    		sb.insert(0,1);
    	}
    	return sb.toString();
    }
}
