/*
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.

贪心法 如果此前一段的和小于零，则从以下一个加油站为起点，最后判断加的气是否大于用掉的气，思路参照leetcodee题解
*/
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
    	int all = 0;
    	int sum = 0;
    	int res = -1;
    	for(int i = 0;i<cost.length;i++){
    		all += gas[i] - cost[i];
    		if(sum+gas[i]-cost[i]>=0){
    			sum +=gas[i]-cost[i];
    		}else{
    			sum = 0;
    			res =i;
    		}
    	}
    	return all>=0?(res+1):-1;
    }
}
