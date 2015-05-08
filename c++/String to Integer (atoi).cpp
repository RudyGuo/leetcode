/*
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

Update (2015-02-10):
The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.

spoilers alert... click to show requirements for atoi.

Requirements for atoi:
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.

注意
Input:	" 010"
Output:	0
Expected:	10
 
Input:	" -0012a42"
Output:	0
Expected:	-12

Input:	"-2147483648"
Output:	-2147483647
Expected:	-2147483648
*/
class Solution {
public:
    int myAtoi(string s) {
    	if(s.length() == 0) return 0;
    	string str(s,s.find_first_not_of(" "));
    	string stt;
    	//cout<<str<<endl;
    	if(str.size()==0){
    		return 0;
    	}
    	bool b = (str[0]=='-'||str[0]=='+'||(str[0]<='9'&&str[0]>='0'));
    	if(((str[0]=='-'||str[0]=='+')&&str.size()==1)||!b) return 0;
    	int sgn = str[0]=='-'?-1:1;
    	int start = (str[0]=='-'||str[0]=='+')?1:0;
    	long res = 0;
    	for(int i=start;i<str.length();i++){
    		if(str[i]>'9'||str[i]<'0') return sgn*res;
    		res = res*10+(str[i]-'0');
    		if(res>INT_MAX){
    			return sgn>0?INT_MAX:INT_MIN;
    		}
    	}
    	return sgn*res;
    }
};




