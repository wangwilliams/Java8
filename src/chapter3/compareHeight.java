package chapter3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangyunpeng
 * @date 2020/6/1
 */
public class compareHeight {

    public static void main(String[] args) {
        int[] B = {1,3,5,7};
        int[] C = {1,1,2,5,7};
        int[] D = {1,2,3,5,6,7};
        System.out.println(numberOfArithmeticSlices(B));
        System.out.println(numberOfArithmeticSlices(C));
        System.out.println(numberOfArithmeticSlices(D));
    }

    public static int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        int[] B = new int[A.length-1];
        for (int i = 0; i < A.length-1; i++) {
            B[i] = A[i+1]-A[i];
        }
        List<int[]> temp = new ArrayList<>();
        temp = spiteArray(B);
        int ans = 0;
        for (int[] a : temp) {
            ans = ans + a.length*(a.length-1)/2;
        }
        return ans;
    }


    private static List<int[]> spiteArray(int[] B) {
        int point_front = 1;
        int point_behind = 0;
        List<int[]> ans = new ArrayList<>();

        while (point_front < B.length) {
            if (B[point_front] == B[point_behind]) {
                point_front++;
                if (point_front == B.length) {
                    int[] temp = new int[point_front-point_behind];
                    for (int i = 0;i<point_front-point_behind;i++) {
                        temp[i] = B[i+point_behind];
                    }
                    ans.add(temp);
                }
            } else if(point_behind + 1 == point_front) {
                point_behind++;
                point_front++;
            }else {
                int[] temp = new int[point_front-point_behind];
               for (int i = 0;i<point_front-point_behind;i++) {
                   temp[i] = B[i+point_behind];
               }
               ans.add(temp);
               point_behind=point_front+1;
               point_front= point_behind + 1;
            }
        }
        return ans;
    }
}
