/*Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].*/



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
    public List<Interval> merge(List<Interval> intervals) {
    	List<Interval> res = new ArrayList<>();
    	for(int i=0;i<intervals.size();i++){
    		res=insert(res,intervals.get(i));
    	}
        return res;
    }
    private List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	List<Interval> list = new ArrayList<Interval>();
    	if(intervals.size()==0){
    		list.add(newInterval);
    		return list;
    	}
		int start = newInterval.start;
		int end = newInterval.end;
		int mstart=-1;
		int mend=-1;
		int nstart = -1;
		int nend = -1;
		for(int i=0;i<intervals.size();i++){
			Interval in = intervals.get(i);
			Interval next = null;
			if(i!=intervals.size()-1) {
				next= intervals.get(i+1);
			}
			if(in.start<=start&&start<=in.end){
				mstart = i;
				nstart = in.start;
				break;
			}else if(i!=intervals.size()-1&&in.end<start&&start<next.start){
				mstart = i+1;
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
				mend = i;
				nend = in.end;
				break;
			}else if(i!=intervals.size()-1&&in.end<end&&end<next.start){
				mend = i;
				nend = end;
				break;
			}
		}
		if(mstart==-1&&mend ==-1){
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
		}else if(mstart==-1){
			mstart = 0;
			nstart = start;
				list = intervals.subList(mend+1, intervals.size());
			list.add(0,new Interval(nstart,nend));
			return list;
		}else if(mend == -1){
			mend = list.size()-1;
			nend = end;
				list = intervals.subList(0, mstart);
			list.add(new Interval(nstart,nend));
			return list;
		}
		list.addAll(intervals.subList(0, mstart));
		list.add(new Interval(nstart,nend));
		list.addAll(intervals.subList(mend+1, intervals.size()));
		return list;
    }
}