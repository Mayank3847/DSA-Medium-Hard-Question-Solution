public class Two_Pointers_Maximum_Points_Obtained_From_Cards {
    public static int maximumPointsBruteFore(int pointsCard[], int k) {
        int n = pointsCard.length;
        int maxScore = 0;
        for (int i = 0; i < k; i++) {
            int leftSum = 0;
            int rightSum = 0;
            for (int j = 0; j < i; j++) {
                leftSum += pointsCard[j];
            }
            for (int l = 0; l < k - i; l++) {
                rightSum += pointsCard[n - 1 - l];
            }
            maxScore = Math.max(maxScore, rightSum + leftSum);
        }
        return maxScore;
    }

    public static int maximumPointsOptimal(int pointsCard[], int k) {
        int n = pointsCard.length;
        int maxSum = 0, rightSum = 0, leftSum = 0;
        for (int i = 0; i < k; i++) {
            leftSum += pointsCard[i];
        }
        maxSum = leftSum; 
        int rightIdx = n - 1;
        for (int j = k - 1; j >= 0; j--) {
            leftSum -= pointsCard[j];
            rightSum += pointsCard[rightIdx];
            rightIdx--;
            maxSum = Math.max(maxSum, leftSum + rightSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int pointsCard[] = { 10, 1, 2, 3, 4, 5, 6, 1, 1, 10 };
        int k = 4;
        System.out.println(maximumPointsBruteFore(pointsCard, k));
        System.out.println(maximumPointsOptimal(pointsCard, k));

    }

}
