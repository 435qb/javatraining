public class Change {
    public static void main(String[] args) {
        int a = 9;
        int b = 5;
        a ^= b;
        b ^= a;
        a ^= b;
        System.out.println("a=" + a + " b=" + b);
    }
}
