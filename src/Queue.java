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
        /*
            Constructor to initialize frontand rear.
         */
        this.front = this.rear = null;
    }

    void enqueue(T key)
    {
        /*
            Adding a new node to the queue at the end
         */
        QNode<T> temp = new QNode(key);

        if (this.rear == null) {
            this.front = this.rear = temp;
            return;
        }
        this.rear.next = temp;
        this.rear = temp;
    }

    T dequeue()
    {
        /*
            Remove the front of the queue
         */
        if (this.front == null)
            return null;

        QNode<T> temp = this.front;
        this.front = this.front.next;

        if (this.front == null)
            this.rear = null;
        return temp.key;
    }
}

