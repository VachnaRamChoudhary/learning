package com.vachna.greedy;

import com.vachna.utill.HelperUtil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FractionalKnapsack {
    /**
     * Given two arrays, val[] and wt[], representing the values and weights of items,
     * and an integer capacity representing the maximum weight a knapsack can hold,
     * determine the maximum total value that can be achieved by putting items in the knapsack.
     * You are allowed to break items into fractions if necessary.
     * Return the maximum value as a double, rounded to 6 decimal places.
     * https://www.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1
     */

    private FractionalKnapsack(){
        List<Integer> val = List.of(60, 100, 120), wt = List.of(10, 20, 30);
        int capacity = 50;
        System.out.println(fractionalKnapsack(val, wt, capacity));
    }
    double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
        List<Data> dataDtos =  getSortedDataBasedOnPerUnitValue(val, wt, capacity);
        int w = 0;
        double maxVal = 0.000000;

        for(Data d : dataDtos){
            if(w + d.wt <= capacity){
                w += d.wt;
                maxVal += d.val;
            } else if(w < capacity){
                int remCap = capacity - w;
                maxVal += remCap*( ((double) d.getVal()/ d.getWt()));
                w += remCap;
            }else {
                break;
            }
        }

        return maxVal;
    }

    private List<Data> getSortedDataBasedOnPerUnitValue(List<Integer> val, List<Integer> wt, int capacity) {
        List<Data> list = new ArrayList<>();
        for(int i = 0; i < val.size(); i++ ){
            list.add(new Data(val.get(i), wt.get(i)));
        }
        list.sort((item1, item2) -> {
            double ratio1 = (double) item1.getVal() / item1.getWt();
            double ratio2 = (double) item2.getVal() / item2.getWt();

//            // Round to 6 decimal places
//            ratio1 = Math.round(ratio1 * 1_000_000) / 1_000_000.0;
//            ratio2 = Math.round(ratio2 * 1_000_000) / 1_000_000.0;

            return Double.compare(ratio2, ratio1); // Reverse order (descending)
        });
        return list;
    }

    public static class Data{
        Integer val;
        Integer wt;

        public Data(Integer val, Integer wt) {
            this.val = val;
            this.wt = wt;
        }

        public Integer getVal() {
            return val;
        }

        public Integer getWt() {
            return wt;
        }
        @Override
        public String toString() {
            return "Data{val=" + val + ", wt='" + wt + "'}";
        }
    }

    public static void main(String[] args) {
        new FractionalKnapsack();
    }
}
