public class LongestRepeatingCharacterReplacement {
    public static int longestCharacterReplacementBruteForce(String s, int k) {
        int maxLen = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int arr[] = new int[26];
            int maxFreq = 0;
            for (int j = i; j < n; j++) {
                int index = s.charAt(j) - 'A';
                arr[index]++;
                maxFreq = Math.max(maxFreq, arr[index]);
                int changesNeeded = (j - i + 1) - maxFreq;
                if (changesNeeded <= k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                } else {
                    break;
                }
            }

        }
        return maxLen;
    }

    public static int longestCharacterReplacementOptimal(String s, int k) {
        int maxFreq = 0;
        int maxLen = 0;
        int left = 0;
        int freq[] = new int[26];

        for (int right = 0; right < s.length(); right++) {
            int idx = s.charAt(right) - 'A';
            freq[idx]++;
            maxFreq = Math.max(maxFreq, freq[idx]);
            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;

            }
            maxLen = Math.max(right - left + 1, maxLen);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "AABABC";
        int k = 2;
        System.out.println(longestCharacterReplacementBruteForce(s, k));
        System.out.println(longestCharacterReplacementOptimal(s, k));

    }

}
