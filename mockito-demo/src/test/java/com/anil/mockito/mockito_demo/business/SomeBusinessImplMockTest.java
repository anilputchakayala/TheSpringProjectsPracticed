package com.anil.mockito.mockito_demo.business;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SomeBusinessImplMockTest {

    @InjectMocks
    private SomeBusinessImpl someBusinessImpl;

    @Mock
    private DataService dataServiceMock;

    @Test
    void findGreatestFromData_basicScenario() {
        //DataService dataServiceMock = mock(DataService.class);
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{99,88,77,66,55});
        //SomeBusinessImpl someBusinessImpl = new SomeBusinessImpl(dataServiceMock);
        assertEquals(99, someBusinessImpl.findGreatestFromData());
    }

    @Test
    void findGreatestFromData_withOneValue() {
        //DataService dataServiceMock = mock(DataService.class);
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{1});
        //SomeBusinessImpl someBusinessImpl = new SomeBusinessImpl(dataServiceMock);
        assertEquals(1, someBusinessImpl.findGreatestFromData());
    }

    @Test
    void findGreatestFromData_withEmptyArray() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{});
        assertEquals(Integer.MIN_VALUE, someBusinessImpl.findGreatestFromData());
    }

}
