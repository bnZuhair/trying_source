public class Queue<dataType>{
    GenSLL<dataType> list;
    Queue(){
        list = new GenSLL<dataType>();
    }
    public void inQueue(dataType info) {
        list.addToTail(info);
    }
    public dataType deQueue() throws Exception {
        dataType info = (dataType) list.removeFromHead();
        return info;
    }
    public boolean isEmpty() {
       return list.isEmpty();
    }
    @Override
    public String toString(){
        return list.toString();
    }
    
}