package com.webproject.demo.appproject.business;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
 class SomeBusinessImplMockAnnotationTest {

    @Mock
    private DataService dataServiceMock;

    @InjectMocks
    private SomeBusinessImpl someBusinessImpl;

    @Test
    void findTheGreatestFromAllData_basicScenario(){
        // In next line we are saying :->
        // when dataService.retrieveAllData() => new int[] {25, 15, 5} , so the syntax is
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {25, 15, 5});

        int result = someBusinessImpl.findTheGreatestFromAllData();
        assertEquals(25 , result);
    }

    @Test
    void findTheGreatestFromAllData_OneValueScenario(){

        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {21});
        int result = someBusinessImpl.findTheGreatestFromAllData();
        assertEquals(21, result);
    }

    @Test
    void findTheGreatestFromAllData_NullValue(){
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
        int result = someBusinessImpl.findTheGreatestFromAllData();
        assertEquals(Integer.MIN_VALUE, result);
    }
}
