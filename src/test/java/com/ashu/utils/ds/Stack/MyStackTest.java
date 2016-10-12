package com.ashu.utils.ds.Stack;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyStackTest {

	MyStack<String> stack ;
	
	@Before
	public void setUp(){
		
		stack = new MyStack<>(5);
	}
	
	
	@Test
	public void test() throws InterruptedException {
		
		assertTrue(stack.size == 0);
		
		stack.push("A");
		stack.push("B");
		stack.push("C");
		
		assertTrue(stack.size == 3);
		assertEquals(stack.top, 2);
		
		stack.pop();
		
		assertTrue(stack.size == 2);
		assertEquals(stack.top, 1);
		assertTrue(stack.peek().equals("B"));
		System.out.println(stack.toString());
		
		stack.push("D");
		stack.push("E");
		stack.push("F");
		
		assertTrue(stack.size == 5);
		assertEquals(stack.top, 4);
		
		stack.powerPop();
		
		assertTrue(stack.size == 4);
		assertEquals(stack.top, 3);
		assertTrue(stack.peek().equals("E"));
		
		System.out.println(stack.toString());		
		
		stack.push("G");
	
		assertEquals(stack.powerPop(), "G");
		assertEquals(stack.powerPop(), "E");
		assertEquals(stack.powerPop(), "D");
		assertEquals(stack.powerPop(), "B");
		
		assertTrue(stack.size == 1);
		assertEquals(stack.top, 0);
		assertTrue(stack.peek().equals("A"));
		
		stack.push("H");
		System.out.println(stack.toString());
		assertTrue(stack.list.size() == 5);
	}
	
	
	
	@After
	public void tearDown(){
		stack = null;
	}

}
