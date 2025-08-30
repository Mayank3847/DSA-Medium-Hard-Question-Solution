public class Greedy_Jump_Game_1 {
    public static boolean jumpGame(int arr[]) {
        int n = arr.length;
        int maxIdx = 0;
        for (int i = 0; i < n; i++) {
            if (i > maxIdx) {
                return false;

            }
            maxIdx = Math.max(maxIdx, i + arr[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 0, 1, 0, 4 };
        System.out.println(jumpGame(arr));
    }

}
