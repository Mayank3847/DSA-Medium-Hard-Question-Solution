class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;

    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList_Implementation {
    public static Node convertArr2LL(int arr[]) {
        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    public static Node insertAtBegining(Node head, int x) {

        Node newNode = new Node(x);
        newNode.next = head;
        return newNode;
    }

    public static Node insertAtEnd(Node head, int x) {
        if (head == null) {
            return new Node(x);
        }
        Node h = head;
        while (head.next != null) {
            head = head.next;
        }
        head.next = new Node(x);
        return h;

    }

    public static Node insertAtKthPosition(Node head, int el, int k) {
        if (head == null) {

            if (k == 1) {
                return new Node(el, head);
            } else {
                return head;
            }
        }
        if (k == 1) {
            return new Node(el, head);
        }

        int cnt = 0;
        Node temp = head;
        while (temp != null) {
            cnt++;
            if (cnt == (k - 1)) {
                Node newNode = new Node(el, temp.next);
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    public static void printLL(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static Node removeKthNode(Node head, int k) {
        if (head == null || head.next == null) {
            return null;
        }
        if (k == 1) {
            head = head.next;
            return head;

        }
        int cnt = 0;
        Node temp = head;
        Node prev = null;
        while (temp != null) {
            cnt++;
            if (cnt == k) {
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    public static Node insertBeforeVal(Node head, int el, int val) {
        if (head == null) {
            return null;
        }
        if (head.data == val) {
            return new Node(el, head);

        }
        Node temp = head;
        boolean found = false;
        while (temp.next != null) {

            if ((temp.next.data == val)) {
                Node newNode = new Node(el, temp.next);
                newNode.next = temp.next;
                temp.next = newNode;
                found = true;
                break;
            }
            temp = temp.next;
        }
        if (found == false) {
            System.out.println("Element " + el + " Not found");
        }
        return head;
    }

    public static Node deleteFirst(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        head = head.next;
        return head;
    }

    public static Node deleteLast(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    public static Node removeEl(Node head, int el) {
        if (head == null || head.next == null) {
            return null;
        }
        if (head.data == el) {
            Node temp = head;
            temp = temp.next;
            return head;
        }
        Node temp = head;
        Node prev = null;
        while (temp != null) {
            if (temp.data == el) {
                prev.next = prev.next.next;
                break;

            }
            prev = temp;
            temp = temp.next;

        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 40, 50 };
        int x = 100;
        int k = 4;
        int el = 40;
        int val = 30;

        Node head = convertArr2LL(arr);
        System.out.println("Original Linked List:");
        printLL(head);

        head = insertAtEnd(head, x);
        System.out.println("Linked List After Insertion At End:");
        printLL(head);

        head = insertAtBegining(head, x);
        System.out.println("Linked List After Insertion At Begining:");
        printLL(head);

        head = deleteFirst(head);
        System.out.println("Linked List After Deletion At Begining:");
        printLL(head);

        head = deleteLast(head);
        System.out.println("Linked List After Deletion At Last:");
        printLL(head);

        head = removeKthNode(head, k);
        System.out.println("Linked List After Deletion At Kth Position:");
        printLL(head);

        head = removeEl(head, el);
        System.out.println("Linked List After Deletion At given Element:");
        printLL(head);

        head = insertAtKthPosition(head, el, k);
        System.out.println("Linked List After Insertion At Kth Position:");
        printLL(head);

        head = insertBeforeVal(head, el, val);
        System.out.println("Linked List After Insertion Before Value:");
        printLL(head);
    }
}
