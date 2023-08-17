public class GenSLLNode<dataType> {
    private dataType info;
    private GenSLLNode<dataType> next;

    GenSLLNode(){
        info = null; 
        next = null;
    }
    GenSLLNode(dataType info){
        this.info = info;
        next = null;
    }
    GenSLLNode(dataType info, GenSLLNode<dataType> next){
        this.info = info;
        this.next = next;
    }
    public dataType getInfo() {
        return info;
    }
    public GenSLLNode<dataType> getNext() {
        return next;
    }
    public void setInfo(dataType info) {
        this.info = info;
    }
    public void setNext(GenSLLNode<dataType> next) {
        this.next = next;
    }
}
