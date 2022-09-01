public class Potoki {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        System.out.println("T name " + t);
        t.setName("My potok");
        System.out.println("T name 2 " + t);
        try {
            for (int n = 5; n > 0; n--) {
                System.out.print("n= " + n);
                for (int i = 0; i < 3; i++) {
                    Thread.sleep(500);
                    System.out.print(".");


                }
                System.out.println();
            }
        } catch (InterruptedException e) {
            System.out.println("Found a exception");
        }
    }
}
