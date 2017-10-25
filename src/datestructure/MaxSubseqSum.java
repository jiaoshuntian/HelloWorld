package datestructure;

import java.util.Date;

/**
 * Created by JiaoShuntian on 2017/10/25.
 * 最大子列和问题
 */
public class MaxSubseqSum {
    public static void main(String[] args) {
        int[] a = {3,-1,2,1,-9,3,3,9};
        long startTime = System.nanoTime();
        // ... the code being measured ...
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println(System.currentTimeMillis());
        System.out.println(System.nanoTime());
        System.out.println(estimatedTime);
        //System.out.println(maxSubseqSum2(a,a.length));
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
}
