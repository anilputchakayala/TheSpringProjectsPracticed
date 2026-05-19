package com.anil.mockito.mockito_demo.list;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {

    @Test
    void list_simpleTest(){
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(10);
        assertEquals(10, listMock.size());
    }

    @Test
    void list_MultipleReturns(){
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(10).thenReturn(5);
        assertEquals(10, listMock.size());
        assertEquals(5, listMock.size());
        assertEquals(5, listMock.size());
        assertEquals(5, listMock.size());
    }

    @Test
    void list_specificParameter(){
        List listMock = mock(List.class);
        when(listMock.get(1)).thenReturn("Some String");
        assertEquals("Some String", listMock.get(1));
    }

    @Test
    void list_genericParameters(){
        List listMock = mock(List.class);
        when(listMock.get(Mockito.anyInt())).thenReturn("Some Other String");
        assertEquals("Some Other String", listMock.get(1));
        assertEquals("Some Other String", listMock.get(0));
        assertEquals("Some Other String", listMock.get(99));
    }

}
