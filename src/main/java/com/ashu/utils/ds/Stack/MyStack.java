package com.ashu.utils.ds.Stack;

import java.util.ArrayList;

/**
 * My implementation of thread-safe bounded blocking stack 
 * 
 * @author ashishmishraw@bitbucket.org
 *
 * @param <T>
 */
public class MyStack<T> {
	
	public MyStack() {
		list = new ArrayList<T>();
	}
	
	public MyStack(int limit) {
		this.upperBound = limit;
		list = new ArrayList<T>(limit);
	}
	
	ArrayList<T> list = null;
	int size = 0;
	int upperBound = -1;
	int top = -1;
	
	
	public synchronized void push(T item) throws InterruptedException {
		
		while (this.size == this.upperBound) {
			wait();
		}
		
		top++; //move top index
		if (this.size < list.size())
			list.set(top,item);
		else
			list.add(item); //add at index (top is incremented already)
		notifyAll();
		size = top+1;
	}
	
	
	/**
	 * Provides the item from top of stack
	 * does not update the 
	 * 
	 * @return T item
	 * @throws InterruptedException
	 */
	public synchronized T peek() throws InterruptedException {
		
		while (this.size ==0) {
			wait();
		}
		
		T item = list.get(top);
		notifyAll();
		return item;
	}
	
	
	/**
	 * Removes the item from top of stack based on 
	 * LIFO eligibility, and updates the positions
	 * @return
	 * @throws InterruptedException
	 */
	public synchronized T pop() throws InterruptedException {
		
		if (list.isEmpty()) {
			wait();
		}
		
		T item = list.remove(top);
		top--;
		size = top+1;
		notifyAll();
		return item;
	}
	
	/**
	 * Improved pop, does not remove item
	 * @return
	 * @throws InterruptedException
	 */
	public synchronized T powerPop() throws InterruptedException {
		
		if (list.isEmpty()) {
			wait();
		}
		T item = list.get(top);
		top--;
		size = top +1;
		notifyAll();
		return item;
	}
	
	
	
	public String toString() {
		
		StringBuilder printLine = new StringBuilder();
		
		if (size ==0) {
			return null;
		}
		
		printLine.append(list.toString());
		printLine.append("Top--> Stack[" + top + "] = " + list.get(top) + "; size = " + this.size);
		return printLine.toString();
	}


	public int size() {
		return this.size;
	}

}
