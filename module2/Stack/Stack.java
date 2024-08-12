public class Stack<T> {
    private int size;   // the number of items in the stack
    private T[] items; // the array to store the items

    public Stack(int n) {
        size = 0;
        items = (T[]) new Object[n];
    }

    // get the number of items in the stack
    public int size() {
        return size;
    }

    // check if the stack is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // push an item to the stack
    public boolean push(T item) {
        if (size < items.length) { // check if the stack is full
            items[size] = item; // push the item to the stack
            size++; // increment the size
            return true;
        }
        return false;
    }

    // pop an item from the stack
    public T pop() {
        if (isEmpty()) { // check if the stack is empty
            return null;
        }
        return items[--size];
    }

    // peek the top item from the stack
    public T peek() {
        if (isEmpty()) { // check if the stack is empty
            return null;
        }
        return items[size - 1];
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>(4);
        stack.push("hello");
        stack.push("world");
        stack.push("from");
        stack.push("RMIT");
        stack.push("Pham Logan"); // this will return false since the stack is full
        while (!stack.isEmpty()) {
            System.out.println(stack.peek());
            stack.pop();
        }
    }
}
