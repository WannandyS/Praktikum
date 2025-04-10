class PrintNameThread2 implements Runnable {
    Thread thread;
    PrintNameThread2(String name) {
        thread = new Thread(this, name);
        thread.start();
    }
    public void run() {
        String name = thread.getName();
        for (int i = 0; i < 100; i++) {
            System.out.println(name);
        }
    }
}

class TestThread2 {
    public static void main(String[] args) {
        PrintNameThread pnt1 = new PrintNameThread("A");
        PrintNameThread pnt2 = new PrintNameThread("B");
        PrintNameThread pnt3 = new PrintNameThread("C");
        PrintNameThread pnt4 = new PrintNameThread("D");
        System.out.println("Running threads...");
        try {
            pnt1.thread.join();
            pnt2.thread.join();
            pnt3.thread.join();
            pnt4.thread.join();
        } catch (InterruptedException ie) {
        }
        System.out.println("Threads killed.");
    }
}