import java.util.*;

public class Greedy_SJF {
    public static float sjf(int jobs[]) {
        Arrays.sort(jobs);
        float wtTime = 0;
        int totalTime = 0;
        int n = jobs.length;
        for (int i = 0; i < n; i++) {
            wtTime += totalTime;
            totalTime += jobs[i];

        }
        return wtTime / n;
    }

    public static void main(String[] args) {
        int jobs[] = { 3, 4, 7, 2, 1 };
        System.out.println(sjf(jobs));
    }

}
