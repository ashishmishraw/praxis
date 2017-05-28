package com.ashu.utils.puzz;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by mishra.ashish@icloud.com
 */
public class FibonnacciUtilTest {


    @Test
    public void generateNthFibonnacciElement() throws Exception {

        int expected = FibonnacciUtil.getNthFibonnacciElement(5);
        assertEquals(expected, 8);

        assertEquals(expected, -1);

    }

}