package module2.Dequeue;
public class Dequeue<T> {
    private int size, left, right, capacity;
    private T[] items;

    public Dequeue(int capacity) {
        items = (T[]) new Object[capacity];
        this.capacity = capacity;
        this.size = 0;
        this.left = 0;
        this.right = capacity - 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void enqueueLeft(T item) {
        if (isFull()) {
            throw new RuntimeException("Dequeue is full");
        }
        items[left] = item;
        left = (left - 1 + capacity) % capacity;
        size++;
    }

    public void enqueueRight(T item) {
        if (isFull()) {
            throw new RuntimeException("Dequeue is full");
        }
        items[right] = item;

        // plus capacity to avoid negative index
        right = (right + 1) % capacity;
        size++;
    }

    public T dequeueLeft() {
        if (isEmpty()) {
            throw new RuntimeException("Dequeue is empty");
        }
        T item = items[left];
        left = (left + 1) % capacity;
        size--;
        return item;
    }

    public T dequeueRight() {
        if (isEmpty()) {
            throw new RuntimeException("Dequeue is empty");
        }
        T item = items[right];
        right = (right - 1 + capacity) % capacity;
        size--;
        return item;
    }

    public T peakLeft() {
        if (isEmpty()) {
            throw new RuntimeException("Dequeue is empty");
        }
        return items[left];
    }

    public T peakRight() {
        if (isEmpty()) {
            throw new RuntimeException("Dequeue is empty");
        }
        return items[right];
    }

    public static void main(String[] args) {
        int capacity = 5;
        Dequeue<Integer> dequeue = new Dequeue<>(capacity);
        
        for (int i = 3; i <= 7; i++) {
            dequeue.enqueueRight(i);
        }

        // [7] [6] [5] [4] [3]
        // right is at index 4 after finish enqueueRight
        
        while (!dequeue.isEmpty()) {
            System.out.print(dequeue.dequeueRight() + " ");
        }
    }
}
