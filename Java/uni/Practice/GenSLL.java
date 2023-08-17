public class GenSLL<dataType> {
    private GenSLLNode<dataType> head, tail;
    private int size;
    
    GenSLL(){
        head = tail = new GenSLLNode<dataType>(null);
        size = 0;
    }
   /* GenSLL(GenSLLNode<dataType> head){
        head = tail = new GenSLLNode<dataType>((dataType) head.getInfo(), head.getNext());
    }
    GenSLL(GenSLLNode<dataType> head, GenSLLNode<dataType> tail){
        this.head = new GenSLLNode<dataType>((dataType) tail.getInfo(), tail.getNext());
        this.tail = new GenSLLNode<dataType>((dataType) tail.getInfo(), tail.getNext());
    }*/
    public void setHead(GenSLLNode<dataType> head) {
        this.head = head;
    }
    public void setTail(GenSLLNode<dataType> tail) {
        this.tail = tail;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public GenSLLNode<dataType> getHead() {
        return head;
    }
    public int getSize() {
        return size;
    }
    public GenSLLNode<dataType> getTail() {
        return tail;
    }
    public void addToHead(dataType info) {
        if (isEmpty()){
           head = tail = new GenSLLNode<dataType>(info, null) ;
        }
        else {
            GenSLLNode<dataType> temp = new GenSLLNode<dataType>(info, head);
            head = temp;
        }
        size++;
    }
    public void removeHead () throws Exception{
        if (isEmpty()){
            throw new Exception("the data structer is empty");
        }

        head = head.getNext();
        size--;
    }
    public dataType removeFromHead () throws Exception{
        if (isEmpty())
            throw new Exception("the data structer is empty");
        
        dataType info = (dataType) head.getInfo();
        head = head.getNext();
        size--;

        return info;
        
    }
    public void removeTail() throws Exception{
        if (isEmpty()){
            throw new Exception("the data structer is empty");
        }
            GenSLLNode<dataType> temp = head;
            for(int i = 0 ; i < size ; i++)
                if (temp.getNext() == tail)
                    break;

        tail = temp;
        tail.setNext(null);
        size--;
    }
    public dataType removeFromTail() throws Exception{
        if (isEmpty())
            throw new Exception("the data structer is empty");
        
        dataType info = (dataType) tail.getInfo();
            GenSLLNode<dataType> temp = head;
            for(int i = 0 ; i < size ; i++)
                if (temp.getNext() == tail)
                    break;
        tail = temp;
        tail.setNext(null);
        size--;
        return info;
    }
    public void addToTail(dataType info) {
        if (isEmpty()){
           head = tail = new GenSLLNode<dataType>(info, null) ;
        } else {
            GenSLLNode<dataType> temp = new GenSLLNode<dataType>(info);
            tail.setNext(temp);
            tail = temp;
        }
        size++;
    }
    public boolean isEmpty(){
        return head == null || tail == null || size == 0;
    }
    public void clear(){
        head = tail = null;
        size = 0;
    }
    
    @Override
    public String toString(){
        String infoString = "[ ";
        if(isEmpty()){
            infoString += "Empty List ";

        }else{

        GenSLLNode<dataType> temp = new GenSLLNode<dataType>();
        temp = head;
        for(int i = 0; i < size ; i++){
            infoString += temp.getInfo();
            infoString += " ";
            temp = temp.getNext();
        }
        }
        infoString += "]";
        return infoString;
    }
}