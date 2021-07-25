package com.tl.main;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MockTest {

    @Test
    public void test(){

        Bussiness obj=mock(Bussiness.class);//①

        when(obj.hello("z4")).thenReturn("hello l4");//②

        String actual=obj.hello("z3");//③
        assertEquals("hello l4",actual);

        verify(obj).hello("z3");//④
        //verify(obj,times(1)).hello("z3"); //可以加参数验证次数
    }
}
