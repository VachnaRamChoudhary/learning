package dsa.src.main.java.com.vachna.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class CountDaysWithoutMeetings {
    /**
     * You are given a positive integer days representing the total number of days
     * an employee is available for work (starting from day 1). You are also given a 2D array
     * meetings of size n where, meetings[i] = [start_i, end_i] represents the starting and
     * ending days of meeting i (inclusive).
     *
     * Return the count of days when the employee is available for work but no meetings are scheduled.
     *
     * Note: The meetings may overlap.
     *
     *
     *
     * Example 1:
     *
     * Input: days = 10, meetings = [[5,7],[1,3],[9,10]]
     *
     * Output: 2
     *
     * Explanation:
     *
     * There is no meeting scheduled on the 4th and 8th days.
     *
     * Example 2:
     *
     * Input: days = 5, meetings = [[2,4],[1,3]]
     *
     * Output: 1
     *
     * Explanation:
     *
     * There is no meeting scheduled on the 5th day.
     *
     * Example 3:
     *
     * Input: days = 6, meetings = [[1,6]]
     *
     * https://leetcode.com/problems/count-days-without-meetings/description/?envType=daily-question&envId=2025-03-24
     */
    public CountDaysWithoutMeetings() {
        int[][] meetings = {{5,7},{1,3},{9,10}};
        System.out.println("Free days: " + countDays(10, meetings));
    }

    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(x -> x[0]));
        Set<Integer> meetingDays = new HashSet<>();

        int freeDays = 0;

        int prevEndDay = 0;
        for (int[] meeting : meetings) {
            int startDay = meeting[0], endDay = meeting[1];

            int dayDiff = startDay - prevEndDay - 1;
            if(dayDiff > 0){
                freeDays += dayDiff;
            }
            prevEndDay = Math.max(endDay, prevEndDay);
        }
        if((days - prevEndDay) > 0){
            freeDays += (days - prevEndDay);
        }
        return freeDays;
    }

    public static void main(String[] args) {
        new CountDaysWithoutMeetings();
    }
}
