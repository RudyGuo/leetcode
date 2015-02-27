/*Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
以某个点为基点，求得与其他的点的斜率并记录在map，注意两点
1.斜率可能为无穷
2.如果遍历到的点与基点在相同位置则所有斜率的点都要加上1
*/
/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
    	if(points.length==0) return 0;
    	if(points.length==1) return 1;
        Map<Double,Integer> map = new HashMap<>();
        int res = 0;
        for(int i=0;i<points.length;i++){
        	int inf = 0;
        	int same = 0;
        	for(int j=0;j<points.length;j++){
        		if(i==j) continue;
        		if(points[j].x-points[i].x==0) {
        			if(points[j].y-points[i].y==0){
        				same++;
        				continue;
        			}
        			inf++;
        			continue;
        		}
        		Double key = ((double)(points[j].y-points[i].y))/(points[j].x-points[i].x);
        		Integer value = map.get(key);
        		Integer newVal = (value==null?1:value+1);
        		map.put(key, newVal);
        	}
        	Iterator<Double> it = map.keySet().iterator();
        	while(it.hasNext()){
        		res = Math.max(res, map.get(it.next())+same);
        	}
        	res = Math.max(res, inf+same);
        	map.clear();
        }
        return res+1;
    }
}
