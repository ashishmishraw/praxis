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
		//fail("Not yet implemented");
		
		list.add(0, "tom");
		list.add(1, "dick");
		list.add(2, "harry");
		
		assertTrue(list.size==3);
		
		list.removeFirst();
		
		assertTrue(list.size==2);
		
		list.removeLast();
		assertTrue(list.size==1);
		
		list.toString();
		
		list.removeLast();
		assertTrue(list.size==0);
	}
	
	
	@After
	public void tearDown(){
		list = null;
	}

}
