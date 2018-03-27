package AlgorithmAndLeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pengju on 2018/2/8.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String args[]) {
        String[] array = {"a", "b", "c", "d", "c", "d", "a", "b", "c", "d", "e", "a", "h", "i"};
        int max = getLongestSubstringWithoutRepeatingCharacters(array);
        System.out.println(max);
    }

    public static int getLongestSubstringWithoutRepeatingCharacters(String[] array) {
        if (null == array || array.length < 1) {
            return 0;
        } else {
            Map<String, Integer> charMap = new HashMap<>();

            int max = 0;//最大不重复字串长度
            int pre = 0;//字串开始位置
            for (int i = 0; i < array.length; i++) {
                String str = array[i];
                if (charMap.containsKey(str)) {
                    if (pre <= charMap.get(str)) {
                        max = Math.max(max, i - charMap.get(str));
                        pre = charMap.get(str) + 1;
                    } else {
                        max = Math.max(max, i - pre + 1);
                    }
                    charMap.replace(str, i);
                } else {
                    charMap.put(str, i);
                    max = Math.max(max, i - pre + 1);
                }
            }

            return max;
        }
    }
}
