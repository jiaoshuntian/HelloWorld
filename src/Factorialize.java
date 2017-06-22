import javax.xml.transform.Result;

/**
 * Created by JiaoShuntian on 2017/5/17.
 */
//阶乘运算
public class Factorialize {
    public static int factorialize1(int n) {
        int result = 1;
        if (n < 0)
            throw new IllegalArgumentException("必须为正整数！");
        for (int i = n; i >= 1; i--) {
            result *= i;
        }
        return result;
    }

    //运用递归
    public static int factorialize2(int n) {
        int result = 1;
        if (n < 0)
            throw new IllegalArgumentException("必须为正整数！");
        if (n == 1) {
            return 1;
        } else {
            result = n * factorialize2(n - 1);
            return result;
        }
    }

    public static void main(String[] args) {
        System.out.println(factorialize2(5));
    }
}
