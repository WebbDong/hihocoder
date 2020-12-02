package com.hihocoder.level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 1)如果s包含长度超过1的由相同字母组成的子串，那么这些子串会被同时消除，余下的子串拼成新的字符串。
 *   例如"ABCCBCCCAA"中"CC","CCC"和"AA"会被同时消除，余下"AB"和"B"拼成新的字符串"ABB"。
 * 2)上述消除会反复一轮一轮进行，直到新的字符串不包含相邻的相同字符为止。例如”ABCCBCCCAA”经过一轮消除得到"ABB"，再经过一轮消除得到"A"
 *
 * 第一组数据：在"ABCBCCCAA"的第2个字符后插入'C'得到"ABCCBCCCAA"，消除后得到"A"，总共消除9个字符(包括插入的'C')。
 * 第二组数据："AAA"插入'A'得到"AAAA"，消除后得到""，总共消除4个字符。
 * 第三组数据：无论是插入字符后得到"AABC","ABBC"还是"ABCC"都最多消除2个字符。
 */
public class ClearCharacter_1039 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        String[] datas = new String[num];
        for (int i = 0; i < num; i++) {
            String str = in.next();
            datas[i] = str;
        }
        for (int i = 0; i < num; i++) {
            char[] chars = datas[i].toCharArray();
            System.out.println(getMaxCount(chars));
        }
    }

    /**
     * 递归方式
     * @param str
     * @return
     */
    public static String clearCharacter(String str) {
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        char curChar;
        char nextChar;
        char sameChar = '\0';
        boolean isNoSameChar = true;
        if (chars.length != 0) {
            for (int i = 0; i < chars.length - 1; i++) {
                curChar = chars[i];
                nextChar = chars[i + 1];
                if (curChar != nextChar && curChar != sameChar) {
                    sb.append(curChar);
                    sameChar = '\0';
                } else {
                    sameChar = curChar;
                    isNoSameChar = false;
                }
            }
            char lastChar = chars[chars.length - 1];
            if (lastChar != sameChar) {
                sb.append(lastChar);
            }
        }
        return isNoSameChar ? str : clearCharacter(sb.toString());
    }

    /**
     * 非递归循环方式
     * @param str
     * @return
     */
    public static String clearCharacter_v2(String str) {
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        char curChar;
        char nextChar;
        char sameChar;
        boolean isNoSameChar;
        while (true) {
            isNoSameChar = true;
            sameChar = '\0';
            for (int i = 0; i < chars.length - 1; i++) {
                curChar = chars[i];
                nextChar = chars[i + 1];
                if (curChar != nextChar && curChar != sameChar) {
                    sb.append(curChar);
                    sameChar = '\0';
                } else {
                    sameChar = curChar;
                    isNoSameChar = false;
                }
            }
            char lastChar = chars[chars.length - 1];
            if (lastChar != sameChar) {
                sb.append(lastChar);
            }
            if (isNoSameChar) {
                return new String(chars);
            } else {
                final char[] newChars = sb.toString().toCharArray();
                if (newChars.length == 0) {
                    return "";
                }
                chars = newChars;
                sb.delete(0, sb.length());
            }
        }
    }

    /**
     * 统计消除的字符数量
     * @param chars
     * @return
     */
    public static int countClearCharacter(char[] chars) {
        StringBuilder sb = new StringBuilder();
        char curChar;
        char nextChar;
        char sameChar;
        boolean isNoSameChar;
        int count = 0;
        while (true) {
            isNoSameChar = true;
            sameChar = '\0';
            for (int i = 0; i < chars.length - 1; i++) {
                curChar = chars[i];
                nextChar = chars[i + 1];
                if (curChar != nextChar && curChar != sameChar) {
                    sb.append(curChar);
                    sameChar = '\0';
                } else {
                    sameChar = curChar;
                    isNoSameChar = false;
                }
            }
            char lastChar = chars[chars.length - 1];
            if (lastChar != sameChar) {
                sb.append(lastChar);
            }
            if (isNoSameChar) {
                break;
            } else {
                final char[] newChars = sb.toString().toCharArray();
                count += chars.length - newChars.length;
                if (newChars.length == 0) {
                    break;
                }
                chars = newChars;
                sb.delete(0, sb.length());
            }
        }
        return count;
    }

    public static int getMaxCount(char[] chars) {
        List<Integer> countList = new ArrayList<>();
        // 穷举法，将每种插入的可能性都计算出来然后选取最大值
        for (int i = 0; i < chars.length; i++) {
            for (char c = 'A'; c < 'D'; c++) {
                countList.add(countClearCharacter(insertChar(chars, c, i)));
            }
        }
        return Collections.max(countList);
    }

    public static char[] insertChar(char[] chars, char c, int i) {
        char[] newChars = new char[chars.length + 1];
        if (i == 0) {
            newChars[0] = c;
            System.arraycopy(chars, 0, newChars, 1, chars.length);
        } else if (i == chars.length - 1) {
            newChars[newChars.length - 1] = c;
            System.arraycopy(chars, 0, newChars, 0, chars.length);
        } else {
            newChars[i] = c;
            System.arraycopy(chars, 0, newChars, 0, i);
            System.arraycopy(chars, i, newChars, i + 1, chars.length - i);
        }
        return newChars;
    }

}
