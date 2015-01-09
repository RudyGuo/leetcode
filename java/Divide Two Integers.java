/*Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT.

时间复杂度  log（n）

有个coner case 

dividend = -2147483648

divisor = -1;

答案是2147483647

 

dividend = -2147483648

divisor = 1

答案是-2147483648 如果把判断正负放在最后的话就会overflow
*/
public class Solution {  
    public int divide(int dividend, int divisor) {  
        long a = dividend > 0 ? dividend : -(long)dividend;  
        long b = divisor > 0 ? divisor : -(long)divisor;  
        int sgn =(((dividend>0&&divisor>0)||(dividend<0&&divisor<0))?1:-1);  
        int res = 0;  
        while (a >= b) {  
            long c = b;  
            int i = 1;  
            while (a >= c) {  
                a -= c;  
                if(a>=0){  
                    res += sgn*(Math.pow(2, i - 1));  
                }else{  
                    break;  
                }  
                c <<= 1;  
                i++;  
            }  
        }  
        return  res;  
    }  
}  
