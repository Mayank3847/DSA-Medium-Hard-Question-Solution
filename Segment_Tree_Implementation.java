public class Segment_Tree_Implementation {
    class Node {
        int sum;
        int start;
        int end;
        Node leftNode;
        Node rightNode;

        public Node(int sum, int start, int end, Node leftNode, Node rightNode) {
            this.sum = sum;
            this.start = start;
            this.end = end;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }
    }

   private Node root;

    public Segment_Tree_Implementation(int[] arr) {
        root = buildTree(arr, 0, arr.length - 1);
    }

    public Node buildTree(int[] arr, int start, int end) {
        if (start == end) {
            return new Node(arr[start], start, end, null, null);
        }
        int mid = start + (end - start) / 2;
        Node left = buildTree(arr, start, mid);
        Node right = buildTree(arr, mid + 1, end);
        return new Node(left.sum + right.sum, start, end, left, right);
    }

    public int queryRange(int left, int right) {
        return query(root, left, right);
    }

    public int query(Node node, int left, int right) {
        if (node.start > right || node.end < left) {
            return 0;
        }
        if (node.start >= left && node.end <= right) {
            return node.sum;
        }
        return query(node.leftNode, left, right) + query(node.rightNode, left, right);
    }

    public void updateQuery(int index, int value) {
        update(root, index, value);
    }

    public void update(Node node, int index, int value) {
        if (node.start == node.end) {
            node.sum = value;
            return;
        }
        int mid = node.start + (node.end - node.start) / 2;
        if (index <= mid) {
            update(node.leftNode, index, value);
        } else {
            update(node.rightNode, index, value);
        }
        node.sum = node.leftNode.sum + node.rightNode.sum;

    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 7, 9, 11 };
        Segment_Tree_Implementation st = new Segment_Tree_Implementation(arr);
        System.out.println(st.queryRange(1, 3));

        st.updateQuery(3, 10);
        System.out.println(st.queryRange(1, 3));

    }

}
