package MyDS;

public class Stack {
    public char Top;
    public int Max;
    public int currSize;
    public char arr[];

    public Stack(int size) {
        Max = size;
        arr = new char[Max];
        currSize = -1 ;
    }

    public boolean isEmpty() {
        return currSize == -1;
    }

    public boolean isFull() {
        return currSize == Max;
    }

    public void puch(char value) throws Exception {
        if (isFull()) {
            throw new Exception("the stack is full");
        }
        else{

        arr[currSize] = value;
        Top = value;
        currSize++;
        }
    }

    public char pop() {
        char temp = Top;
        Top = arr[currSize - 1];
        currSize--;
        return temp;
    }

    public static void main(String[] args) {
        try {

            Stack mys = new Stack(5);
            mys.puch('H');
            mys.puch('E');
            mys.puch('L');
            mys.puch('P');

            for (int i = 0; i < mys.Max; i++)
                System.out.println(mys.pop());

            System.out.println(mys.isEmpty());
        }
        catch (Exception e ){

        }
    }
}
