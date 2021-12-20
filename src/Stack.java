public class Stack<T> {
    public LinkedList<T> L;

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
    Element<T> peek(){
        return this.L.head;
    }
}
