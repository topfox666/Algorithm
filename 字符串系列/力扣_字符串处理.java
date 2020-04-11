package com.topfox.dao;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author foxChen
 * A:力扣
 * B:反转字符串里的单词
 * C:字符串的反转、过滤、拼接操作
 * D:直接看例子（多余的空格要删除，结果用空格分割单词）
 * E:input:  "the sky is blue"  output:"blue is sky the"
 */
public class Solution {
    public String reverseWords(String s){
        //除去首末的空格；
        s=s.trim();
        //以连续的空格为分割符号，把字符串分割并存处于list
        List<String> wordList= Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        //用空格连接
        return String.join(" ",wordList);
    }
}
