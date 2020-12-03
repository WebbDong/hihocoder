package com.hihocoder.level1;

import java.util.Scanner;

/**
 * fjxmlhx每天都在被沼跃鱼刷屏，因此他急切的找到了你希望你写一个程序屏蔽所有句子中的沼跃鱼(“marshtomp”，不区分大小写)。
 * 为了使句子不缺少成分，统一换成 “fjxmlhx” 。
 *
 * 输入
 *      输入包括多行。
 *      每行是一个字符串，长度不超过200。
 *      一行的末尾与下一行的开头没有关系。
 *
 * 输出
 *      输出包含多行，为输入按照描述中变换的结果。
 *
 * 样例输入
 *      The Marshtomp has seen it all before.
 *      marshTomp is beaten by fjxmlhx!
 *      AmarshtompB
 *
 * 样例输出
 *      The fjxmlhx has seen it all before.
 *      fjxmlhx is beaten by fjxmlhx!
 *      AfjxmlhxB
 */
public class TheMarshtompHasSeenItAllBefore_1082 {

    private static final String KEY_WORD = "marshtomp";

    private static final String REPLACE_WORD = "fjxmlhx";

    private static final int KEY_WORD_LENGTH = KEY_WORD.length();

    private static final int REPLACE_WORD_LENGTH = REPLACE_WORD.length();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            System.out.println(replaceLine(line));
        }
//        System.out.println(replaceLine("AmarshtompB"));
//        System.out.println(replaceWord("AmarshtompB", 1));
    }

    public static String replaceLine(String line) {
        String[] words = line.split(" ");
        StringBuilder sb = new StringBuilder(words.length);
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int startIndex = word.toLowerCase().indexOf(KEY_WORD);
            if (startIndex != -1) {
                sb.append(replaceWord(word, startIndex));
            } else {
                sb.append(word);
            }
            if (i != words.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static char[] replaceWord(String word, int startIndex) {
        char[] chars = word.toCharArray();
        char[] newChars = new char[REPLACE_WORD_LENGTH + chars.length - KEY_WORD_LENGTH];
        int i = 0;
        for (; i < startIndex; i++) {
            newChars[i] = chars[i];
        }
        for (int j = 0; j < REPLACE_WORD.length(); j++, i++) {
            newChars[i] = REPLACE_WORD.charAt(j);
        }
        for (int j = startIndex + KEY_WORD.length(); j < chars.length; j++, i++) {
            newChars[i] = chars[j];
        }
        return newChars;
    }

}
