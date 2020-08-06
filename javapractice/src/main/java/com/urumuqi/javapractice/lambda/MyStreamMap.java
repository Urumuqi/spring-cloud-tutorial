package com.urumuqi.javapractice.lambda;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

/**
 * @author wuqi
 * @desc todo
 * @class MyStreamMap
 * @date 2020/8/4 23:08
 **/
public class MyStreamMap {

    public static void main(String[] args) {
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        // map()
        costBeforeTax.stream().map(c -> c + .12 * c).forEach(System.out::println);
        // reduce()
        Double total = costBeforeTax.stream().map(c -> c + .12 * c).reduce((s, c) -> s + c).get();
        System.out.println("Total = " + total);
    }
}
