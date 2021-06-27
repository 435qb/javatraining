import java.util.Scanner;
class Java{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = 16;
        while(t-- != 0)
        {
            System.out.println("请输入行驶公里数:(第"+ (16-t) +"/16次)");
            //if(!scanner.hasNext()) break;
            if(!scanner.hasNextDouble()){
                System.out.println("请输入数字");
                scanner.next();
                continue;
            }
            double d = scanner.nextDouble();
            if(d <= 0){
                System.out.println("输入的必须为正");
                continue;
            } else if(d > 10000){
                System.out.println("输入的不能大于一万");
                continue;
            }
            int sum = 8;
            if(d > 3 && d <= 15){
                sum += Math.ceil((d - 3)/0.55);
            }
            if(d > 15) sum += Math.ceil(12 / 0.55 +(d - 15) / 0.37);

            System.out.println("打车金额为：" + sum + ".0 元");
            
        }
        scanner.close();
    }
}