package labActivivty;

import java.security.SecureRandom;

class SllNode {
    public int info;
    public SllNode next;

    SllNode(int info, SllNode next) {
        this.info = info;
        this.next = next;
    }

    SllNode() {
        this(0, null);
    }

    SllNode(int info) {this(info, null);}

    SllNode(SllNode next) {
        this(0, next);
    }
}

class SLL {
    public SllNode Head, Tail;
    public int size = 0, sum = 0;

    SLL(SllNode Head, SllNode Tail) {
        this.Head = Head;
        this.Tail = Tail;
    }

    SLL(SllNode Head) {
        this(Head, Head);
    }

    SLL() {
        this(null, null);
    }

    public void addToHead(int info) {
        if (Head == null) {
            Head = Tail = new SllNode(info, null);
        } else {
            Head = new SllNode(info, Head);
        }
        size++;
        sum += info;
    }
    public void addToMid( int info){
        if ( size <= 1)
            addToHead(info);
        else
        {
            SllNode temp = new SllNode();
            temp = Head;
            for (int i = 1; i < size/2; i++)
                temp = temp.next;

            temp.next = new SllNode(info, temp.next);
            size++;
            sum += info;
        }
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
    }

    public void addToTail(int info) {
        if (Tail == null) {
            Tail = Head = new SllNode(info, null);
        } else {
            Tail.next = new SllNode(info, null);
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
            SllNode temp = Head;
            while (temp.next != Tail)
                temp = temp.next;
            Tail = temp;
            Tail.next = null;
        }
    }
    public void removeFromMid(){
        if ( size == 0 )
            System.out.println("not enough elements");
        else
        {
            SllNode temp = new SllNode();
            temp = Head;
            for (int i = 1 ; i < size /2  ; i++)
                temp = temp.next;

            temp.next = temp.next.next;
        }
    }

    public void print() {
        SllNode temp = Head;
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



}

public class Lab3ADS{
    public static void main(String[] args) {
        SecureRandom randomNums = new SecureRandom();

        SLL x = new SLL();


        System.out.println("add to tail");
        for (int i = 0; i < 5; i++)
            x.addToTail(randomNums.nextInt(11));
        x.print();


        System.out.println("add to head");
        for (int i = 0; i < 5; i++)
            x.addToHead(randomNums.nextInt(11));
        x.print();


        System.out.println("add to mid");
        for (int i = 0; i < 5; i++)
            x.addToMid(randomNums.nextInt(11));
        x.print();

        System.out.println("remove form head");
        x.removeFromHead();
        x.print();

        System.out.println("remove form tail");
        x.removeFromTail();
        x.print();


        System.out.println("removing the Middle value");
        x.removeFromMid();
        x.print();
    }
}

