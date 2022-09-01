class Seller {
    int n;
    boolean checker = false;

    synchronized int get() {

        while (!checker){
            try {
                wait();

            } catch (InterruptedException e) {
                System.out.println("Paused");
            }}
        checker = true;
        System.out.println("Received " + n);
        notify();
        return n;
    }

    synchronized void push(int n) {
        while (checker)
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Paused");
            }
        this.n = n;
        System.out.println("Sent " + n);
        checker = false;
        notify();

    }
}

class Sklad implements Runnable {
    Seller ss;

    Sklad(Seller q) {
        this.ss = q;
        new Thread(this, "Sklad").start();
    }

    @Override
    public void run() {
        int i = 0;
        while (true&i<6) {
            ss.push(i );
            i++;

        }
    }
}

class Buyer implements Runnable {
    Seller ss;

    Buyer(Seller gg) {
        this.ss = gg;
        new Thread(this, "Buyer").start();
    }

    @Override
    public void run() {
        while (true) {
            ss.get();
        }
    }
}

public class waitnotify {
    public static void main(String[] args) {
        Seller ss = new Seller();
        new Sklad(ss);
        new Buyer(ss);


    }


}
