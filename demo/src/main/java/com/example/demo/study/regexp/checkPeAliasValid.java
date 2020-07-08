package com.example.demo.study.regexp;

/**
 * @author zhangfei
 * @version 1.0
 * @date 2020-07-08 15:39
 */
public class checkPeAliasValid {
    public static void main(String[] args) {
        System.out.println(isLetterDigitOrChinese("中国人真好1"));
        System.out.println(isLetterDigitOrChinese("中国人真好1@"));
    }

    public static boolean isLetterDigitOrChinese(String str) {
        //其他需要，直接修改正则表达式就好
        String regex = "^[a-z0-9A-Z\u4e00-\u9fa5]+$";
        return str.matches(regex);
    }
}
