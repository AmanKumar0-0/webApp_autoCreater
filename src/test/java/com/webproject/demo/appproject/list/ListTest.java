package com.webproject.demo.appproject.list;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {
    @Test
    void SimpleTest() {
        List listMock = mock(List.class);

        when(listMock.size()).thenReturn(3);

        assertEquals(3,listMock.size());
    }

    @Test
    void multipleReturns(){
        List listMock = mock(List.class);

        when(listMock.size()).thenReturn(1).thenReturn(2).thenReturn(3);

        assertEquals(1,listMock.size());
        assertEquals(2,listMock.size());
        assertEquals(3,listMock.size());
        assertEquals(3,listMock.size());
        assertEquals(3,listMock.size());
        // Remember the last value will be continuous now.
    }

    // For parameterized methods we can use .get() like this :->

    @Test
    void specificParameterisedMethodTest(){
        List listMock = mock(List.class);

        when(listMock.get(0)).thenReturn("Zero");
        when(listMock.get(1)).thenReturn("One");

        assertEquals("Zero",listMock.get(0));
        assertEquals("One",listMock.get(1));

    }

    // If the parameter is not specific its generic then
    // use Mockito.anyint() or simply Mockito.any___();

    @Test
    void genericParameterisedMethodTest(){
        List listMock = mock(List.class);

        when(listMock.get(Mockito.anyInt())).thenReturn("Integer");
        when(listMock.get(Mockito.anyChar())).thenReturn("Integer"); // It will further convert it into integer

        assertEquals("Integer",listMock.get(2));
        assertEquals("Integer",listMock.get('c'));
    }
}


