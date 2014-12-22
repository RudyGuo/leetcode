/*The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
*/

public class Solution {  
    int f[];  
    public String getPermutation(int n, int k) {  
        f = new int[n+1];  
        if(k>factorial(n)) return "-1";  
        List<Integer> list = new ArrayList<Integer>();  
        for(int i=1;i<=n;i++){  
            list.add(i);  
        }  
        StringBuilder sb = new StringBuilder();  
        k--;  
        while(list.size()>0){  
            int mul = factorial(n-1);  
            int index = k/mul;  
            sb.append(list.get(index));  
            list.remove(index);  
            k = k%mul;  
            n--;  
        }  
        return sb.toString();  
    }  
    private int factorial(int num){  
        if(num == 0) return f[0]=1;  
        if(f[num]>0){  
            return f[num];  
        }else{  
            return f[num]=factorial(num-1)*num;  
        }  
          
    }  
}  Permutation Sequence