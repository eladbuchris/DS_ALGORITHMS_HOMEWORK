public class Stack<T> {
    public LinkedList<T> L = new LinkedList<>();

    void push(T x){
        /*
        Add an element at the front of the stack.
         */
        this.L.listInsert(x);
    }
    T pop(){
        /*
        Remove the last element from the stack and return it.
         */
        if(this.L.head == null){
            return null;
        }
        Element<T> x = this.L.head;
        L.listDelete(x);
        return x.data;
    }
    T peek(){
        /*
        returns the last element from the stack.
         */
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
