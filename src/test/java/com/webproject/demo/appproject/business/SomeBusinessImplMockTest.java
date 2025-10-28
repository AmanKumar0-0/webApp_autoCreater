package com.webproject.demo.appproject.business;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
 class SomeBusinessImplMockTest {
    @Test
    void findTheGreatestFromAllData_basicScenario(){
        DataService dataServiceMock = mock(DataService.class);

        // In next line we are saying :->
        // when dataService.retrieveAllData() => new int[] {25, 15, 5} , so the syntax is
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {25, 15, 5});

        SomeBusinessImpl someBusinessImpl = new SomeBusinessImpl(dataServiceMock);

        int result = someBusinessImpl.findTheGreatestFromAllData();
        assertEquals(25 , result);
    }

    @Test
    void findTheGreatestFromAllData_OneValueScenario(){
        DataService dataServiceMock = mock(DataService.class);

        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {21});

        SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);
        int result = businessImpl.findTheGreatestFromAllData();
        assertEquals(21, result);
    }
}
