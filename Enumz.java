import java.sql.SQLOutput;

enum Phones {
    Samsung(600,"Available"), Apple(700,"Available"), Xiaomi(200,"Unavailable");
    private int price;
    private String status;

    Phones(int p,String stat) {
        price = p;
        status=stat;
    }


void getInfo(){
    System.out.println("Phone status - "+status);

}
    int getPrice() {


            return price;
        }
    }


public class Enumz {
    public static void main(String[] args) {


        Phones myphone = Phones.Apple;
        System.out.println("My phone by " + myphone);
        Phones urphone = Phones.Xiaomi;
        System.out.println("Ur phone by " + urphone);
        if (myphone == urphone) System.out.println("We can use Air drop!");
        else System.out.println("We cant use Air drop!");
        switch (myphone) {
            case Apple: {
                System.out.println("Its an apple!");
                break;
            }
            case Xiaomi: {
                System.out.println("Cringe pussy!");
                break;
            }
            case Samsung: {
                System.out.println("U good bruuh!");
                break;
            }
            default:
                System.out.println("WHats ur phone?POCOO???");
        }

        System.out.println("Our phones!");
        for (Phones ph : Phones.values()) {
            System.out.print(ph + " ");
        }
        System.out.println();
        Phones val = Phones.Xiaomi;
        val = Phones.valueOf("Xiaomi");
        System.out.println("Val contains " + val);
        myphone = Phones.valueOf("Apple");
        System.out.println("Myphone contains " + myphone);
        for (Phones a : Phones.values()) {
            System.out.println(a + " price is " + a.getPrice());
            a.getInfo();
        }
        System.out.println();
        System.out.println();
        System.out.println(myphone.ordinal());
        System.out.println(urphone.compareTo(Phones.Apple));
        System.out.println(myphone.equals(urphone));
    }
}
