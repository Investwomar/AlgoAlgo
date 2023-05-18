import java.util.Arrays;

public class Test {

    private static final class Job implements Comparable<Job> {
        public final int start_time;
        public final int end_time;
        public final int profit;

        private Job(int start_time, int end_time, int profit) {
            this.start_time = start_time;
            this.end_time = end_time;
            this.profit = profit;
        }

        public int compareTo(Job o) {
            return this.end_time - o.end_time;
        }
    }

    public static void main(String[] args) {
        int[][] input = {{1, 6, 6}, {2, 5, 5}, {5, 7, 5}, {6, 8, 3}};

        Job[] jobs = new Job[input.length];

        for(int i = 0; i < jobs.length; i++) jobs[i] = new Job(input[i][0], input[i][1], input[i][2]);

        Arrays.sort(jobs);

        int maxEndTime = jobs[jobs.length - 1].end_time;
        int[] profitArray = new int[maxEndTime + 1];

        int maxProfit = 0;

        for (Job j : jobs) {
            int previousProfit = getPreviousProfit(profitArray, j.start_time);
            int currentProfit = Math.max(maxProfit, previousProfit + j.profit);
            profitArray[j.end_time] = currentProfit;
            maxProfit = Math.max(maxProfit, currentProfit);
        }

        System.out.println(maxProfit);
    }

    private static int getPreviousProfit(int[] profitArray, int time) {
        return time >= 0 && time < profitArray.length ? profitArray[time] : 0;
    }
}
