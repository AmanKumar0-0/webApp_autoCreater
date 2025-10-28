package com.webproject.demo.appproject.business;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SomeBusinessImplTest {

    @Test
    void findTheGreatestFromAllData_basicScenario() {
        DataServiceStub dataServiceStub = new DataServiceStub();
        SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceStub);
        int result = businessImpl.findTheGreatestFromAllData();
        assertEquals(25, result);
    }

    @Test
    void findTheGreatestFromAllData_basicScenario2(){

        DataServiceStub2 dataServiceStub2 = new DataServiceStub2();
        SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceStub2);
        int result = businessImpl.findTheGreatestFromAllData();
        assertEquals(122, result);
    }

    @Test
    void findTheGreatestFromAllData_basicScenario_Zero(){

        DataServiceStubZero dataServiceStubZero = new DataServiceStubZero();
        SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceStubZero);
        int result = businessImpl.findTheGreatestFromAllData();
        assertEquals(0, result);
    }
}

class DataServiceStub implements DataService {
    @Override
    public int[] retrieveAllData(){
        return new int []{25, 15, 5};
    }
}

class DataServiceStub2 implements DataService{
    @Override
    public int[] retrieveAllData(){
        return new int[] {21,122,43};
    }
}

class DataServiceStubZero implements DataService{
    @Override
    public int[] retrieveAllData(){
        return new int[] {0};
    }
}
