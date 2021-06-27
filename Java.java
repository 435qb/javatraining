class Java {
    public static void main(String[] args) {
        int d = 0;
        while (d++ != 100) {
            System.out.print(
                String.format("%03d", d) + 
                "公里:" + 
                String.format("%3d", calc(d)) 
                + ".0元; ");
                if (d % 5 == 0) {
                    System.out.println();
                    
                }
        }
    }
    private static int calc(int d) {
        int sum = 8;
        if (d > 3 && d <= 15) {
            sum += Math.ceil((d - 3) / 0.55);
        }
        if (d > 15)
            sum += Math.ceil(12 / 0.55 + (d - 15) / 0.37);
        return sum;
    }
}