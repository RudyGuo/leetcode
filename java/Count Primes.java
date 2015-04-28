/*
Description:

Count the number of prime numbers less than a non-negative number, n

click to show more hints.

References:
How Many Primes Are There?

Sieve of Eratosthenes

Credits:
Special thanks to @mithmatt for adding this problem and creating all test cases.

判断某个数是否是质数，只要判断它是否除能整除于小于它的质数即可。
*/
public class Solution {
	List<Integer> prime = new ArrayList<>();
    public int countPrimes(int n) {
        int res = 0;
        for(int i=2;i<n;i++){
        	if(isPrime(i)) res++;
        }
        return res;
    }
    
    private boolean isPrime(int n){
    	int m = (int) Math.sqrt(n);
    	if(n==1) return false;
    	for(int itt:prime){
    		if(itt>m) break;
    		if(n%itt==0) return false;
    	}
    	prime.add(n);
    	return true;
    }
}


