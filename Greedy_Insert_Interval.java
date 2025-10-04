import java.util.ArrayList;
import java.util.List;

public class Greedy_Insert_Interval {

    public static int[][] insertIntervals(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int interval[] = intervals[i];
            if (interval[0] > newInterval[1]) {
                list.add(newInterval);
                newInterval = interval;
            } else if (interval[1] < newInterval[0]) {
                list.add(interval);
            } else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);

            }
        }
        list.add(newInterval);
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        int intervals[][] = { { 1, 3 }, { 6, 9 } };
        int newInterval[] = { 2, 5 };
        int ans[][] = insertIntervals(intervals, newInterval);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i][0] + " " + ans[i][1]);
        }
    }
}