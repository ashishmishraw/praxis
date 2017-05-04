package com.ashu.utils.ds.Queue;

import com.ashu.utils.ds.LinkedList.MySingLinkedList;

import java.util.concurrent.locks.ReentrantLock;

/**
 * My own implementation of FIFO Queue
 * @author ashishmishraw@bitbucket.org
 *
 */
public class MyFIFOQueue<T> {
	
	MySingLinkedList<T> list = null;
	int size = 0;
	int upperBound = -1;
	boolean blocking = false;
	
	public MyFIFOQueue() {
		this.list = new MySingLinkedList<T>();
	}
	
	public MyFIFOQueue(int limit) {
		this.list = new MySingLinkedList<T>();
		this.upperBound = limit;
	}
	
	public MyFIFOQueue(int limit, boolean blocking) {
		this.list = new MySingLinkedList<T>();
		this.upperBound = limit;
		this.blocking = blocking;
	}
	
	/**
	 * Enqueues an item in queue
	 * by adding it to the last index
	 * @param T - item
	 */
	public synchronized void enqueue(T item)
			throws InterruptedException, IndexOutOfBoundsException {


		if (blocking) {
			while (isFull()) { //until queue limit reduces
				wait(); //throttle producer 
			}
		} else {
			if (this.isFull()) {
				throw new IndexOutOfBoundsException("Queue already full, can't take it anymore !");
			}
		}
		this.list.addAtLast(item);
		notifyAll();

		size = this.list.size;
	}
	
	
	/**
	 * Dequeue an item from queue
	 * by removing the first item
	 *  
	 * @return
	 */
	public synchronized T dequeue()
			throws InterruptedException, IndexOutOfBoundsException {
		
		if (blocking) {
			while (this.isEmpty()) {	
				wait(); //consumer has to wait until producer enqueues
			}
		} else {
			if (this.isEmpty()) {
				throw new IndexOutOfBoundsException("Queue is already empty, could not dequeue anymore");
			}
		}
				
		MySingLinkedList.Node<T> node =  list.removeFromFirst();
		notifyAll();
		size = this.list.size;
		return node.value;
	}
	
	
	public boolean isEmpty() {
		return size ==0;
	}
	
	public boolean isFull() {
		return this.size == this.upperBound;
	}

	public static void main(String[] args) {
		MyFIFOQueue<String> queue = new MyFIFOQueue<>(10, true);
		System.out.println("tata");
	}
}
