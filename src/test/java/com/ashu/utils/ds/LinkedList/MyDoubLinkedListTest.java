package com.ashu.utils.ds.LinkedList;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyDoubLinkedListTest {

	MyDoubLinkedList<String> list;
	
	@Before
	public void setUp(){
		list = new MyDoubLinkedList<String>();
	}
	
	@Test
	public void test() {
		
		list.add(0, "tom");
		list.add(1, "dick");
		list.add(2, "harry");
		
		assertTrue(list.size==3);
		System.out.println(list.toString());
   
		assertEquals("tom", list.removeFirst().value);				
		assertTrue(list.size==2);
		
		assertEquals("dick", list.peek(0).value);
		assertEquals("harry", list.peek(1).value);
		System.out.println(list.toString());
		
		assertEquals("harry", list.removeLast().value);
		assertTrue(list.size==1);
		
		System.out.println(list.toString());
		
		assertEquals("dick",list.removeLast().value);
		assertTrue(list.size==0);
		
		list.addAtFront("ada");
		list.addAtLast("sam");
		assertTrue(list.size==2);
		System.out.println(list.toString());
		
		assertEquals("sam", list.remove(1).value);
		assertTrue(list.size==1);
		System.out.println(list.toString());
		
		assertEquals("ada", list.remove(0).value);
		assertTrue(list.size==0);
		System.out.println(list.toString());
	}
	

	
	@After
	public void tearDown(){
		list = null;
	}

}
