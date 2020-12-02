package com.hihocoder.level1;

import java.util.Scanner;

/**
 * A + B
 * 描述
 * 求两个整数A+B的和
 *
 * 输入
 * 控制台输入包含多组数据。
 * 每组数据包含两个整数A(1 ≤ A ≤ 100)和B(1 ≤ B ≤ 100)。
 *
 * 输出
 * 对于每组数据输出A+B的和。
 */
public class APlusB_1000 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a, b;
        while (in.hasNext()) {
            a = in.nextInt();
            b = in.nextInt();
            System.out.println(a + b);
        }
    }

}
