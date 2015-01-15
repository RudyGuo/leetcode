/*Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.

利用PriorityQueue，然后写出排序规则，利用递归较方便
*/
public class Solution {
	  public String largestNumber(int[] num) {
	        PriorityQueue<Cmp> pq = new PriorityQueue<>();
	        for(int i=0;i<num.length;i++){
	        	pq.add(new Cmp(num[i]));
	        }
	        StringBuilder sb = new StringBuilder();
	        while(!pq.isEmpty()){
	        	sb.append(pq.poll().str);
	        }
	        int z = 0;
	        //若果出现类似“00”的情况的处理
	        while(z<sb.length()&&sb.charAt(z)=='0'){
	        	z++;
	        }
	        if(z==sb.length()) return "0";
	        return sb.substring(z);
	    }
	    
	    class Cmp implements Comparable{
	    	String str;
	    	Cmp(int str){
	    		this.str = str+"";
	    	}
			@Override
			public int compareTo(Object o) {
				// TODO Auto-generated method stub
				Cmp other = (Cmp)o;
				String oStr = other.str;
				return compare(oStr,str);

			}
			//递归比较
			private int compare(String a,String b){
				for(int i=0;i<a.length()&&i<b.length();i++){
					if(a.charAt(i)==b.charAt(i)) continue;
					return a.charAt(i)-b.charAt(i);
				}
				if(a.length()==b.length()){
					return 0;
				}else if(a.length()>b.length()){
					return compare(a.substring(b.length()),b);
				}
				return compare(a,b.substring(a.length()));
			}
	    }
}