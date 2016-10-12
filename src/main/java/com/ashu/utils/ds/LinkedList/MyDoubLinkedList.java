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
		
		if (index ==0) {
			this.addAtFront(val);
		} else if (index == (this.size)) {
			this.addAtLast(val);
		} else {
			Node n = this.head;
			//iterate till the index
			for ( int i=0; i <= index; i++) {
				if (i== index) break;
				n = n.next;
			}
			Node<T> newNode = new Node<T>(val);
			Node current = n;
			newNode.next = current.next;
			newNode.prev = n;
			if (newNode.next == null)
				this.tail = newNode;
			else {
				current = current.next;
				current.prev = newNode;
			}
			n.next = newNode;
			this.size++;
		}
	}
	
	
	
	public Node<T> removeFirst() {
		
		if (size ==0) return null;
		
		if (size ==1) 
			tail = null;
		else 
			head.prev = null;
		
		Node tmp = head;
		head = head.next;
		
		return tmp;
	}
	
	
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
		return tmp;
	}
	
	
	
	/**
	 * Inner class
	 * @author ashishmishraw@bitbucket.org
	 *
	 * @param <T>
	 */
	private static class Node <T> {
		
		Node( T val) {
			next = null;
			prev = null;
			value = val; 
		}
		
		Node<T> next;
		Node<T> prev;
		T value;
	}
	
	
	public String toString() {
		StringBuilder printLine = new StringBuilder();
		
		if (size ==0) {
			return null;
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
