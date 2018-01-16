package AlgorithmAndLeetCode;

/**
 * 给定一个整数数组，求出和最大的子数组
 */
public class FindMaxSumSubArrayFromArray {
    public static void main(String args[]) {
        int[] array = {3, 9, -22, 11, 3, 2, 6, 7, -12, -44, 98, 99, 22, -1};
        FindMaxSumMethod1(array);
        FindMaxSumMethod2(array);
    }

    //针对第i个元素，如果其前面的所有元素的和<0，则从第i个重新开始
    public static void FindMaxSumMethod1(int[] array) {
        int beginIndex = 0;
        int maxSum = array[0];
        for (int i = 1; i < array.length; i++) {
            if (maxSum < 0) {
                beginIndex = i;
                maxSum = array[i];
            } else {
                maxSum += array[i];
            }
        }
        System.out.println("The method1 beginIndex is " + beginIndex);
        System.out.println("The method1 maxSum is " + maxSum);
    }

    //Si+1=max(Si+array[i+1],array[i+1])
    public static void FindMaxSumMethod2(int[] array) {
        int beginIndex = 0;
        int maxSum = 0;
        for (int i = 0; i < array.length; i++) {
            if (maxSum + array[i] > array[i]) {
                maxSum = maxSum + array[i];
            } else {
                beginIndex = i;
                maxSum = array[i];
            }

        }
        System.out.println("The method2 beginIndex is " + beginIndex);
        System.out.println("The method2 maxSum is " + maxSum);
    }
}
