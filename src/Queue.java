public class Queue<T> {

    private LinkedList<T> L;
    Element<T> tail;

    void enqueue(T x){
        Element<T> newElement = new Element<>(x);
        if(this.tail != null){
            L.listInsertAfter(newElement,this.tail);
        }
        else{
            L.listInsert(x);
        }
        this.tail = newElement;
    }
    Element<T> dequeue(){
        if(L.head == null){
            return null; // TODO: CHECK EXCEPTION
        }
        Element<T> x = this.L.head;
        L.listDelete(this.L.head);
        if(this.L.head == null){
            this.tail = null;
        }
        return x;
    }
}
