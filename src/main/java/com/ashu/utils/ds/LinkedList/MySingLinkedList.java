package com.ashu.utils.ds.LinkedList;

/**
 * My Implementation of a SinglyLinkedList to analyse time-complexity
 * associated with its various operations
 * 
 * @author ashishmishraw@bitbucket.org
 * @param <T> - could take any object or Data-type
 */
public class MySingLinkedList <T> {
	
	public MySingLinkedList() {
	}
	
	public Node <T> head = null; //head pointer
	public Node <T> tail = null; //tail pointer
	public int size = 0; //size of linked-list
	
	
	/**
	 * O(1) - constant time
	 * @param value
	 */
	public void addAtFront( T value) {
		
		System.out.println("Adding " + value + " at front");
		Node<T> node = new Node<T>(value);
		
		if ( this.size ==0) {
			head = node;
			tail = node;
		} else {
			Node<T> temp = head;
			head = node;
			node.next = temp;
		}
		this.size++;
	}
	
	/**
	 * O(1) - constant time
	 * @param value
	 */
	public void addAtLast(T value) {
		
		System.out.println("Adding " + value + " at last");
		Node<T> newNode = new Node<T>(value);
		
		if (this.size == 0) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			Node<T> tmp = this.tail;
			tail = newNode;
			tmp.next = newNode;
			newNode.next = null;
		}
		this.size++;
	}
	
	
	/**
	 * O(N) complexity - iteration required
	 * @param value
	 * @param index
	 */
	public void addAnywhere(T value, int index) {
		
		System.out.println("Adding " + value + " at position " + index);
		
		if (index ==0 || index > size) return;
		if (index==1) {
			this.addAtFront(value);
		} 
		if (index ==size) {
			this.addAtLast(value);
		} else {
			Node<T> newNode= new Node<T>(value);
			Node<T> nodeB4Index = this.getNthNode(index-1);
			Node<T> tmp = nodeB4Index.next;
			nodeB4Index.next = newNode;
			newNode.next = tmp;
			this.size++;
		}
	}
	
	
	/**
	 * O(N) complexity 
	 * @param n
	 * @return
	 */
	public Node<T> getNthNode(int n) {
		
		Node<T> nd = this.head;
		if (this.size > n) {
			if ( n ==0) return null;
			if ( n ==1) return head;
			else {
				for (int index=1; index<=n; index++ ) {
					if (n == index) break;
					nd = nd.next;
				}
				return nd;
			}
		} else if (this.size == n) {
			return tail;
		} else return null;
	}
	
	
	/**
	 * Complexity O(N) - Removing from last seems simple, but have to iterate till second-last
	 * Node to update its NEXT pointer to the Next(Node) of last-node getting deleted
	 * @return
	 */
	public Node<T> removeFromLast() {
		
		if (this.size ==0) return null;
		if (this.size == 1) {
			Node<T> tmp = this.head;
			this.head = this.tail = null;
			this.size--;
			return tmp;
		}
		Node<T> lastButOneNode = getNthNode(this.size -1);
		Node<T> tmp = this.tail;
		this.tail = lastButOneNode;
		lastButOneNode.next = null;
		this.size--;
		return tmp;
	}
	
	
	/**
	 * O(1) - constant time
	 * @return
	 */
	public Node<T> removeFromFirst() {
		if (this.size ==0) return null;
		if (this.size == 1) {
			Node<T> tmp = this.head;
			this.head = this.tail = null;
			this.size--;
			return tmp;
		}
		Node<T> tmp = this.head;
		this.head = tmp.next;
		this.size--;
		return tmp;
	}
	
	/**
	 * Complexity O(N) if not removed from first
	*/
	public Node<T> remove(int index) {
		
		if (index ==0 || index > size) return null;
		if (index ==1 ) {
			return this.removeFromFirst();
		}
		if (this.size == index) {
			return this.removeFromLast();
		}
		Node<T> nodeB4Index = getNthNode(index -1);
		Node<T> tmp = nodeB4Index.next;
		nodeB4Index.next = tmp.next;
		this.size--;
		return tmp;
	}
	
	
	//testing
	public static void main(String[] args) {
		
		MySingLinkedList<String> linkedList= new MySingLinkedList<String>();
		
		//add at front test
		linkedList.addAtFront("Ronnie");
		linkedList.addAtFront("James");
		linkedList.addAtFront("Tom");
		linkedList.addAtFront("Dick");
		
		//read nth item test
		System.out.println(linkedList.toString());
		System.out.println("Getting " + (linkedList.size -1) + "th node: " + linkedList.getNthNode(linkedList.size-1 ).value );
		
		//removal From Last test
		Node<String> deleted = linkedList.removeFromLast();
		System.out.println("removed " + deleted.value);
		deleted = linkedList.removeFromLast();
		System.out.println("removed " + deleted.value);
		
		//read post removal test
		System.out.println(linkedList.toString());
		System.out.println("Getting " + (linkedList.size -1) + "th node: " + linkedList.getNthNode(linkedList.size-1 ).value );
		
		//add to last
		linkedList.addAtLast("Natasha");
		linkedList.addAtFront("Serra");
		System.out.println(linkedList.toString());
		
		//remove from anywhere test
		deleted = linkedList.remove(2);
		System.out.println("removed " + deleted.value);
		System.out.println(linkedList.toString());
		
		deleted = linkedList.remove(linkedList.size);
		System.out.println("removed " + deleted.value);
		System.out.println(linkedList.toString());
		
		deleted = linkedList.remove(1);
		System.out.println("removed " + deleted.value);
		System.out.println(linkedList.toString());
		
		linkedList.addAtFront("Jimmy");
		linkedList.addAtLast("Stefani");
		System.out.println(linkedList.toString());
		
		linkedList.addAnywhere("Tim", linkedList.size -1);
		System.out.println(linkedList.toString());
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
			value = val; 
		}
		
		Node<T> next;
		public T value;
	}
	
	
	public String toString() {
		StringBuffer printLine = new StringBuffer();
		
		if (size ==0) {
			return null;
		}
		/*if ( head == null && head == tail) {
			printLine.append("head --> null <-- tail");
		}
		printLine.append("head --> ");
		*/
		Node<T> n = this.head; 
		while (n != null) {
			printLine.append("| " + n.value + " |-->");// + n.next);
			n = n.next;
		}
		printLine.append(n);
		printLine.append("\nhead--> " + head.value);
		printLine.append(" ; tail--> " + tail.value);
		return printLine.toString();
	}

}
