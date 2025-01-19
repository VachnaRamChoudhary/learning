package com.vachna.greedy;

import java.util.*;

public class JobSequencingProblem {

    /**
     * You are given three arrays: id, deadline, and profit, where each job is associated with an ID,
     * a deadline, and a profit. Each job takes 1 unit of time to complete,
     * and only one job can be scheduled at a time.
     * You will earn the profit associated with a job only if it is completed by its deadline.
     *
     * Your task is to find:
     *
     * The maximum number of jobs that can be completed within their deadlines.
     * The total maximum profit earned by completing those jobs.
     *
     * https://www.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1
     */

    public JobSequencingProblem(){
        int[] id = {1, 2, 3, 4}, deadline = {4, 1, 1, 1}, profit = {20, 1, 40, 30};
        System.out.println(JobSequencing(id, deadline, profit));
    }

    public ArrayList<Integer> JobSequencing(int[] id, int[] deadline, int[] profit) {
        List<Data> jobs = sortJobsBasedOnProfit(id, deadline, profit);
        int n = id.length;
        Set<Integer> st = new HashSet<>(n+1);
        int totalProfit = 0, totalJobs = 0;
        for(Data d: jobs){
            if(!st.contains(d.deadLine)){
                st.add(d.deadLine);
                totalProfit += d.profit;
                totalJobs++;
            } else {
                int index = d.deadLine - 1;
                while(index > 0){
                    if(!st.contains(index)){
                        st.add(index);
                        totalProfit += d.profit;
                        totalJobs++;
                        break;
                    }
                    index--;
                }
            }
        }
        return new ArrayList<>(List.of(totalJobs, totalProfit));
    }

    private List<Data> sortJobsBasedOnProfit(int[] id, int[] deadline, int[] profit) {
        List<Data> jobs = new ArrayList<>();
        for(int i=0; i<id.length; i++){
            jobs.add(new Data(id[i], deadline[i], profit[i]));
        }
        jobs.sort(Comparator.comparing(Data::getProfit).reversed());
        return jobs;
    }

    public static class Data{
        int id;
        int deadLine;
        int profit;

        public Data(int id, int deadLine, int profit) {
            this.id = id;
            this.deadLine = deadLine;
            this.profit = profit;
        }

        public int getId() {
            return id;
        }

        public int getDeadLine() {
            return deadLine;
        }

        public int getProfit() {
            return profit;
        }
    }

    public static void main(String[] args) {
        new JobSequencingProblem();
    }
}
