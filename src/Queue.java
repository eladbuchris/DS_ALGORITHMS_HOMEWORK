//public class Queue<T> {
//
//    private LinkedList<T> L = new LinkedList<>();
//    Element<T> tail = L.head;
//
//    void enqueue(T x){
//        Element<T> newElement = new Element<>(x);
//        if(this.tail != null){
//            L.listInsertAfter(newElement,this.tail);
//        }
//        else{
//            L.listInsert(this.tail);
//            L.listInsert(x);
//        }
//        this.tail = newElement;
//    }
//    T dequeue(){
//        if(this.tail == null){
//            return null;
//        }
//        T x = this.L.head.data;
//        L.listDelete(this.L.head);
//        if(this.L.head == null){
//            this.tail = null;
//        }
//        return x;
//    }
//}
// Java program for linked-list implementation of queue

// A linked list (LL) node to store a queue entry
class QNode<T> {
    T key;
    QNode<T> next;

    // constructor to create a new linked list node
    public QNode(T key)
    {
        this.key = key;
        this.next = null;
    }
}

// A class to represent a queue
// The queue, front stores the front node of LL and rear stores the
// last node of LL
class Queue<T> {
    QNode<T> front, rear;
    public Queue()
    {
        this.front = this.rear = null;
    }

    // Method to add an key to the queue.
    void enqueue(T key)
    {
        // Create a new LL node
        QNode<T> temp = new QNode(key);

        // If queue is empty, then new node is front and rear both
        if (this.rear == null) {
            this.front = this.rear = temp;
            return;
        }
        // Add the new node at the end of queue and change rear
        this.rear.next = temp;
        this.rear = temp;
    }

    // Method to remove an key from queue.
    T dequeue()
    {
        // If queue is empty, return NULL.
        if (this.front == null)
            return null;

        // Store previous front and move front one node ahead
        QNode<T> temp = this.front;
        this.front = this.front.next;

        // If front becomes NULL, then change rear also as NULL
        if (this.front == null)
            this.rear = null;
        return temp.key;
    }
}

