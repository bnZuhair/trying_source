package Java.uni.lab_Hw;

public class Lab1_thread {

    public static void main_2(String[] args) {
        int a1[] = { 1, 2, 3, 4, 5 }, a2[] = { 10, 9, 8, 7, 6 }, a3[] = {11, 12, 13, 14, 15};
        TabPrinter t1 = new TabPrinter(a1, "First thread");
        TabPrinter t2 = new TabPrinter(a2, "Second thread");
        TabPrinter t3 = new TabPrinter(a3, "Third thread");
        
        t1.start();
        t2.start();
        t3.start();
        
        System.out.println("Main has stopped");
    }
    public static void main(String[] args) {
         int a1[] = { 1, 2, 3, 4, 5 }, a2[] = { 10, 9, 8, 7, 6 }, a3[] = {11, 12, 13, 14, 15};
        TabPrinter_modified t1 = new TabPrinter_modified(a1, "First thread");
        TabPrinter_modified t2 = new TabPrinter_modified(a2, "Second thread");
        TabPrinter_modified t3 = new TabPrinter_modified(a3, "Third thread");
        
        t1.th.start();
        try{t1.th.join();}catch(InterruptedException ie){System.out.println("inturrpted");} 
        t2.th.start();
        try{t2.th.join();}catch(InterruptedException ie){System.out.println("inturrpted");} 
        t3.th.start();
        try{t3.th.join();}catch(InterruptedException ie){System.out.println("inturrpted");} 

        System.out.println("Main has stopped");
    }
}

class TabPrinter extends Thread {

    int a[];
    String threadName;

    TabPrinter(int a[], String threadName) {
        this.a = a;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        int count = 1;
        while (count <= 5) {
            for (int i = 0; i < a.length; i++) {
                System.out.print(a[i] + " ");
                try {
                    sleep(80);}catch(InterruptedException ie){ie.printStackTrace();};
            }
            System.out.println();
            count++;
        }
        System.out.println();
        System.out.println(threadName + " has stopped");
    }
}

class TabPrinter_modified implements Runnable{
        
        int a[];
        String threadName;
        Thread th;

        TabPrinter_modified(int a[], String threadName) {
            th = new Thread(this);
            this.a = a;
            this.threadName = threadName;
        }
    
        @Override
        public void run() {
            int count = 1;
            while (count <= 5) {
                for (int i = 0; i < a.length; i++) {
                    System.out.print(a[i] + " ");
                    try{th.sleep(80);}catch(InterruptedException ie){ie.printStackTrace();}
                }
            System.out.println();
            count++;
            }
            System.out.println();
            System.out.println(threadName + " has stopped\n");
        }
    }