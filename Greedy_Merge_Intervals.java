import java.util.*;

public class Greedy_Merge_Intervals {
    public static int[][] mergeInterval(int intervals[][]) {
        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int a[], int b[]) {
                return a[0] - b[0];
            }
        });

        List<int[]> merged = new ArrayList<>();
        int current[] = intervals[0];
        merged.add(current);
        for (int i = 0; i < intervals.length; i++) {
            int currentEnd = current[1];
            int nextSt = intervals[i][0];
            int nextEnd = intervals[i][1];
            if (currentEnd >= nextSt) {
                current[1] = Math.max(currentEnd, nextEnd);
            } else {
                current = intervals[i];
                merged.add(current);
            }
        }
        int result[][] = new int[merged.size()][2];
        for (int i = 0; i < merged.size(); i++) {
            result[i] = merged.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        int[][] result = mergeInterval(intervals);

        System.out.print("Merged intervals: ");
        for (int i = 0; i < result.length; i++) {
            System.out.print(Arrays.toString(result[i]) + " ");
        }
    }
}
