public class Diamond {
    public static int num = 17;
    public static void main(String[] args) {
        CalBase cb = new Calc3();
        for (int i = 1; i <= num; ++i) {
            for (int j = 1; j <= num; ++j) {
                if (cb.calc(i,j)) System.out.print("#");
                else System.out.print(" ");
            }
            System.out.println();
        }
    }
}
interface CalBase{
    public boolean calc(int line, int column);
}
class Calc1 implements CalBase{
    public boolean calc(int line, int column){
        return true;
    }
}

class Calc2 implements CalBase{
    public boolean calc(int line, int column){
        int t = (Diamond.num + 1) / 2 ;
        // assert(line >= 1);
        // assert(num >= 0 && num <= 2 * line - 1);
        return Math.abs(line - t) + Math.abs(column - t) <= t - 1;
    }
}
class Calc3 implements CalBase{
    public boolean calc(int line, int column){
        int t = (Diamond.num + 1) / 2 ;
        // assert(line >= 1);
        // assert(num >= 0 && num <= 2 * line - 1);
        return Math.abs(line - t) + Math.abs(column - t) == t - 1;
    }
}