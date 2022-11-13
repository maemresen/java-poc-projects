package com.maemresen.data.structures.examples;

public  class MyList <T>{

	ListNode head;
	ListNode tail;

	public MyList(){
		head = null;
		tail = null;
	}


	public void add(T element){

		if(head == null){
			head = new ListNode(element);
			tail = head;
			return;
		}

		if(head == tail){
			tail = new ListNode(element);
			head.next = tail;
			return;
		}

		tail.next = new ListNode(element);
		tail = tail.next;
	}


	public String toString(){
		String result = "";
		ListNode curr = this.head;
		while(curr != null){
			result += curr.val.toString()+" -> ";
			curr = curr.next;
		}
		return result+"null";
	}

	public ListNode lastSecond(){

		if(head == null || head.next == null){
			return null;
		}
		ListNode curr = head;
		while(true){
			if(curr.next.next == null){
				ListNode result = new ListNode(curr.val);
				return result;
			}
			curr = curr.next;
		}

	}


	public MyList clone(){

		MyList<T> clone = new MyList<>();
		ListNode curr = head;
		while(curr != null){
			clone.add(curr.val);
			curr = curr.next;
		}

		return clone;
	}

	private class ListNode{

		public T val;
		public ListNode next;

		public ListNode(T val){
			this.val = val;
		}

		public String toString(){
			return this.val.toString();
		}

	}


}