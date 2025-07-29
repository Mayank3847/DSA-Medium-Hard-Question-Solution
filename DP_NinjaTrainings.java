public class DP_NinjaTrainings {
    public static int ninjaTrainingRecurssion(int n, int points[][]) {

        return securePoints(n - 1, 3, points);
    }

    public static int securePoints(int day, int last, int points[][]) {
        if (day == 0) {
            int maxi = 0;
            for (int i = 0; i < points.length; i++) {
                if (i != last) {
                    maxi = Math.max(maxi, points[0][i]);
                }
            }
            return maxi;
        }
        int maxPoints = 0;
        for (int i = 0; i < 3; i++) {
            if (i != last) {
                int pt = points[day][i] + securePoints(day - 1, i, points);
                maxPoints = Math.max(maxPoints, pt);
            }

        }
        return maxPoints;
    }

    // MEMOIZATION
    public static int ninjaTrainingMemo(int n, int points[][]) {
        int dp[][] = new int[n][4];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return securePointsMemo(n - 1, 3, points, dp);
    }

    public static int securePointsMemo(int days, int last, int points[][], int dp[][]) {
        if (dp[days][last] != -1) {
            return dp[days][last];
        }
        if (days == 0) {
            int maxi = 0;
            for (int i = 0; i < points.length; i++) {
                if (i != last) {
                    maxi = Math.max(maxi, points[0][i]);
                }
            }
            return maxi;
        }
        int maxPoints = 0;
        for (int i = 0; i < 3; i++) {
            if (i != last) {
                int pt = points[days][i] + securePointsMemo(days - 1, i, points, dp);
                maxPoints = Math.max(maxPoints, pt);
            }

        }
        return dp[days][last] = maxPoints;
    }

    public static int ninjaTrainingTab(int n, int point[][]) {
        int dp[][] = new int[n][4];
        for (int i = 0; i < 4; i++) {
            int max = 0;
            for (int j = 0; j < 3; j++) {
                if (i != j) {
                    max = Math.max(max, point[0][j]);
                }
            }
            dp[0][i] = max;
        }
        for (int days = 1; days < n; days++) {
            for (int last = 0; last < 4; last++) {
                int maxPoint = 0;
                for (int task = 0; task < 3; task++) {
                    if (last != task) {
                        int pt = point[days][task] + dp[days - 1][task];
                        maxPoint = Math.max(maxPoint, pt);
                    }
                }
                dp[days][last] = maxPoint;
            }

        }
        return dp[n - 1][3];
    }

    // Space Optimization
    public static int ninjaTrainingMemoSpaceOpti(int n, int points[][]) {
        int prev[] = new int[4];
        for (int i = 0; i < 4; i++) {
            int max = 0;
            for (int j = 0; j < 3; j++) {
                if (i != j) {

                    max = Math.max(max, points[0][j]);
                }

            }
            prev[i] = max;
        }
        for (int days = 1; days < n; days++) {
            int curr[] = new int[4];
            for (int last = 0; last < 4; last++) {
                int maxPoints = 0;
                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        int point = points[days][task] + prev[task];
                        maxPoints = Math.max(maxPoints, point);
                    }
                }
                curr[last] = maxPoints;

            }
            prev = curr;
        }
        return prev[3];

    }

    public static void main(String[] args) {
        int[][] points = {
                { 10, 40, 70 },
                { 20, 50, 80 },
                { 30, 60, 90 }
        };
        int n = points.length;
        System.out.println(ninjaTrainingRecurssion(n, points));
        System.out.println(ninjaTrainingMemo(n, points));
        System.out.println(ninjaTrainingTab(n, points));
        System.out.println(ninjaTrainingMemoSpaceOpti(n, points));
    }
}
