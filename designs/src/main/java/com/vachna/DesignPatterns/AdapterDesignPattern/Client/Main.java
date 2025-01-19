package com.vachna.DesignPatterns.AdapterDesignPattern.Client;


import com.vachna.DesignPatterns.AdapterDesignPattern.Adaptee.WeightMachineForBabies;
import com.vachna.DesignPatterns.AdapterDesignPattern.Adapter.WeightMachineAdapterImpl;

public class Main {

    public static void main(String[] args){

        com.vachna.DesignPatterns.AdapterDesignPattern.Adapter.WeightMachineAdapter weightMachineAdapter = new WeightMachineAdapterImpl(new WeightMachineForBabies());
        System.out.println(weightMachineAdapter.getWeightInKg());
    }
}
