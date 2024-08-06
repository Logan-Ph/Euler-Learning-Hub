#include <iostream>
using namespace std;

template <typename T>
class Stack
{
private:
    int size;
    int top;
    T *items;

public:
    Stack(int n)
    {
        size = n;
        top = -1;
        items = new T[n];
    };

    ~Stack()
    {
        delete[] items;
    };

    int getSize()
    {
        return top + 1;
    };

    bool isEmpty()
    {
        return top == -1;
    };

    bool push(T item)
    {
        if (top == size - 1)
            return false;
        items[++top] = item;
        return true;
    };

    T pop()
    {
        if (isEmpty())
            return -1;
        return items[top--];
    };

    T peek()
    {
        if (isEmpty())
            return -1;
        return items[top];
    };
};

int main(int argc, char const *argv[])
{
    Stack<int> stack(4);
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    cout << stack.pop() << endl;
    return 0;
}