package com.ashu.utils.ds.Queue;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class MyFIFOQueueTest {

	private MyFIFOQueue<String> queue ;
	private MyFIFOQueue<String> boundedQ;
	
	@Before
	public void setUp(){
		queue = new MyFIFOQueue<String>();
		boundedQ = new MyFIFOQueue<String>(3);
	}
	
	
	@Test
	public void test() throws InterruptedException {
		
		assertEquals(0, queue.size);
		
		queue.enqueue("abc");
		queue.enqueue("def");
		queue.enqueue("ijk");
		
		assertEquals(3, queue.size);
		
		String removedItem = queue.dequeue();
		assertEquals("abc", removedItem);
		
		assertEquals(2, queue.size);
		
		assertFalse(queue.isEmpty());
		
		removedItem = queue.dequeue();
		assertEquals("def", removedItem);
		
		removedItem = queue.dequeue();
		assertEquals("ijk", removedItem);
		
		assertTrue(queue.isEmpty());
	}
	
	
	@Test//(expected = IndexOutOfBoundsException.class)
	public void boundedTest() throws InterruptedException {
		
		assertEquals(0, boundedQ.size);
		
		boundedQ.enqueue("one");
		boundedQ.enqueue("two");
		boundedQ.enqueue("three");
		
		assertEquals(3, boundedQ.size);
		
		try {
			boundedQ.enqueue("four");
		} catch (IndexOutOfBoundsException anIndexOutOfBoundsException) {
	        assertThat(anIndexOutOfBoundsException.getMessage(), 
	        		is("Queue already full, can't take it anymore !"));
	    }
		
		String removedItem = boundedQ.dequeue();
		assertEquals("one", removedItem);
		removedItem = boundedQ.dequeue();
		assertEquals("two", removedItem);
		
		assertEquals(1, boundedQ.size);
		
		removedItem = boundedQ.dequeue();
		assertEquals("three", removedItem);
		
		assertTrue(boundedQ.isEmpty());
		
		try {
			boundedQ.dequeue();
		} catch (IndexOutOfBoundsException anIndexOutOfBoundsException) {
	        assertThat(anIndexOutOfBoundsException.getMessage(), 
	        		is("Queue is already empty, could not dequeue anymore"));
	    }
		
		
	}
	
	@Ignore
	public void concurrencyTest() {
		//TODO 
	}
	

	@After
	public void tearDown(){
		queue = null;
		boundedQ = null;
	}

}
