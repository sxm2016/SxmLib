package com.xxx.commonlib.util.text.rename;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by shixm on 2016/11/18.
 */
public class RenameString {
    /**
     * 判断是否为中文字符
     */
    private static boolean isChineseChar(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
            return true;
        }
        return false;
    }

    /**
     * 输入是否合法（规定"英文"、"汉字"、"数字"、"."为合法输入）
     *
     * @param str
     * @return
     */
    public static boolean isInputLegal(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        } else {
            String regEx = "[\u4e00-\u9fa5\\w\\.]+";
            Pattern p = Pattern.compile(regEx);
            Matcher ma = p.matcher(str);
            return ma.matches();
        }
    }

    /**
     * 得到字节数，需求规定汉字占两个字节，其它占一个字节
     *
     * @param str 汉字、英文和数字组成的字符串
     * @return
     */
    public static int getTotalBytes(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        } else {
            int count = 0;
            for (int i = 0; i < str.length(); i++) {
                if (isChineseChar(str.charAt(i))) {
                    count += 2;
                } else {
                    count++;
                }
            }
            return count;
        }
    }

    /**
     * 得到字节总数为totalBytesLen的位置
     *
     * @param str 汉字、英文和数字组成的字符串
     * @param totalBytesLen 字节数
     * @return
     */
    public static int getIndexOfTotalBytesLen(String str, int totalBytesLen) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        } else {
            int count = 0;
            for (int i = 0; i < str.length(); i++) {
                if (isChineseChar(str.charAt(i))) {
                    count += 2;
                } else {
                    count++;
                }
                if (count > totalBytesLen) {
                    return i;
                }
            }
            return 0;
        }
    }
}
