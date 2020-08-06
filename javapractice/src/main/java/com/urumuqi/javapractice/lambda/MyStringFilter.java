package com.urumuqi.javapractice.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wuqi
 * @desc todo
 * @class MyStringFilter
 * @date 2020/8/5 08:19
 **/
public class MyStringFilter {

    public static void main(String[] args) {
        List<String> strList = Arrays.asList("ab", "cde", "fghi", "123456", "1", "2234");
        // 获得一个新的 List
        List<String> filtered = strList.stream().filter(n -> n.length() > 2).collect(Collectors.toList());
        System.out.printf("Origin array list : %s, filtered array list : %s \n", strList, filtered);

        // map func
        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.", "Canada");
        String G7Countries = G7.stream().map(n -> n.toUpperCase()).collect(Collectors.joining(", "));
        System.out.println(G7Countries);

        // distinct()
        List<Integer> nums = Arrays.asList(12, 13, 8, 7 ,4, 24, 7, 9, 0, 12);
        List<Integer> newNums = nums.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        System.out.printf("origin nums : %s, new nums : %s", nums, newNums);
    }
}
