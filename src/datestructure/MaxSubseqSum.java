package datestructure;

import java.util.Date;
import java.util.Random;

/**
 * Created by JiaoShuntian on 2017/10/25.
 * 最大子列和问题
 */
public class MaxSubseqSum {
    public static void main(String[] args) {
        int[] a = new int[2000];
        Random random = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(30) - 15;
        }
        long startTime = System.nanoTime();
        // ... the code being measured ...
        System.out.println(maxSubseqSum3(a, a.length));
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println(estimatedTime);
    }

    //算法1
    static int maxSubseqSum1(int a[], int n) {
        int maxSum = 0;
        int thisSum;
        for (int i = 0; i < n; i++) {//i是子列最左端位置
            for (int j = i; j < n; j++) {//j是子列最右端位置
                thisSum = 0;//thisSum是a[i]到a[j]的子列和
                for (int k = i; k <= j; k++) {
                    thisSum += a[k];
                    if (thisSum > maxSum) {
                        maxSum = thisSum;
                    }
                }
            }
        }
        return maxSum;
    }

    //算法2
    static int maxSubseqSum2(int a[], int n) {
        int maxSum = 0;
        int thisSum;
        for (int i = 0; i < n; i++) {//i是子列最左端位置
            thisSum = 0;//thisSum是a[i]到a[j]的子列和
            for (int j = i; j < n; j++) {//j是子列最右端位置
                thisSum += a[j];
                if (thisSum > maxSum) {
                    maxSum = thisSum;
                }
            }
        }
        return maxSum;
    }

    //算法3
    static int maxSubseqSum3(int a[], int n) {
        int maxSum = 0;
        int thisSum = 0;
        for (int i = 0; i < n; i++) {
            thisSum += a[i];
            if (thisSum > maxSum) {
                maxSum = thisSum;
            } else if (thisSum < 0) {
                thisSum = 0;
            }
        }
        return maxSum;
    }
}
