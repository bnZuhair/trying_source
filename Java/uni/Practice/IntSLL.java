public class IntSLL {
    public IntSllNode Head, Tail;
    public int size = 0, sum = 0;

    IntSLL(IntSllNode Head, IntSllNode Tail) {
        this.Head = Head;
        this.Tail = Tail;
    }

    IntSLL(IntSllNode Head) {
        this(Head, Head);
    }

    IntSLL() {
        this(null, null);
    }

    public void addToHead(int info) {
        if (Head == null) {
            Head = Tail = new IntSllNode(info, null);
        } else {
            Head = new IntSllNode(info, Head);
        }
        size++;
        sum += info;
    }

    public void removeFromHead() {
        if (Head == Tail) {
            Head = Tail = null;
            sum = 0;
            size = 0;
        } else {
            size--;
            sum -= Head.info;
            Head = Head.next;
        }
    }public void add(int index, int value){

        if (index > size)
            System.out.println("invalid index");
        else
        {
            IntSllNode temp = new IntSllNode();
            temp = Head;
            for (int i = 1; i < index  ; i++)
                temp = temp.next;

            temp.next = new IntSllNode(value, temp.next);
            size++;
            sum += value;
        }
    }

    public void addToTail(int info) {
        if (Tail == null) {
            Tail = Head = new IntSllNode(info, null);
        } else {
            Tail.next = new IntSllNode(info, null);
            Tail = Tail.next;
        }
        size++;
        sum += info;
    }

    public void removeFromTail() {
        if (Tail == Head) {
            Tail = Head = null;
            size = 0;
            sum = 0;
        } else {
            sum -= Tail.info;
            size--;
            IntSllNode temp = Head;
            while (temp.next != Tail)
                temp = temp.next;
            Tail = temp;
            Tail.next = null;
        }
    }

    public void print() {
        IntSllNode temp = Head;
        System.out.print("[ ");

        for (int i = 1; i <= size; i++) {
            if (temp == null)
                break;
            else if (i == 1)
                System.out.print(temp.info);
            else
                System.out.print(", " + temp.info);

            temp = temp.next;
        }
        System.out.print(" ]\n");

    }

    public void remove(int info) {
        for (IntSllNode temp = new IntSllNode(Head); temp != null; temp = temp.next)
            if (temp.info == info)
                removeFromHead();
            else if (temp.next != null) {
                if (temp.next.info == info) {
                    temp.next = temp.next.next;
                    System.out.println("the value was removed");
                    sum -= info;
                    size--;
                    return;
                }
            }

        System.out.println("the value was not found");
    }
    public void removeAt(int index){
        if (index > size )
            System.out.println("invalid index");
        else
        {
            IntSllNode temp = new IntSllNode(Head);
            for (int i = 0 ; i < index ; i++)
                temp = temp.next;

            temp.next = temp.next.next;
        }
    }
//    ideas for more methods in the data structure
//    toString
//    inverseList
//    isINList

}
