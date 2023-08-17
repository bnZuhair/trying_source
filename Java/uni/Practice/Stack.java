public class Stack<dataType> {
    GenSLL<dataType> list;
    
    Stack(){
        list = new GenSLL<dataType>();
    }

    public void puch(dataType info) {
        list.addToHead(info);
    }
    public dataType pop() throws Exception{
        return (dataType) list.removeFromHead();
    }
    public boolean isEmpty() {
        return list.isEmpty();
    }
    public void clear(){
        list.clear();
    }
    public dataType getTop(){
        return (dataType) list.getHead().getInfo();
    }
    @Override
    public String toString(){
        return list.toString();
    }
}
