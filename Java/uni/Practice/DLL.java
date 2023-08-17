package MyDS;

public class DLL<Type> {
    DllNode<Type> head, tail;

    DLL(DllNode head, DllNode tail){
        this.head = head;
        this.tail = tail;
    }
    DLL(DllNode head){
        this.head = this.tail = head;
    }
    DLL(){
       this(null, null);
    }
}
