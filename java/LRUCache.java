/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
*/


public class LRUCache {
	class Node{
		int key;
		int val;
		Node pre;
		Node next;
		Node(int key,int val){
			this.key = key;
			this.val = val;
		}
	}
	
	Node head = new Node(-1,-1);
	Node tail = new Node(-1,-1);
	private void moveToTail(Node no){
		this.removeNode(no);
		no.pre = tail.pre;
		no.next = tail;
		tail.pre.next = no;
		tail.pre = no;
	}
	
	private void addNode(Node no){
		no.pre = tail.pre;
		no.next = tail;
		tail.pre.next = no;
		tail.pre = no;
	}
	
	private void removeNode(Node no){
		no.pre.next = no.next;
		no.next.pre = no.pre;
	}
	
	private Node getHead(){
		return head.next;
	}
	Map<Integer,Node> map = new HashMap<>();
    int cap;
    int count = 0;
    public LRUCache(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
    	Node res = map.get(key);
        if(res == null) {
        	return -1;
        }else{
        	int val = res.val;
        	this.moveToTail(res);
        	return val;
        }
    }
    
    public void set(int key, int value) {
    	if(map.containsKey(key)){
    		Node res = map.get(key);
    		res.val = value;
    		this.moveToTail(res);
    	}else{
    		count++;
    		if(count>cap){
    			Node rem = this.getHead();
    			map.remove(rem.key);
    			rem.key = key;
    			rem.val = value;
    			this.moveToTail(rem);
    			map.put(key, rem);
    		}else{
    			Node nod = new Node(key,value);
				this.addNode(nod);
				map.put(key, nod);
    		}
    	}
    }
}
