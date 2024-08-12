#include <iostream>
using namespace std;

template <typename T>
class Dequeue
{
private:
    T *items;
    int left;
    int right;
    int size;
    int capacity;

public:
    Dequeue(int capacity) : items(new T[capacity]),
                            left(0),
                            right(capacity - 1),
                            size(0),
                            capacity(capacity) {}

    ~Dequeue()
    {
        delete[] items;
    }

    bool isEmpty()
    {
        return size == 0;
    }

    bool isFull()
    {
        return size == capacity;
    }

    void enqueueLeft(T item)
    {
        if (isFull())
        {
            throw std::runtime_error("Dequeue is full");
        }
        items[left] = item;
        left = (left - 1 + capacity) % capacity;
        size++;
    }

    void enqueueRight(T item)
    {
        if (isFull())
        {
            throw std::runtime_error("Dequeue is full");
        }
        items[right] = item;
        right = (right + 1) % capacity;
        size++;
    }

    T dequeueLeft()
    {
        if (isEmpty())
        {
            throw std::runtime_error("Dequeue is empty");
        }
        T item = items[left];
        left = (left + 1) % capacity;
        size--;
        return item;
    }

    T dequeueRight()
    {
        if (isEmpty())
        {
            throw std::runtime_error("Dequeue is empty");
        }
        T item = items[right];
        right = (right - 1 + capacity) % capacity;
        size--;
        return item;
    }

    T peakLeft()
    {
        if (isEmpty())
        {
            throw std::runtime_error("Dequeue is empty");
        }
        return items[left];
    }

    T peakRight()
    {
        if (isEmpty())
        {
            throw std::runtime_error("Dequeue is empty");
        }
        return items[right];
    }
};

int main(int argc, char const *argv[])
{
    int capacity = 5;
    Dequeue<int> dequeue = Dequeue<int>(capacity);

    for (int i = 3; i <= 7; i++)
    {
        dequeue.enqueueRight(i);
    }

    // [7] [6] [5] [4] [3]
    // right is at index 4 after finish enqueueRight
    while (!dequeue.isEmpty())
    {
        cout << dequeue.dequeueRight() << " ";
    }
    return 0;
}
