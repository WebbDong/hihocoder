package com.hihocoder.level1;

import java.util.Scanner;

/**
 * 描述
 *      小Ho给自己定了一个宏伟的目标：连续100天每天坚持在hihoCoder上提交一个程序。100天过去了，小Ho查看自己的提交记录发现有N天因为贪玩忘记提交了。
 *      于是小Ho软磨硬泡、强忍着小Hi鄙视的眼神从小Hi那里要来M张"补提交卡"。每张"补提交卡"都可以补回一天的提交，将原本没有提交程序的一天变成有提交程序的一天。
 *      小Ho想知道通过利用这M张补提交卡，可以使自己的"最长连续提交天数"最多变成多少天。
 *
 * 输入
 *      第一行是一个整数T(1 <= T <= 10)，代表测试数据的组数。
 *      每个测试数据第一行是2个整数N和M(0 <= N, M <= 100)。第二行包含N个整数a1, a2, ... aN(1 <= a1 < a2 < ... < aN <= 100)，
 *      表示第a1, a2, ...  aN天小Ho没有提交程序。
 *
 * 输出
 *      对于每组数据，输出通过使用补提交卡小Ho的最长连续提交天数最多变成多少。
 *
 * 样例输入
 *      3
 *      5 1
 *      34 77 82 83 84
 *      5 2
 *      10 30 55 56 90
 *      5 10
 *      10 30 55 56 90
 *
 * 样例输出
 *      76
 *      59
 *      100
 */
public class SubmittedCard_1051 {

    public static int MAX_DAY = 100;

    public static void main(String[] args) {
        /*
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        for (int i = 0; i < num; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] days = new int[n + 1];
            days[0] = 0;
            for (int j = 1; j <= n; j++) {
                days[j] = scanner.nextInt();
            }
            System.out.println(getLongestContinuousDay(days, n, m));
        }
         */
//        System.out.println(getLongestContinuousDay(new int[] {0, 34, 77, 82, 83, 84}, 5, 1));
        System.out.println(getLongestContinuousDay(new int[] {0, 10, 30, 55, 56, 90}, 5, 2));
    }

    public static int getLongestContinuousDay(int[] days, int n, int m) {
        if (m >= n) {
            return MAX_DAY;
        }
        int max = 0;
        for (int i = m + 1; i <= n; i++) {
            int diff = days[i] - days[i - m - 1] - 1;
            if (diff > max) {
                max = diff;
            }
        }
        return max;
    }

}
