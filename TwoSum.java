package AlgorithmAndLeetCode.TwoSumThreeSumAndKSum;

import java.util.*;

public class TwoSum {

    public static void main(String args[]) {
        int[] twoSumNumbers = {2, 7, 11, 15};
        int target = 9;
        int[] twoSumPairs = TwoSumEqual(twoSumNumbers, target);
        for (int num : twoSumPairs) {
            System.out.println(num);
        }

        int[] threeSumNumbers = {-1, 0, 1, 2, -1, -4};
        ArrayList<ArrayList<Integer>> list = threeSum(threeSumNumbers);
        list.stream().forEach(l -> {
            System.out.print("(");
            l.stream().forEach(o -> System.out.println(o));
            System.out.print(")");
        });

        int[] threeCloseNums = {-1, 2, 1, -4};
        int target2 = 1;
        int sum = threeSumClosest(threeCloseNums, target2);
        System.out.println("The 3 sum close sum is :"+sum);
    }

    /**
     * Problem:Given an array of integers, find two numbers such that
     * they add up to a specific target number.
     */
    public static int[] TwoSumEqual(int[] A, int target) {
        int[] res = {-1, -1};
        if (A == null || A.length < 2) return res;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(target - A[i])) {
                res[0] = map.get(target - A[i]) + 1;
                res[1] = i + 1;
                return res;
            } else map.put(A[i], i);
        }
        return res;
    }


    /**
     * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
     * Find all unique triplets in the array which gives the sum of zero.
     */
    public static ArrayList<ArrayList<Integer>> threeSum(int[] A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        if (A.length < 3) return null;
        Arrays.sort(A);
        for (int i = 0; i <= A.length - 3; i++) {
            int left = i + 1, right = A.length - 1;
            if (i != 0 && A[i] == A[i - 1]) continue;
            while (left < right) {
                int sum = A[i] + A[left] + A[right];
                if (sum == 0) {
                    ArrayList<Integer> temp = new ArrayList();
                    temp.add(A[i]);
                    temp.add(A[left]);
                    temp.add(A[right]);
                    res.add(temp);
                    left++;
                    right--;
                    while (left < right && A[left] == A[left - 1]) left++;
                    while (left < right && A[right] == A[right + 1]) right--;
                } else if (sum < 0) left++;
                else right--;
            }
        }
        return res;
    }

    /**
     * Given an array S of n integers, find three integers in S such that the sum is closest to a given number,
     * target. Return the sum of the three integers.
     *
     * @param A
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] A, int target) {
        int min = Integer.MAX_VALUE - target;
        if (A == null || A.length < 3) return -1;
        Arrays.sort(A);
        for (int i = 0; i < A.length - 2; i++) {
            int left = i + 1, right = A.length - 1;
            while (left < right) {
                int sum = A[i] + A[left] + A[right];
                if (sum == target) return sum;
                else if (sum < target) left++;
                else right--;
                min = Math.abs(min - target) < Math.abs(sum - target) ? min : sum;
            }
        }
        return min;
    }

}
