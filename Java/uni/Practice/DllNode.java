package MyDS;

public class DllNode<Type> {
    private Type info;
    private DllNode previous, next;

    DllNode(Type info, DllNode previous, DllNode next) {
        this.info = info;
        this.previous = previous;
        this.next = next;
    }
    DllNode(Type info, DllNode next){
        this(info, null, next);
    }
    DllNode() {
        this(null, null, null);
    }

    public Type getInfo() {
        return info;
    }

    public void setInfo(Type info) {
        this.info = info;
    }

    public DllNode getPrevious() {
        return previous;
    }

    public void setPrevious(DllNode previous) {
        this.previous = previous;
    }

    public DllNode getNext() {
        return next;
    }

    public void setNext(DllNode next) {
        this.next = next;
    }
}

