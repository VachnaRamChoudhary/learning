package com.vachna.greedy;

import java.util.Arrays;

public class MinimumNumberOfPlatform {

    /**
     * You are given the arrival times arr[] and departure times dep[]
     * of all trains that arrive at a railway station on the same day.
     * Your task is to determine the minimum number of platforms required at the
     * station to ensure that no train is kept waiting.
     *
     * At any given time, the same platform cannot be used for both the arrival
     * of one train and the departure of another. Therefore, when two trains arrive at the same time,
     * or when one arrives before another departs, additional platforms are required to accommodate both trains.
     * https://www.geeksforgeeks.org/problems/minimum-platforms-1587115620/1
     */

    public MinimumNumberOfPlatform(){
        int[] arr ={900,945,955,1100,1500,1800};
        int[] dep={920,1200,1130,1150,1900,2000};
        System.out.println(findPlatform(arr, dep));
    }

    static int findPlatform(int arr[], int dep[]) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int n = arr.length;

        int a = 0, d = 0, maxCount = 0, count = 0;

        while(a < n && d < n){
            if(arr[a] <= dep[d]){
                count++;
                a++;
            } else {
                count--;
                d++;
            }
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }

//    public static void main(String[] args) {
//        new MinimumNumberOfPlatform();
//    }
}
