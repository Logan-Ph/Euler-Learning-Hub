#include <iostream>

using namespace std;

template <typename T>
class ArrayQueue
{
private:
    T *queue;
    int capacity;
    int size;
    int front;
    int rear;

public:
    ArrayQueue(int capacity) : capacity(capacity), size(0), front(0), rear(0)
    {
        queue = new T[capacity];
    }

    ~ArrayQueue()
    {
        delete[] queue;
    }

    bool isFull()
    {
        return size == capacity;
    }

    bool isEmpty()
    {
        return size == 0;
    }

    bool enQueue(T item)
    {
        if (isFull())
        {
            cout << "Queue is full" << endl;
            return false;
        }

        queue[rear] = item;
        rear = (rear + 1) % capacity;
        size++;

        return true;
    }

    T deQueue()
    {
        if (isEmpty())
        {
            cout << "Queue is empty" << endl;
            return false;
        }

        T item = queue[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    T peek()
    {
        if (isEmpty())
        {
            cout << "Queue is empty" << endl;
            return false;
        }
        return queue[front];
    }
};

int main(int argc, char const *argv[])
{
    ArrayQueue<int> queue(10);

    // enqueue 1 to 9
    for (int i = 1; i < 10; i++)
    {
        queue.enQueue(i);
    }

    // dequeue 5 times => should get 1 to 5
    for (int i = 0; i < 5; i++)
    {
        cout << queue.deQueue() << " ";
    }

    for (int i = 1; i < 6; i++)
    {
        queue.enQueue(i);
    }

    cout << endl;

    cout << "--------" << endl;

    while (!queue.isEmpty())
    {
        cout << queue.deQueue() << " ";
    }

    cout << endl;

    return 0;
}