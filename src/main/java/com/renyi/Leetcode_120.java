package com.renyi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @Author: dsy
 * @Date: 2023-12-18 14:46
 * @Description: TODO
 * @Version:1.0
 */
public class Leetcode_120 {
    public static void main(String[] args) {
        List<List<Integer>> list= new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        List<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);
        int i = minimumTotal(list);
        System.out.println(i);
    }
    public static int minimumTotal(List<List<Integer>> triangle) {

        for(int i=1;i<triangle.size();i++){
            for (int j=0;j < triangle.get(i).size();j++){
                if (j<1){
                    triangle.get(i).set(j,triangle.get(i).get(j)+triangle.get(i-1).get(j));
                } else if (j == i){
                    triangle.get(i).set(j,triangle.get(i).get(j)+triangle.get(i-1).get(j-1));
                } else {
                    triangle.get(i).set(j,triangle.get(i).get(j) + Math.min(triangle.get(i-1).get(j-1),triangle.get(i-1).get(j)));
                }
            }
        }

        for (int i = 1; i < triangle.get(triangle.size() - 1).size(); i++) {
            triangle.get(triangle.size() - 1).set(0, Math.min(triangle.get(triangle.size() - 1).get(0),triangle.get(triangle.size() - 1).get(i)));
        }
        return triangle.get(triangle.size() - 1).get(0);
    }
}
