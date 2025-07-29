import java.util.*;

public class LFU_Implementation {
    static class Node {
        int key;
        int val;
        int cnt;
        Node next;
        Node prev;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.cnt = 1;
        }
    }

    static class Pair<F, S> {
        F first;
        S second;

        Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }

   static class LFU_Cache {
        private Map<Integer, Node> cacheMap;
        private Map<Integer, Pair<Node, Node>> freqMap;
        private int capacity;
        private int minFreq;

        LFU_Cache(int capacity) {
            this.cacheMap = new HashMap<>();
            this.freqMap = new HashMap<>();
            this.capacity = capacity;
            minFreq = 0;

        }

        public void put(int key, int value) {
            if (capacity == 0) {
                return;

            }
            if (cacheMap.containsKey(key)) {
                Node node = cacheMap.get(key);
                node.val = value;
                updateFreq(node);

            } else {
                if (cacheMap.size() == capacity) {
                    Node node = freqMap.get(minFreq).second.prev;
                    cacheMap.remove(node.key);
                    remove(node);
                   if (freqMap.get(minFreq).first.next == freqMap.get(minFreq).second) {
                        freqMap.remove(minFreq);
                    }

                }
                Node node = new Node(key, value);
                cacheMap.put(key, node);
                minFreq = 1; 
                add(node, 1);
            }
        }

        public void updateFreq(Node node) {
            int oldFreq = node.cnt;
            node.cnt++;
            remove(node);
            if (freqMap.get(oldFreq).first.next == freqMap.get(oldFreq).second)
{
                freqMap.remove(oldFreq);
                if (minFreq == oldFreq) {
                    minFreq++;
                }
            }
            add(node, node.cnt);
        }

        public void remove(Node node) {
            Node delPrev = node.prev;
            Node delNext = node.next;
            delPrev.next = delNext;
            delNext.prev = delPrev;
        }

        public void add(Node node, int freq) {
            if (!freqMap.containsKey(freq)) {
                Node head = new Node(-1, -1);
                Node tail = new Node(-1, -1);
                head.next = tail;
                tail.prev = head;
                freqMap.put(freq, new Pair<>(head, tail));
            }
            Node head = freqMap.get(freq).first;
            Node temp = head.next;
            node.next = temp;
            node.prev = head;
            head.next = node;
            temp.prev = node;
        }

        public int get(int key) {
            if (!cacheMap.containsKey(key)) {
                return -1;

            }
            Node node = cacheMap.get(key);
            int res = node.val;
            updateFreq(node);
            return res;
        }
    }
    public static void main(String[] args) {
        LFU_Cache cache = new LFU_Cache(2);


        cache.put(1, 1);
        cache.put(2, 2);
        System.out.print(cache.get(1) + " ");
        cache.put(3, 3);
        System.out.print(cache.get(2) + " ");
        cache.put(4, 4);
        System.out.print(cache.get(3) + " ");
        System.out.print(cache.get(4) + " ");
        cache.put(5, 5);
    }
}
