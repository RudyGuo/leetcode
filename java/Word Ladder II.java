/*
Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]

Return

  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
Note:

All words have the same length.
All words contain only lowercase alphabetic characters.

使用广搜：
由于要记录路径因此要注意两点
1：注意判重
2：使用一个树记录路径一般使用 Map<String,List<String>>();
*/
public class Solution {
	Set<String> used =  new HashSet<>();
	List<List<String>> res = new ArrayList<>();
	List<String> path = new ArrayList<>();
	public List<List<String>> findLadders(String start, String end, Set<String> dict){
		Queue<String> current = new LinkedList<>();
		Queue<String> next = new LinkedList<>();
		Map<String,List<String>> father = new HashMap<>();
		current.add(start);
		boolean found = false;
		while(!current.isEmpty()&&!found){
			for(String s:current){
				used.add(s);
			}
			while(!current.isEmpty()){
				String string = current.poll();
				char []str = string.toCharArray();
				for(int i=0;i<str.length;i++){
					char co = str[i];
					for(char ch ='a';ch<'z';ch++){
							if(ch == co) continue;
							str[i] = ch;
							String newStr = new String(str);
							if((dict.contains(newStr)||end.equals(newStr))&&!used.contains(newStr)){
								next.offer(newStr);
								List<String> path = father.get(newStr);
								if(path==null){
									path = new ArrayList<>();
									path.add(string);
								}else{
									if(!path.contains(string))
									path.add(string);
								}
								father.put(newStr, path);
								if(end.equals(newStr)) found = true;
							}
						}
						str[i] = co;
					}
				}
				if(found) break;
				Queue<String> temp = current;
				current = next;
				next = temp;
		}
		if(!found) return res;
		path.add(end);
		genRes(start,path,father,end);
		return res;
	}
	 
 	private void genRes(String start,List<String> path,Map<String,List<String>> father,String str){
 		if(str.equals(start)){
 			List<String> list = new ArrayList<>(path);
 			Collections.reverse(list);
 			res.add(list);
 			return;
 		}
 		List<String> lin = father.get(str);
 		for(int i=0;i<lin.size();i++){
 			String s = lin.get(i);
			path.add(s);
 			genRes(start,path,father,s);
 			path.remove(path.size()-1);
 		}
 	}
}


