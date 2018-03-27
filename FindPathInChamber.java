package AlgorithmAndLeetCode;

/**
 * Created by pengju on 2018/1/22.
 * <p>
 * 有一个地宫，m*n大小的矩阵格子形状。一个英雄以某初始血点从地宫的左上角进从右下角出，每次智能走只能从左往右或从一格，上往下走，每走一格，加上格子中的血点，
 * 期间保持血点大于零。求英雄最小应有的血点数。
 */
public class FindPathInChamber {
    public static void main(String args[]) {
        int[][] array = {
                {-2, -5, 2},
                {-7, -15, 1},
                {-3, -15, 6}
        };

        int value = getMinValue(array);
        System.out.println(value);
    }

    public static int getMinValue(int[][] array) {
        int value = 0;
        if (null != array && array.length > 0) {
            int m = array.length;
            int n = array[0].length;

            //计算走到最右下角英雄需要具有的血点数
            array[m - 1][n - 1] = (1 - array[m - 1][n - 1]) > 1 ? (1 - array[m - 1][n - 1]) : 1;

            //计算走到最下面一行英雄需要具有的血点数
            if (n > 1) {
                for (int j = n - 2; j >= 0; j--) {
                    array[m - 1][j] = (array[m - 1][j + 1] - array[m - 1][j]) > 1 ? (array[m - 1][j + 1] - array[m - 1][j]) : 1;
                }
            }

            //计算走到最右侧一行英雄需要具有的血点数
            if (m > 1) {
                for (int i = m - 2; i >= 0; i--) {
                    array[i][n - 1] = (array[i + 1][n - 1] - array[i][n - 1]) > 1 ? (array[i + 1][n - 1] - array[i][n - 1]) : 1;
                }
            }

            //计算走到其他位置英雄需要的血点数
            if (m > 1 && n > 1) {
                for (int i = m - 2; i >= 0; i--) {
                    for (int j = n - 2; j >= 0; j--) {
                        int herizontal = (array[i][j + 1] - array[i][j]) > 1 ? (array[i][j + 1] - array[i][j]) : 1;
                        int vertical = (array[i + 1][j] - array[i][j]) > 1 ? (array[i + 1][j] - array[i][j]) : 1;
                        array[i][j] = herizontal < vertical ? herizontal : vertical;
                    }
                }
            }
            value = array[0][0];
        }
        return value;
    }
}
