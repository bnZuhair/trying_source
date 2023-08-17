public class IntQueue {
    IntArLL list;
    
    IntQueue(){
        list = new IntArLL();
    }

    IntQueue(int capasity) {
        list = new IntArLL(capasity);
    }
    
    public void enqueue(int value) throws Exception {
        list.addToTail(value);
    }

    public int dequeue() throws Exception {
        return list.removeFromHead();
    }

    public int getFirst() {
        return getFirst();
    }
    @Override
    public String toString() {
        return list.toString();
    }
        
    
}
