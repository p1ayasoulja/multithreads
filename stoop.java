class NewTh implements Runnable {
    String name;
    Boolean flag;
    Thread t;

    NewTh(String msg) {
        name = msg;
        flag = false;
        t = new Thread(this, name);
        System.out.println("New thread " + t);
        t.start();
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 15; i++) {
                System.out.println(name + " : " + i);
                Thread.sleep(500);
                synchronized (this) {
                    while (flag) {
                        wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println(name + " Paused");
        }
        System.out.println(name + " Thread end!");
    }

    synchronized void pause() {
        flag = true;
    }

    synchronized void resume() {
        flag = false;
        notify();
    }
}


public class stoop {
    public static void main(String[] args) {
        NewTh ob1 = new NewTh("fIRST");
        NewTh ob2 = new NewTh("Second");
        try {
            Thread.sleep(2000);
            System.out.println(ob1 + " On Pause in 1 sec");
            ob1.pause();

            Thread.sleep(2000);
            System.out.println(ob1 + " Resumed");
            ob1.resume();

            Thread.sleep(2000);
            System.out.println(ob2 + " on Pause in 1 sec");
            ob2.pause();

            Thread.sleep(2000);
            System.out.println(ob2 + " Resumed");
            ob2.resume();

        } catch (InterruptedException e) {
            System.out.println("Paused!!! main");
        }
        try {
            System.out.println("Waitin end");
            ob1.t.join();
            ob2.t.join();
        } catch (InterruptedException e) {
            System.out.println("Paused main!!!");

        }
        System.out.println("Main end!");
    }
}
