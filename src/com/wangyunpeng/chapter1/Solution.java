package com.wangyunpeng.chapter1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangyunpeng
 * @date 2020/5/27
 */
public class Solution {
    static List<Integer> ans = new ArrayList<>();
    public static void main(String[] args) {
        int[] A = {4,5,0,-2,-3,1};
        List<List<Integer>> lists = new ArrayList<>();
        int num = subarraysDivByK(A, 5);
        System.out.println(num);
    }

    public static int subarraysDivByK(int[] A, int K) {
        // 计算能被K整除的数字
        int k = (int) Math.floor(Math.sqrt(K));
        List<List<Integer>> addNumList = new ArrayList<>();
        addtoList(A, addNumList,0);
        int ansNum = 0;
        for (int i =0; i < ans.size(); i++) {
            if (ans.get(i) != 0 && K % ans.get(i) == 0){
                ansNum ++;
            }
        }
        return ansNum;
    }
    
    private static void addtoList(int[] A, List<List<Integer>> shortList,int k) {

        if (k  == A.length - 1 && A.length != 0){
            for (List list : shortList) {
                int temp = 0;
                for (int i=0; i<list.size();i++) {
                    temp =  temp+(Integer)list.get(i);
                }
                ans.add(temp);
            }
            return;
        }
        List<List<Integer>> newList = new ArrayList<>();
        if (k == 0) {
            List<Integer> first = new ArrayList<>();
            first.add(A[0]);
            List<Integer> second = new ArrayList<>();
            second.add(0);
            newList.add(first);
            newList.add(second);
        }else {
            for (List list1 : shortList) {
                List temp = new ArrayList();
                for (Object integer : list1){
                    temp.add(integer);
                }
                newList.add(temp);
            }
            for (List<Integer> list1 : shortList) {
                list1.add(A[k]);
                newList.add(list1);
            }
        }
        addtoList(A, newList, k+1 );
    }
}
