
import java.util.*;

public class Greedy_Job_Scheduling {
    static class Job {
        int id;
        int deadline;
        int profit;

        public Job(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static void jobScheduling(Job[] jobs, int n) {
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);
        int maxDeadLine = 0;
        for (int i = 0; i < jobs.length; i++) {
            maxDeadLine = Math.max(maxDeadLine, jobs[i].deadline);
        }
        int slot[] = new int[maxDeadLine + 1];
        Arrays.fill(slot, -1);
        int countJob = 0, totalProfit = 0;
        for (int i = 0; i < jobs.length; i++) {
            for (int j = jobs[i].deadline; j > 0; j--) {
                if (slot[j] == -1) {
                    slot[j] = jobs[i].id;
                    countJob++;
                    totalProfit += jobs[i].profit;
                    break;
                }
            }
        }
        System.out.println("Number of jobs done: " + countJob);
        System.out.println("Maximum profit: " + totalProfit);
    }

    public static void main(String[] args) {
        Job[] jobs = {
                new Job(1, 4, 20),
                new Job(2, 1, 10),
                new Job(3, 1, 40),
                new Job(4, 1, 30)
        };

        int n = jobs.length;
        jobScheduling(jobs, n);
    }
}
