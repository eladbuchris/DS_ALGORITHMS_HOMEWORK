class Element<T> {
    T data;
    Element<T> next;
    Element<T> prev;
    Element(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class LinkedList<T> {

    Element<T> head;

    void listInsert(T x){
        /*
        Insert a node at the beginning of list
         */
        Element<T> newElement = new Element<>(x);
        newElement.next = this.head;
        if(this.head != null){
            this.head.prev = newElement;
        }
        this.head = newElement;
        newElement.prev = null;
    }
    void listInsertByElement(Element<T> x){
        /*
        Insert a node at the beginning of list
         */
        x.next = this.head;
        if(this.head != null){
            this.head.prev = x;
        }
        this.head = x;
        x.prev = null;
    }
    void listDelete(Element<T> x){
        if(x.prev != null){
            x.prev.next = x.next;
        }
        else{
            this.head = x.next;
        }
        if(x.next != null){
            x.next.prev= x.prev;
        }
    }
    void listInsertAfter(Element<T> x, Element<T> y){
        /*
        Insert x after y
         */
        if(y.next != null){
            y.next.prev = x;
        }
        x.next = y.next;
        x.prev = y;
        y.next = x;
    }
    void listInsertBefore(Element<T> x, Element<T> y){
        /*
        Insert x after y
         */
//        if(y.next != null){
//            y.next.prev = x;
//        }
        if(y.prev != null){
            y.prev.next = x;
            x.prev = y.prev;
        }
        y.prev = x;
        x.next = y;
    }
}
