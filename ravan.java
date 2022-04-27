import java.util.*;

class a extends Thread {
    public void run() {
        for (int i = 0; i <= 10; i++) {
            System.out.println("Class A i=" + i);
            if (i == 4)
                this.yield();
        }
    }
}

class b extends Thread {
    public void run() {
        for (int i = 0; i <= 10; i++) {
            System.out.println("Class B i=" + i);
            if (i == 5) {
                try {
                    this.sleep(9000);
                } catch (Exception e) {
                    System.out.println("Exception");
                }
            }
        }
    }
}

class c extends Thread {
    public void run() {
        for (int i = 0; i <= 10; i++) {
            System.out.println("Class C i=" + i);
            if (i == 9)
                this.stop();
        }
    }
}

public class ravan {
    public static void main(String args[]) {
        a ob1 = new a();
        b ob2 = new b();
        c ob3 = new c();
        ob1.start();
        ob2.start();
        ob3.start();
    }
}