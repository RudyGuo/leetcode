/*
There are two sorted arrays nums1 and nums2 of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
这是一道非常经典的题。这题更通用的形式是，给定两个已经排序好的数组，找到两者所有元素中第k 大的元素。O(m+ n)的解法比较直观，直接merge两个数组，然后求第k 大的元素。不过我们仅仅需要第k 大的元素，是不需要“排序”这么复杂的操作的。可以用一个计数器，记录当前已经找到第m 大的元素了。同时我们使用两个指针pA 和 pB，分别指向A和B数组的第一个元素，使用类似于merge sort的原理，如果数组A当前元素小，那么pA++，同时m++；如果数组B当前元素小，那么pB++，同时m++。最终当m 等于k 的时候，就得到了我们的答案，O(k)时间，O(1)空间。但是，当k 很接近m + n的时候，这个方法还是O(m+ n)的。有没有更好的方案呢？我们可以考虑从k 入手。如果我们每次都能够删除一个一定在第k 大元素之前的元素，那么我们需要进行k 次。但是如果每次我们都删除一半呢？由于A和B都是有序的，我们应该充分利用这里面的信息，类似于二分查找，也是充分利用了“有序”。假设A和B的元素个数都大于k/2，我们将A的第k/2个元素（即A[k/2-1]）和B的第k/2个元素（即B[k/2-1]）进行比较，有以下三种情况（为了简化这里先假设k 为偶数，所得到的结论对于k 是奇数也是成立的）：
•A[k/2-1] == B[k/2-1]
•A[k/2-1] > B[k/2-1]
•A[k/2-1] < B[k/2-1]
如果A[k/2-1] < B[k/2-1]，意味着A[0]到A[k/2-1的肯定在A ∪ B的top k元素的范围内，换句话说，A[k/2-1不可能大于A ∪ B的第k 大元素。留给读者证明。因此，我们可以放心的删除A数组的这k/2个元素。同理，当A[k/2-1] > B[k/2-1]时，可以删除B数组的k/2个元素。当A[k/2-1] == B[k/2-1]时，说明找到了第k 大的元素，直接返回A[k/2-1]或B[k/2-1]即可。因此，我们可以写一个递归函数。那么函数什么时候应该终止呢？
• 当 A 或 B 是空时，直接返回 B[k-1] 或 A[k-1]；
• 当 k=1 是，返回 min(A[0], B[0])；
• 当 A[k/2-1] == B[k/2-1] 时，返回 A[k/2-1] 或 B[k/2-1]

以上摘自：戴方勤 LeetCode题解
*/
class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
    	int len = nums1.size()+nums2.size();
    	if(len&0x1){
    		return findKthNumber(nums1,nums2,(len+1)/2);
    	}
    	return (findKthNumber(nums1,nums2,len/2)+findKthNumber(nums1,nums2,len/2+1))/2.0;
    }
private:
    int findKthNumber(vector<int> &v1,vector<int> &v2,int k){
    	if(v1.size()>v2.size()) return findKthNumber(v2,v1,k);
    	if(v1.size()==0) return v2[k-1];
    	if(k==1) return min(v1[0],v2[0]);
    	int ia = min(k/2,(int)v1.size());
    	int ib = k - ia;
    	if(v1[ia-1]<v2[ib-1]){
    		vector<int> vv(v1.begin()+ia,v1.end());
    		return findKthNumber(vv,v2,k-ia);
    	}else if(v1[ia-1]>v2[ib-1]){
    		vector<int> vv(v2.begin()+ib,v2.end());
    		return findKthNumber(v1,vv,k-ib);
    	}
    	return v1[ia-1];
    }
};


