package com.urumuqi.javapractice.lambda;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wuqi
 * @desc todo
 * @class MyStreamRuu
 * @date 2020/8/19 16:42
 **/
public class MyStreamAPI {

    public static void main(String[] args) {
        // Stream<String> stream = Stream.of("I", "love", "you", "too", "to0");
        // filter
        // stream.filter( s -> s.length() == 3)
        //         .forEach(System.out::println);

        // distinct
        // stream.distinct()
        //         .forEach(System.out::println);

        // sorted
        // stream.sorted((s1, s2) -> s1.length() - s2.length())
        //         .forEach(System.out::println);

        // map
        // stream.map(s -> s.toUpperCase())
        //         .forEach(System.out::println);

        // flatMap
        // Stream<List<Integer>> streamList = Stream.of(Arrays.asList(1, 2, 3), Arrays.asList(3, 4, 5));
        // streamList.flatMap(l -> l.stream())
        //         .forEach(System.out::println);

        // reduce
        // Stream<String> strStream = Stream.of("I", "still", "love", "you");
        // Optional<String> longest = strStream.reduce((s1, s2) -> s1.length() >= s2.length() ? s1 : s2);
        // System.out.println(longest.get());
        // Integer strLen = strStream.reduce(0,
        //         (sum, str) -> sum + str.length(),
        //         (a, b) -> a + b);
        // System.out.println(strLen);

        // collect
        // List<String> list = strStream.collect(Collectors.toList());
        // Set<String> set = strStream.collect(Collectors.toSet());
        // Map<String, Integer> map = strStream.collect(Collectors.toMap(Function.identity(), String::length));
        // System.out.println(list);
        // System.out.println(set);
        // System.out.println(map);
        Department d1 = new Department("e1's department");
        Employee e1 = new Employee("first employee", d1);
        Department d2 = new Department("e2's department");
        Employee e2 = new Employee("first employee", d2);
        Department d3 = new Department("e3's department");
        Employee e3 = new Employee("first employee", d3);
        Department d4 = new Department("e4's department");
        Employee e4 = new Employee("first employee", d4);
        List<Employee> employees = Arrays.asList(e1, e2, e3, e4);

        Map<Department, List<Employee>> byDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(byDept.toString());
    }

    static class Employee {
        private String name;
        private Department department;

        public Employee(String name, Department department) {
            this.name = name;
            this.department = department;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Department getDepartment() {
            return department;
        }

        public void setDepartment(Department department) {
            this.department = department;
        }
    }

    static class Department {
        private String name;

        public Department(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
