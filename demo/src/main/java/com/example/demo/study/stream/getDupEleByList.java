package com.example.demo.study.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author zhangfei
 * @version 1.0
 * @date 2020-07-08 15:26
 */
public class getDupEleByList {
    public static void main(String[] args) {
        List<String> parameterList = Arrays.asList("1","2","2","3","3","4","4","5","6","7","8");
        List<String> resultList = parameterList.stream().collect(Collectors.collectingAndThen(
                Collectors.groupingBy(Function.identity(), Collectors.counting()),
                map -> { map.values().removeIf(size -> size == 1);
            return new ArrayList<>(map.keySet());
        }));
        System.out.println(resultList);
    }
}
