package chapter3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangyunpeng
 * @date 2020/5/30
 */
public class Solution {
    public static void main(String[] args) {
      /*  System.out.println(canMeasureWater(104597, 104623,
                123));
        System.out.println(canMeasureWater(2, 6, 5));
        System.out.println(canMeasureWater(1, 2, 3));
        System.out.println(canMeasureWater(11, 13, 1));*/
        //nums1 = [1,7,11], nums2 = [2,4,6], k = 3
        System.out.println(removeKdigits("123456",3));
        System.out.println(removeKdigits("1432219",3));
        System.out.println(removeKdigits("10",2));
    }

    /**
     * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
     * <p>
     * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
     * <p>
     * 你允许：
     * <p>
     * 装满任意一个水壶
     * 清空任意一个水壶
     * 从一个水壶向另外一个水壶倒水，直到装满或者倒空
     * <p>
     * 输入: x = 3, y = 5, z = 4
     * 输出: True
     * <p>
     * 输入: x = 2, y = 6, z = 5
     * 输出: False
     */

    public static boolean canMeasureWater(int x, int y, int z) {
        if (z == 0) {
            return true;
        }

        if (x == 0 || y == 0) {
            return false;
        }

        if (z == x || z == y) {
            return true;
        }

        int large = x > y ? x : y;
        int little = x > y ? y : x;

        int valLarge = 0;
        int valLittle = little;
        List<Integer> list = new ArrayList<>();
        while (!hasTheValue(list, valLarge)) {
            if (valLarge + valLittle <= large) {
                valLarge = valLittle + valLarge;
                valLittle = little;
            } else {
                valLittle = valLittle + valLarge - large;
                valLarge = 0;
            }
            if (valLarge == z || valLittle + valLarge == z || valLittle == z) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasTheValue(List<Integer> list, int value) {
        for (Integer cal : list) {
            if (cal == value && value != 0) {
                return true;
            }
        }
        if (value != 0)
            list.add(value);
        return false;
    }

    /**
     * 给定两个以升序排列的整形数组 nums1 和 nums2, 以及一个整数 k。
     * <p>
     * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2。
     * <p>
     * 找到和最小的 k 对数字 (u1,v1), (u2,v2) ... (uk,vk)。
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
     * 输出: [1,2],[1,4],[1,6]
     * 解释: 返回序列中的前 3 对数：
     * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
     * 示例 2:
     * <p>
     * 输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
     * 输出: [1,1],[1,1]
     * 解释: 返回序列中的前 2 对数：
     *      [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
     * 示例 3:
     * <p>
     * 输入: nums1 = [1,2], nums2 = [3], k = 3
     * 输出: [1,3],[2,3]
     * 解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
     */
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        int pointOne = 0;
        int starOne = pointOne;
        int pointTwo = 0;
        int starTwo = pointTwo;
        int i = 0;
        while ((pointOne != nums1.length - 1 && pointTwo != nums2.length - 1) || i == k) {
            List<Integer> list = new ArrayList<>();
            list.add(nums1[pointOne], nums2[starTwo]);
            list.add(nums1[pointTwo], nums2[starOne]);
            ans.add(list);
            i++;
            if (starOne + 1 == nums1.length && pointTwo + 1 != nums2.length) {
                pointTwo++;
            }
        }
        return ans;
    }


    public static String removeKdigits(String num, int k) {
        if (k == 0 || num.equals("0")) {
            return num;
        }
        if (k== 1 && num.length() == 2) {
            return String.valueOf(num.charAt(0) > num.charAt(1) ? num.charAt(1) : num.charAt(0));
        }
        if (num.length() == k) {
            return "0";
        }

        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < num.length(); i++) {
            characters.add(num.charAt(i));
        }
        int start = 0;
        while (k > 0 && start < characters.size()){
            if (start == 0 && characters.get(0) > characters.get(1)) {
                characters.remove(0);
                k--;
                continue;
            }
            if (start == 0 && characters.get(0) <= characters.get(1)) {
                start++;
                continue;
            }
            if (start + 1 != characters.size()){
                if (characters.get(start) >= characters.get(start-1) && characters.get(start) >= characters.get(start+1)) {
                    characters.remove(start);
                    k--;
                    start--;
                }
            }
            start++;
        }
        if (start == characters.size() && k > 0){
            while ( k > 0) {
                characters.remove(characters.size()-1);
                k--;
            }
        }
       while (characters.get(0) == '0'){
           characters.remove(0);
       }
        StringBuilder sb = new StringBuilder();
        for (Character ch : characters) {
            sb.append(ch);
        }
        return sb.toString();
    }

}
