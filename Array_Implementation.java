public class Array_Implementation {
    private int arr[];
    private int size;
    private int capacity;

    public Array_Implementation(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        this.size = 0;
    }

    public void insert(int element) {
        if (size >= capacity) {
            System.out.println("Array is full . Cant Insert!");

        }
        arr[size++] = element;
    }
}
