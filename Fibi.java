import java.util.*;
public class Fibi {
    // 递归 变量循环 数组
    public static int fi1(int x) {
        if (x == 0)
            return 1;
        else if (x == 1)
            return 1;
        return fi1(x - 1) + fi1(x - 2);
    }

    public static int fi2(int x) {
        if (x == 0)
            return 1;
        else if (x == 1)
            return 1;
        int first = 1;
        int second = 2;
        int result = 2;
        for (int i = 2; i < x; ++i) {
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }
    public static int fi3(int x){
        ArrayList<Integer> result = new ArrayList<Integer>(x);
        
    }
    public static void main(String[] args) {
        System.out.println(fi2(20));
    }
}
