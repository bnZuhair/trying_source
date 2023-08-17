package Java.uni.lab_Hw;

public class lab3_thread {
    
    public static void main(String[] args) {
        double ar[] = {0, 0, 0, 0, 0};
        Table myTable = new Table(ar);
        depositThread th1 = new depositThread(myTable, "first increament thread");
        removeThread th2 = new removeThread(myTable, "first decreamnent thread");
        removeThread th3 = new removeThread(myTable, "second decreamnent thread");

        
        for (int i = 0; i < 5; i++) {
            th1.start();
            th2.start();
            th3.start();
            try {
                th1.join();
                th2.join();
                th3.join();
            } catch (InterruptedException e) {
                System.out.println("the thread was interpted");
            }
        }
        myTable.displayTab();

    }

}

class Table {
    private double tab[];

    public Table(double tab[]) {
        this.tab = tab;
    }

    public void incTab() {
        for (int i = 0; i < tab.length; i++) 
            tab[i]++;
    }
    public void decTab() {
        for (int i = 0; i < tab.length; i++) 
            tab[i]--;
    }

    public void displayTab() {
        for (int j = 0; j < tab.length; j++) {
            System.out.print( tab[j] +" ");
        }
    }
}

class depositThread extends Thread {
    Table t;
    String name;

    depositThread(Table t, String name) {
        this.t = t;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println( name + "is increamingting the array");
        t.incTab();
    }
}

class removeThread extends Thread {
    Table t;
    String name;

    removeThread(Table t, String name) {
        this.t = t;
        this.name = name;
    }
    @Override
    public void run() {
        System.out.println( name +" is decreaminting the array");
        t.decTab();
    }
}
