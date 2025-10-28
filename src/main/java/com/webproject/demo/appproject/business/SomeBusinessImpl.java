package com.webproject.demo.appproject.business;

class SomeBusinessImpl {
    private DataService dataService;

    // Creating Constructor Injection for protection against dependency of
    // DataService interface from class SomeBusinessImpl

    public SomeBusinessImpl(DataService dataService){
        super();
        this.dataService = dataService;
    }

    public int findTheGreatestFromAllData(){
        int[] datas = dataService.retrieveAllData();
        int greatestValue = Integer.MIN_VALUE;
        for (int value:datas){
            if (value > greatestValue){
                greatestValue = value;
            }
        }
        return greatestValue;
    }
}

interface DataService {
    int[] retrieveAllData();
}
