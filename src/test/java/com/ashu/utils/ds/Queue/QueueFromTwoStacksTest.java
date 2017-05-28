package com.ashu.utils.ds.Queue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by mishra.ashish@icloud.com
 */
public class QueueFromTwoStacksTest {

    QueueFromTwoStacks queue;

    @Before
    public void setUp(){
        queue = new QueueFromTwoStacks<String>();
    }

    @Test
    public void testQueue() throws Exception {

        assertEquals(0, queue.size);

        queue.enqueue("abc");
        queue.enqueue("def");
        queue.enqueue("ijk");

        assertEquals(3, queue.getSize());

        String removedItem = (String) queue.dequeue();
        assertEquals("abc", removedItem);

        assertEquals(2, queue.getSize());

        assertFalse(queue.getSize() == 0);

        removedItem =(String)  queue.dequeue();
        assertEquals("def", removedItem);

        removedItem = (String) queue.dequeue();
        assertEquals("ijk", removedItem);

        assertTrue(queue.getSize() == 0);

    }



}