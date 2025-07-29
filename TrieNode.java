public class TrieNode {
    public TrieNode[] children;
    public int wordCount;

    public TrieNode() {
        children = new TrieNode[26];
        wordCount = 0;
    }
}

class Trie_Implementation {
    public static void insert(TrieNode root, String key) {
        TrieNode currNode = root;
        for (int i = 0; i < key.length(); i++) {
            int idx = key.charAt(i) - 'a';
            if (currNode.children[idx] == null) {
                currNode.children[idx] = new TrieNode();
            }
            currNode = currNode.children[idx];
        }
        currNode.wordCount++;
    }

    public boolean isPrefixExist(TrieNode root, String key) {
        TrieNode currNode = root;
        for (char c : key.toCharArray()) {
            if (currNode.children[c - 'a'] == null) {
                return false;
            }
            currNode = currNode.children[c - 'a'];
        }
        return true;
    }
    

}
