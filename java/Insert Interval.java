/*Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	List<Interval> list = new ArrayList<Interval>();
    	if(intervals.size()==0){
    		list.add(newInterval);
    		return list;
    	}
		int start = newInterval.start;
		int end = newInterval.end;
		int indexStart=-1;//需要删除节点开始index
		int insexEnd=-1;//需要删除节点结束index
		int nstart = -1;//新建节点
		int nend = -1;
		for(int i=0;i<intervals.size();i++){
			Interval in = intervals.get(i);
			Interval next = null;
			if(i!=intervals.size()-1) {
				next= intervals.get(i+1);
			}
			if(in.start<=start&&start<=in.end){
				indexStart = i;
				nstart = in.start;
				break;
			}else if(i!=intervals.size()-1&&in.end<start&&start<next.start){
				indexStart = i+1;
				nstart = start;
				break;
			}
		}
		
		for(int i=0;i<intervals.size();i++){
			Interval in = intervals.get(i);
			Interval next = null;
			if(i!=intervals.size()-1) {
				next= intervals.get(i+1);
			}
			if(in.start<=end&&end<=in.end){
				insexEnd = i;
				nend = in.end;
				break;
			}else if(i!=intervals.size()-1&&in.end<end&&end<next.start){
				insexEnd = i;
				nend = end;
				break;
			}
		}
		if(indexStart==-1&&insexEnd ==-1){
			if(start>intervals.get(intervals.size()-1).end){
				list = intervals;
				list.add(newInterval);
			}else if(end<intervals.get(0).start){
				list = intervals;
				list.add(0, newInterval);
			}else{
				list.add(newInterval);
			}
			return list;
		}else if(indexStart==-1){
			indexStart = 0;
			nstart = start;
			list = intervals.subList(insexEnd+1, intervals.size());
			list.add(0,new Interval(nstart,nend));
			return list;
		}else if(insexEnd == -1){
			insexEnd = list.size()-1;
			nend = end;
			list = intervals.subList(0, indexStart);
			list.add(new Interval(nstart,nend));
			return list;
		}
		list.addAll(intervals.subList(0, indexStart));
		list.add(new Interval(nstart,nend));
		list.addAll(intervals.subList(insexEnd+1, intervals.size()));
		return list;
    }
}