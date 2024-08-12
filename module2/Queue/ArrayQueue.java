public class ArrayQueue<T> {
    private int size, capacity, front, rear;
    private T[] items;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        items = (T[]) new Object[capacity];
        size = 0;
        front = 0;
        rear = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean enQueue(T item) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        items[rear] = item;
        rear = (rear + 1) % capacity;
        size++;
        return true;
    }

    public T deQueue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T item = items[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return items[front];
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<Integer>(10);
        // enqueue 1 to 9
        for (int i = 1; i <= 9; i++) {
            queue.enQueue(i);
        }
        // dequeue 5 times => should get 1 to 5
        for (int i = 0; i < 5; i++) {
            System.out.print(queue.peek() + " ");
            queue.deQueue();
        }
        // enqueue 1 to 5
        for (int i = 1; i <= 5; i++) {
            queue.enQueue(i);
        }

        System.out.println();
        System.out.println("---------");
        // dequeue until empty()
        // should get 6 to 9, then 1 to 5
        while (!queue.isEmpty()) {
            System.out.print(queue.deQueue() + " ");
        }
    }
}
