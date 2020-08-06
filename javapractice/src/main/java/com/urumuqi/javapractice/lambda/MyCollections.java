package com.urumuqi.javapractice.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * @author wuqi
 * @desc todo
 * @class MyCollections
 * @date 2020/8/4 10:52
 **/
public class MyCollections {

    public static void main(String[] args) {
        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        for (String feature : features) {
            System.out.println(feature);
        }

        // try lambda
        features.forEach(System.out::println);
    }
}
