public class Greedy_Jump_Game_II {
    public static int jumpGameII(int arr[]) {
        int currJmp = 0;
        int farthest = 0;
        int jump = 0;
        for (int i = 0; i < arr.length-1; i++) {
            farthest = Math.max(farthest, i + arr[i]);
            if (i == currJmp) {
                jump++;
                currJmp = farthest;
            }
        }
        return jump;
    }


}
