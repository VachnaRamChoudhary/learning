package com.vachna.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaxNoOfMeetingInARoom {

    /**
     * You are given timings of n meetings in the form of (start[i], end[i])
     * where start[i] is the start time of meeting i and end[i] is the finish time of meeting i.
     * Return the maximum number of meetings that can be accommodated in a single meeting room,
     * when only one meeting can be held in the meeting room at a particular time.
     *
     * Note: The start time of one chosen meeting can't be equal to the end time of the other chosen meeting.
     *
     * https://www.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1
     */

    private MaxNoOfMeetingInARoom(){
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};
        System.out.println(maxMeetings(start, end));
    }

    public int maxMeetings(int start[], int end[]) {
        List<Data> meetings = sortArrayBasedOnEndingTime(start, end);
        int ans = 0;
        Data prevMeet = null;
        for (Data m : meetings){
            if(prevMeet == null){
                ans = 1;
                prevMeet = m;
                continue;
            }
            if(prevMeet.getEnd() < m.start){
                ans+=1;
                prevMeet = m;
            }
        }
        return ans;

    }

    private List<Data> sortArrayBasedOnEndingTime(int[] start, int[] end) {
        List<Data> dataDtos = new ArrayList<>();
        for(int i = 0; i < start.length; i++ ){
            dataDtos.add(new Data(start[i], end[i], i));
        }
        dataDtos.sort(Comparator.comparing(Data::getEnd));
        return dataDtos;
    }

    public static class Data{
        int start;
        int end;
        int index;

        public Data(int i, int i1, int i2) {
            start = i;
            end = i1;
            index = i2;
        }
        public int getEnd(){
            return end;
        }
    }

//    public static void main(String[] args) {
//        new MaxNoOfMeetingInARoom();
//    }


}
