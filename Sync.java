class Callme {
    /*synchronized */void callmee(String msg) {
        try {
            System.out.print("[" + msg);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Paused");

        }
        System.out.println("]");
    }
}

class Caller implements Runnable {
    String msg;
    Callme gg;
    Thread t;

    public Caller(Callme hh, String ms) {
        msg = ms;
        gg = hh;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        synchronized (gg) {
            gg.callmee(msg);
        }
    }
}

public class Sync {
    public static void main(String[] args) {
        Callme tt = new Callme();
        Caller o1 = new Caller(tt, "Hi");
        Caller o2 = new Caller(tt, "Im Andrey");
        try {
            o2.t.join();
            o1.t.join();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Paused");
        }
        System.out.println("Ended");
    }
}
