package com.hihocoder.level1;

/**
 * 描述
 * Little Hi gets lost in the city. He does not know where he is. He does not know which direction is north.
 *
 * Fortunately, Little Hi has a map of the city. The map can be considered as a grid of N*M blocks.
 * Each block is numbered by a pair of integers. The block at the north-west corner is (1, 1) and the one at the
 * south-east corner is (N, M). Each block is represented by a character, describing the construction on that block: '.'
 * for empty area, 'P' for parks, 'H' for houses, 'S' for streets, 'M' for malls, 'G' for government buildings, 'T' for trees and etc.
 *
 * Given the blocks of 3*3 area that surrounding Little Hi(Little Hi is at the middle block of the 3*3 area),
 * please find out the position of him. Note that Little Hi is disoriented, the upper side of the surrounding area
 * may be actually north side, south side, east side or west side.
 *
 * 输入
 * Line 1: two integers, N and M(3 <= N, M <= 200).
 * Line 2~N+1: each line contains M characters, describing the city's map. The characters can only be 'A'-'Z' or '.'.
 * Line N+2~N+4: each line 3 characters, describing the area surrounding Little Hi.
 *
 * 输出
 * Line 1~K: each line contains 2 integers X and Y, indicating that block (X, Y) may be Little Hi's position.
 * If there are multiple possible blocks, output them from north to south, west to east.
 *
 * 样例输入
 * 8 8
 * ...HSH..
 * ...HSM..
 * ...HST..
 * ...HSPP.
 * PPGHSPPT
 * PPSSSSSS
 * ..MMSHHH
 * ..MMSH..
 * SSS
 * SHG
 * SH.
 *
 * 样例输出
 * 5 4
 */
public class LostintheCity_1094 {

    public static void main(String[] args) {
    }

}
