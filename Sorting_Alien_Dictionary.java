import java.util.*;

public class Sorting_Alien_Dictionary {
    public static String alienDictionary(String[] words) {
        // Step 1: Create graph and in-degree map

        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        // Initialize all characters

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                char ch = word.charAt(j);
                if (!graph.containsKey(ch)) {
                    graph.put(ch, new ArrayList<>());
                }
                if (!indegree.containsKey(ch)) {
                    indegree.put(ch, 0);
                }

            }
        }
        // Step 2: Build graph based on the first different character
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            boolean foundDifference = false;
            int minLength = Math.min(word1.length(), word2.length());

            for (int j = 0; j < minLength; j++) {
                char ch1 = word1.charAt(j);
                char ch2 = word2.charAt(j);
                if (ch1 != ch2) {
                    graph.get(ch1).add(ch2);
                    indegree.put(ch2, indegree.get(ch2) + 1);
                    foundDifference = true;
                    break;
                }
            }
            // Invalid case like ["abc", "ab"]
            if (!foundDifference && word1.length() > word2.length()) {
                return "";
            }
        }
        Queue<Character> qu = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        List<Character> keys = new ArrayList<>(indegree.keySet());
        for (int i = 0; i < keys.size(); i++) {
            char ch = keys.get(i);
            if (indegree.get(ch) == 0) {
                qu.add(ch);
            }
        }

        while (!qu.isEmpty()) {
            char curr = qu.poll();
            sb.append(curr);

            List<Character> neighbours = graph.get(curr);
            // b->[a,d]
            for (int i = 0; i < neighbours.size(); i++) {
                char neigh = neighbours.get(i);
                indegree.put(neigh, indegree.get(neigh) - 1);
                if (indegree.get(neigh) == 0) {
                    qu.add(neigh);
                }
            }
        }
        if (sb.length() != indegree.size()) {
            return "";

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] words1 = { "baa", "abcd", "abca", "cab", "cad" };
        String[] words2 = { "caa", "aaa", "aab" };
        System.out.println(alienDictionary(words2));
        System.out.println(alienDictionary(words1));

    }

}
