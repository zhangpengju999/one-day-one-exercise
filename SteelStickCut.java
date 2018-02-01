package AlgorithmAndLeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by pengju on 2018/2/1.
 * 钢条切割问题：给定一段长度为n英寸的钢条和一个价格表pi(i=1,2,…n)，求切割钢条方案，使得销售收益rn最大。
 * 注意，如果长度为n英寸的钢条的价格pn足够大，最优解可能就是完全不需要切割
 */
public class SteelStickCut {
    public static void main(String args[]) {
        int[] stellStickLengthArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] priceArray = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        int value = getMaxValue(priceArray);
        System.out.println(value);
    }

    //DP[i]=max(DP[i-1]+DP[1],DP[i-2]+DP[2],DP[i-3]+DP[3]...,DP[])
    public static int getMaxValue(int[] priceArray) {
        int value = 0;
        if (null != priceArray || priceArray.length == 0) {
            List<Integer> maxValueList = new ArrayList<>();
            maxValueList.add(priceArray[0]);
            if (priceArray.length > 1) {
                for (int i = 1; i < priceArray.length; i++) {
                    int currentMax = priceArray[i];
                    for (int j = i - 1; j > i / 2; j--) {
                        int current = maxValueList.get(j) + maxValueList.get(i - j);
                        if (currentMax < current) current = current;
                    }
                    maxValueList.add(currentMax);
                }

            }
            value = maxValueList.get(maxValueList.size() - 1);
        }
        return value;
    }
}
