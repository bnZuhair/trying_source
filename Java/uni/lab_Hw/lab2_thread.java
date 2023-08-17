package Java.uni.lab_Hw;

public class lab2_thread {
    public static void main(String[] args) throws InterruptedException {
        
    TextThread t1 = new TextThread("first");
    TextThread t2 = new TextThread("Second");
    
    t1.start();
    t1.join();
    t2.start();
    
    System.out.println("main thread has stopped");
    }
    
    
}

class TextThread extends Thread {
    String threadText;

    TextThread(String text) {
        threadText = text;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(threadText);
            try{sleep(100);}catch(InterruptedException ie){ie.printStackTrace();}
        }
    }
}
