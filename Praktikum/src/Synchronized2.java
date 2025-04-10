class TwoStrings3 {
    static void print(String str1, String str2) {
        System.out.println(str1);
        try {
            Thread.sleep(500);
        } catch (InterruptedException ie) {
        }
        System.out.println(str2);
    }
}

class PrintStringsThread3 implements Runnable {
    Thread thread;
    String str1, str2;
    TwoStrings3 ts;
    PrintStringsThread3(String str1, String str2, TwoStrings3 ts) {
        this.str1 = str1;
        this.str2 = str2;
        this.ts = ts;
        thread = new Thread(this);
        thread.start();
    }
    public void run() {
        synchronized(ts) {
            ts.print(str1, str2);
        }
    }
}

class Synchronized2 {
    public static void main(String[] args) {
        TwoStrings3 ts = new TwoStrings3();
        new PrintStringsThread3("Hello ", "there.", ts);
        new PrintStringsThread3("How are ", "you?", ts);
        new PrintStringsThread3("Thank you ", "very much!", ts);
    }
}