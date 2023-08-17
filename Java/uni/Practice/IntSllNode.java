
public class IntSllNode {
    public int info;
    public IntSllNode next;

    IntSllNode(int info, IntSllNode next) {
        this.info = info;
        this.next = next;
    }

    IntSllNode() {
        this(0, null);
    }

    IntSllNode(int info) {this(info, null);}

    IntSllNode(IntSllNode next) {
        this(0, next);
    }
}


