package com.ashu.utils.ds.LinkedList;

/**
 * Doubly LinkedList implementation
 * @author ashismishraw
 *
 * @param <T>
 */
public class MyDoubLinkedList<T> {
	
	public MyDoubLinkedList() {}
	
	public Node <T> head = null; //head pointer
	public Node <T> tail = null; //tail pointer
	public int size = 0; //size of linked-list
	
	/**
	 * Adds the value at front as a Node in list
	 * @param value
	 */
	public void addAtFront( T value) {
		
		Node<T> newNode = new Node<T>(value);
		
		if ( size==0) {
			this.tail = newNode;
		} else {
			newNode.next = head;
			head.prev = newNode;
		}
		
		this.head = newNode;
		this.size++;
	}
	
	
	/**
	 * Adds the value at last as a Node in list
	 * @param value
	 */
	public void addAtLast(T value) {
		
		Node<T> newNode = new Node<T>(value);
		
		if ( size==0) {
			this.head = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
		}
		
		this.tail = newNode;
		this.size++;
	}
	
	
	
	/**
	 * O(N) complexity
	 * @param index
	 * @param val
	 */
	public void add(int index, T val) {
		
		if (index ==0) { // first index? - add at front
			this.addAtFront(val);
		} else if (index >= (this.size)) { //index same or greater than size? - always add at last
			this.addAtLast(val);
		} else {
			Node n = this.head;
			//iterate till the index
			for ( int i=0; i < index; i++) {
				n = n.next;
			}
			
			Node<T> newNode = new Node<T>(val);
			
			newNode.next = n; 
			newNode.prev = n.prev;
			n.prev.next = newNode;
			n.prev = newNode;
		
			this.size++;
		}
	}
	
	
	/**
	 * Looks up the particular {@link Node} at given index
	 * @param index
	 * @return {@link Node}
	 */
	public Node peek(int index ) {
		
		if (index ==0) return head;
		
		if (index == this.size-1 ) return tail;
		
		if (index < this.size-1 ) {
			
			Node n = this.head;
			for (int i=0; i < index; i++) {
				n = n.next;
			}	
			return n;
		}
		
		return null;
	}
	
	
	/**
	 * Removes first node from list
	 * @return {@link Node}
	 */
	public Node<T> removeFirst() {
		
		if (size ==0) return null;
		
		Node tmp = head;
		if (size ==1) { //can u say "if (head.next ==null)" ?
			tail = null;
		} else {
			head.next.prev = null;
			//head.next = null; //this causes problem .. only remove inward references, not outward refs from node which is removed 
		}
		
		head = tmp.next;
		this.size--;
		return tmp;
	}
	
	
	/**
	 * Removes last node from list
	 * @return {@link Node}
	 */
	public Node<T> removeLast() {
		
		Node tmp = tail;
		
		if (size == 0) return null;
		
		if (size==1) {
			head = null;
		} else {
			tail.prev.next = null;
		}
		//tail.prev = null; not required?
		tail = tail.prev;
		this.size--;
		return tmp;
	}
	
	
	/**
	 * Reoves the node at given index from list 
	 * @param index
	 */
	public Node<T> remove(int index) {
		
		if (index ==0) return removeFirst();
		
		if (index == size-1) return removeLast();
		
		if (index < size-1) {
			
			Node n = head;
			for (int i=0; i < index; i++) {
				n = n.next;
			}
			
			n.next.prev = n.prev;
			n.prev.next = n.next;
			
			return n;
		}
		
		return null;
	}
	
	
	
	/**
	 * Inner class
	 * @author ashishmishraw@bitbucket.org
	 *
	 * @param <T>
	 */
	public static class Node <T> {
		
		Node( T val) {
			next = null;
			prev = null;
			value = val; 
		}
		
		Node<T> next;
		Node<T> prev;
		T value;
	}
	
	
	/**
	 * Display this doubly linked list (only backwards?)
	 * 
	 */
	public String toString() {
		StringBuilder printLine = new StringBuilder();
		
		if (size ==0) {
			System.out.println("list is empty");
			return "{}";
		}
		
		Node<T> n = this.tail;		
		while (n != null) {
			printLine.insert(0, "<--| " + n.value + " |");// + n.next);
			n = n.prev;
		}
		printLine.insert(0,n);
		System.out.println("\nhead--> " + head.value + " ; tail--> " + tail.value);
		System.out.println("list size is " + this.size);
		return printLine.toString();
	}
	
	
	public static void main(String[] args) {
		
		MyDoubLinkedList<String> list = new MyDoubLinkedList<String>();
		
		list.add(0, "Itsi");
		System.out.println(list.toString());
		list.add(1, "bitsi");
		System.out.println(list.toString());
		list.add(2, "teeny");
		System.out.println(list.toString());
		list.add(1, "weeny");
		System.out.println(list.toString());
		
	}

}
