import java.util.*;

public class TopKMostFrequentElement {
    static class Element implements Comparable<Element> {
        int num;
        int freq;

        Element(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }

        @Override
        public int compareTo(Element other) {
            return this.freq - other.freq;
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Element> minHeap = new PriorityQueue<>();

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            minHeap.add(new Element(entry.getKey(), entry.getValue()));
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] result = new int[k];
        int i = k - 1;
        while (!minHeap.isEmpty()) {
            result[i--] = minHeap.poll().num;
        }

        return result;
    }

    public static int[] freqElem(int arr[], int k) {
        int n = arr.length;
        int maxValue = 1000;
        int freqArr[] = new int[maxValue + 1];
        for (int i = 0; i < n; i++) {
            freqArr[arr[i]]++;
        }

        int result[] = new int[k];
        for (int i = 0; i < k; i++) {
            int maxVal = -1;
            int idx = -1;
            for (int j = 0; j <= maxValue; j++) {
                if (freqArr[j] > maxVal) {
                    maxVal = freqArr[j];
                    idx = j;
                }

            }
            result[i] = idx;
            freqArr[idx] = -1;

        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 2, 2, 3 };
        int k = 2;

        int[] topK = freqElem(nums, k);
        for (int i = 0; i < topK.length; i++) {
            System.out.print(topK[i] + " ");
        }
        System.out.println();
        int[] topK1 = topKFrequent(nums, k);
        for (int i = 0; i < topK1.length; i++) {
            System.out.print(topK1[i] + " ");
        }
    }

}
