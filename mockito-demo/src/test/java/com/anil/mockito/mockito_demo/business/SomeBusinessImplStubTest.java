package com.anil.mockito.mockito_demo.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SomeBusinessImplStubTest {

    @Test
    void findGreatestFromData_basicScenario() {
        DataService dataServiceStub = new DataServiceStub1();
        SomeBusinessImpl someBusiness = new SomeBusinessImpl(dataServiceStub);
        int greatestNumber = someBusiness.findGreatestFromData();
        assertEquals(99, greatestNumber);
    }

    @Test
    void findGreatestFromData_withOneValue() {
        DataService dataServiceStub = new DataServiceStub2();
        SomeBusinessImpl someBusiness = new SomeBusinessImpl(dataServiceStub);
        int greatestNumber = someBusiness.findGreatestFromData();
        assertEquals(99, greatestNumber);
    }
}

class DataServiceStub1 implements DataService {

    @Override
    public int[] retrieveAllData() {
        return new int[] {99,88,77,66,55};
    }
}

class DataServiceStub2 implements DataService {

    @Override
    public int[] retrieveAllData() {
        return new int[] {99};
    }
}