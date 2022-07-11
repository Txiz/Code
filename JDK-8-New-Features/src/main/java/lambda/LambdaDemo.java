package main.java.lambda;

import java.util.*;

/**
 * Lambda 表达式使用
 *
 * @author Txiz
 */
public class LambdaDemo {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        List<String> names = Arrays.asList("jack", "peter", "mary");

        // 基本用法
        names.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        // 简单写法
        names.sort(String::compareTo);

        for (String name : names) {
            System.out.println(name);
        }
    }
}
