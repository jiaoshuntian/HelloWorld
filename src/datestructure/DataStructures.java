package datestructure;

/**
 * Created by JiaoShuntian on 2017/9/13.
 */
public class DataStructures {
    public static void main(String[] args) {
        System.out.println(Math.pow(2,10000));
        /*int maxn = 1000;
        double[] a = new double[maxn];
        for (int i = 0; i < maxn; i++) {
            a[i] = i;
        }
        Long startTime = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            polyval1(maxn-1, a, 1.1);
        };
        Long endTime = System.nanoTime();
        System.out.println(endTime - startTime);
        startTime = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            polyval2(maxn-1, a, 1.1);
        };
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);*/
    }

    //for循环打印1-n
    static void printN1(int n) {
        for (int i = 0; i < n; i++) {
            if (i != n) {
                System.out.println(i);
            }
        }
    }

    //递归打印1-n
    static  void printN2(int n) {
        if (n == 0)
            return;
        printN2(n-1);
        System.out.println(n);
    }

    //用循环计算多项式的值 
    static void polyval1(int n, double a[], double x) {
        double s = a[0];
        for (int i = 1; i <= n; i++) {
            s += a[i] * Math.pow(x, i);
        }
        System.out.println(s);
    }

    //用秦九韶法计算多项式的值
    static void polyval2(int n, double a[], double x) {
        double s = a[n];
        for (int i = n; i > 0; i--) {
            s = a[i-1] + x * s;
        }
        System.out.println(s);
    }
}



















