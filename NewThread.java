import java.sql.SQLOutput;

class NeeTh2 extends Thread {
    NeeTh2() {
        super("Demo2");
        System.out.println("Demo 2 " + this);
        start();
    }

    @Override
    public void run() {
        try {
            for (int i = 10; i > 5; i--) {
                System.out.println("demo2= " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Demo2 paused");
        }
        System.out.println("Demo2 end!");
    }
}

class TestTh implements Runnable {
    Thread t;
String name;
    TestTh(String threadname) {
        name= threadname;
        t = new Thread(this,name);
        System.out.println("Created demo3");
        t.start();
    }

    @Override
    public void run() {
        String g="Bomb gonna boom in ";
        try {
            for (int e = 5; e >0; e--) {
                System.out.println(g+ "..."+e);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            System.out.println("pAUSED demo 3");
        }
        System.out.println("Booom!");
    }
}

class NeeTh implements Runnable {
    Thread t;

    NeeTh() {
        t = new Thread(this, "Demo");
        System.out.println("New Thread = " + t);
        t.start();
    }

    @Override
    public void run() {
        try {
            for (int n = 5; n > 0; n--) {
                System.out.println("demo1 = " + n);
                Thread.sleep(750);
            }
        } catch (InterruptedException e) {
            System.out.println("Found exception! Pause");
        }
        System.out.println("Second Thread end!");
    }
}

public class NewThread {
    public static void main(String[] args) {
       // new NeeTh();
       // new NeeTh2();
       TestTh gg= new TestTh("Boommm");
        System.out.println("Boom status "+gg.t.isAlive());
        try {
            gg.t.join();
            for (int i = 0; i < 5; i++) {
                System.out.println("Main = " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread pause");
        }
        System.out.println("Boom status "+gg.t.isAlive());
        System.out.println("Main thread end!");


    }
}
