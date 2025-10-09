public class Capegemini_Pythagoras_Theorem {
    public static int squareDistance(int p1[], int p2[]) {
        int dx = p2[0] - p1[0];
        int dy = p2[1] - p1[1];
        int dz = p2[2] - p1[2];
        return dx * dx + dy * dy + dz * dz;

    }

    public static boolean isPythagorasTriplet(int points[][]) {
        int n = points.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int d1 = squareDistance(points[i], points[j]);// p1[]= { 0, 0, 0 }, p2[]= { 3, 0, 0 },
                    int d2 = squareDistance(points[i], points[k]);// p1[]= { 0, 0, 0 },p2[]= { 0, 4, 0 },
                    int d3 = squareDistance(points[j], points[k]);// p1[]= { 3, 0, 0 },p2[]= { 0, 4, 0 },
                    if (d1 + d2 == d3 || d1 + d3 == d2 || d2 + d3 == d1) {
                        System.out.println("Triplet found: " +
                                "Point " + i + ", Point " + j + ", Point " + k);
                        return true;
                    }

                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] points = {
                { 0, 0, 0 },
                { 3, 0, 0 },
                { 0, 4, 0 },
                { 1, 1, 1 }
        };
        System.out.println(isPythagorasTriplet(points));
    }
}
