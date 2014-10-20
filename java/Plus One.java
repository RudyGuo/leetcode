
/*Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.*/

public class Solution {
    public int[] plusOne(int[] digits) {
    	int len = digits.length;
        boolean f[] = new boolean[len];
        for(int i = len-1;i>=0;i--){
        	if(digits[i]==9&&(i==len-1||f[i+1])){
        		digits[i]=0;
        		f[i] = true;
        	}else{
        		digits[i]=digits[i]+1;
        		break;
        	}
        }
        if(f[0]){
        	int[] res = Arrays.copyOf(digits, len+1);
        	res[0] = 1;
        	return res;
        }
        return digits;
    }
}
