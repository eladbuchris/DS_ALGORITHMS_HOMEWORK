public class Stack<T> {
    public LinkedList<T> L = new LinkedList<>();

    void push(T x){
        this.L.listInsert(x);
    }
    T pop(){
        if(this.L.head == null){
            return null;
        }
        Element<T> x = this.L.head;
        L.listDelete(x);
        return x.data;
    }
    T peek(){
        if(this.L.head == null){
            return null;
        }
        return this.L.head.data;
    }
    T getSecond(){
        if(this.L.head.next == null){
            return null;
        }
        return this.L.head.next.data;
    }
}
