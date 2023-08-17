public class IntArLL {
    private int size;
    private final int capasity, data[];

    public IntArLL() {
        this(10);
    }
    public IntArLL(int capasity) {
        this.capasity = capasity;
        data = new int[capasity];
        size = 0;
    }

    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }

    public int getCapasity() {
        return capasity;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capasity;
    }
    
    public void rightShift(int startingIndex) throws Exception{
        if(isFull())
            throw new Exception("we can't shift bucause it's full");
        
        for(int i = size; i >= startingIndex; i--)
            data[i] = data[i - 1]; 
    }

    public void leftShift(int endingIndex) throws Exception{
        if(isFull())
            throw new Exception("we can't shift because it's full");

        for (int i = 0; i <= endingIndex; i++)
            data[i] = data[i + 1];
    }
    
    public void addToHead(int value) throws Exception{
        if(isFull())
            throw new Exception("we can't add because it's full");
        else if(isEmpty())
            data[0] = value;
        else{
            rightShift(size);
            data[0] = value;
        }
        size++;
    }

    public void addToTail(int value) throws Exception {
        if (isFull())
            throw new Exception("we can't add because it's full");
        else
            data[size] = value;
        size++;
    }
    
    public void removeFromTail() throws Exception{
        if(isEmpty())
            throw new Exception("we can't remove because the data structre is empty");
        
        data[size] = 0;
        size--;

    }

    public int removeFromHead() throws Exception{
        int temp = data[0];
        if(isEmpty())
            throw new Exception("we can't remove because the data structre is empty");

        leftShift(size);
        size--;
        return temp;
    }

    public int getFirst() {
        return data[0];
    }

    public int getLast() {
        return data[size];
    }

     @Override
    public String toString(){
        String infoString = "[ ";
        if(isEmpty()){
            infoString += "Empty List ";

        }else{

        for(int i = 0; i < size ; i++){
            infoString += data[i];
            infoString += " ";
        }
        }
        infoString += "]";
        return infoString;
    }
}
