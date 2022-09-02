public class Obolo4 {
    static int set(Integer v){
        return v;
    }
    public static void main(String[] args) {
        Integer ii= new Integer(50);
        int i= Integer.valueOf(ii);
        System.out.println(i+" = i = ii = "+ii);
        System.out.println("Auto!");
Integer i3=set(100);
int i2=i3;
        System.out.println(i3+" = i3 = i2 = "+i2);
    }
}
