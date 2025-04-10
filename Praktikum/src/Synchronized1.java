class TwoStrings2 {
    synchronized static void print(String str1, String str2) {
        System.out.println(str1);
        try {
            Thread.sleep(500);
        } catch (InterruptedException ie) {
        }
        System.out.println(str2);
    }
}

class PrintStringsThread2 implements Runnable {
    Thread thread;
    String str1, str2;
    PrintStringsThread2(String str1, String str2) {
        this.str1 = str1;
        this.str2 = str2;
        thread = new Thread(this);
        thread.start();
    }
    public void run() {
        TwoStrings2.print(str1, str2);
    }
}

class Synchronized1 {
    public static void main(String[] args) {
        new PrintStringsThread2("Hello ", "there.");
        new PrintStringsThread2("How are ", "you?");
        new PrintStringsThread2("Thank you ", "very much!");
    }
}