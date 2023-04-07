import java.util.Scanner;

public class 矩阵乘方 {
    static int[][] A;
    static int m;
    public static void main(String[] args) {
        A = new int[2][2];
        Scanner sc = new Scanner(System.in);
        int b = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                A[i][j] = sc.nextInt();
            }
        }
        if (b % 2 == 0) {
            //偶数  若b为偶数，则A^b%m=(A^(b/2)%m)^2%m，即先把A乘b/2次方对m求余，然后再平方后对m求余。
            int[][] out = new int[2][2];

        }
    }

    public static int[][] remK(int[][] inC, int rem) {

        int[][] C = new int[2][2];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                C[i][j] = inC[i][j] % rem;
            }
        }
        return C;
    }

    public static int[][] timesK(int[][] inC, int times) {

        int[][] C = new int[2][2];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                C[i][j] = inC[i][j] * times;
            }
        }
        return C;
    }

    public static int[][] Asq(int times) {
        int[][] C = new int[2][2];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                C[i][j] = A[i][j];
            }
        }
        for (int i = 0; i < times; i++) {
            C = ATimesC(C);
        }
        return C;
    }

    public static int[][] ATimesC(int[][] inC) {
        int[][] C = new int[2][2];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                C[i][j] = getSum(i, j, inC);
            }
        }
        return C;
    }
    public static int[][] BTimesC(int[][] inB, int[][] inC) {
        int[][] C = new int[2][2];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                C[i][j] = getSum(i, j, inC);
            }
        }
        return C;
    }
    public static int getSum(int i, int j, int[][] inC) {
        int ret = 0;
        for (int k = 0; k < 2; k++) {
            ret += A[i][j] * inC[k][j];
        }
        return ret;
    }


}
