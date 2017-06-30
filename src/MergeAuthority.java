/**
 *合并权限串
 * Created by JiaoShuntian
 */
public class MergeAuthority{
    public static void main(String[]args){
        String rightValues1 = "1001100";
        String rightValues2 = "100011";
        String rightValues3 = "1001100";
        String rightValues4 = "001101";
        String rightValues5 = "1001101";
        String rightValues6 = "0011";
        System.out.println(mergeRightValue(rightValues1,rightValues2,rightValues3,rightValues4,rightValues5,rightValues6));
    }
    static String mergeRightValue(String... rightValues){
        String mergeRightValue;
        int addLength;//需要补0的个数
        int maxLength = 0;//最大权限串长度
        int mergeValues = 0;
        StringBuilder[] sb = new StringBuilder[rightValues.length];
        int[] iRightvalues = new int[rightValues.length];
        for(int i = 0;i<rightValues.length;i++){
            sb[i] = new StringBuilder(rightValues[i]);
            if (sb[i].length() > maxLength){
                maxLength = sb[i].length();
            }
            iRightvalues[i] =  Integer.parseInt(sb[i].reverse().toString(),2);//转为十进制
            mergeValues |= iRightvalues[i];//位或运算
        }
        mergeRightValue = Integer.toBinaryString(mergeValues);
        StringBuilder sbMergeRightValue = new StringBuilder(mergeRightValue);
        if (sbMergeRightValue.length() < maxLength){
            addLength = maxLength - sbMergeRightValue.length();
            mergeRightValue = sbMergeRightValue.reverse().toString();
            for (int j = 0;j<addLength;j++){
                mergeRightValue = mergeRightValue+"0";
            }
            return mergeRightValue;
        }
        mergeRightValue = sbMergeRightValue.reverse().toString();
        return mergeRightValue;
    }
}