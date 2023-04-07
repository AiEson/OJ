package out.production.学院OJ;

public class 输出九九乘法表 {
        public static void main(String[] args) {
            //简单题copy
            System.out.println("  Nine-by-nine Multiplication Table\n"
                    + "--------------------------------------\n"
                    + "     1   2   3   4   5   6   7   8   9\n"
                    + "--------------------------------------");
            for(int i=1;i<=9;i++){
                System.out.print(" "+i);
                for(int j=1;j<=i;j++){
                    System.out.printf("%4d",i*j);
                }
                System.out.println();
            }
            System.out.println("--------------------------------------\n");
        }

}
