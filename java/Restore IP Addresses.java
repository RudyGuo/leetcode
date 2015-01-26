/*Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)


深搜+回溯+剪枝

*/
public class Solution {  
    List<String> res = new ArrayList<String>();   
    List<Integer> list = new ArrayList<>();   
    public List<String> restoreIpAddresses(String s) {  
        if(s.length()<4||s.length()>12) return res;  
        help(s,list,0);  
        return res;  
    }  
      
    private void help(String s,List<Integer> list,int start){  
        if((s.length()-start)>(4-list.size())*3) return;  
        if(list.size()==4){  
            res.add(list.get(0)+"."+list.get(1)+"."+list.get(2)+"."+list.get(3));  
        }  
        for(int j=1;j<=3&&start+j<=s.length();j++){  
            String str;  
            if(list.size()==3){  
                str = s.substring(start);  
            }else{  
                str = s.substring(start,start+j);  
            }  
            int it = -1;  
            if(!(str.length()>=2&&str.charAt(0)=='0')) it = Integer.parseInt(str);  
            if(it>=0&&it<=255){  
                list.add(it);  
                help(s,list,start+j);  
                list.remove(list.size()-1);  
            }  
        }  
    }  
}  