package algorithm.string;

/**
 * Created by Cc on 2017/4/15.
 */

/**
 * i指txt,j指pat
 * 匹配失败时考虑i+patLength字符在pat中有没有出现
 * 没出现考虑再下一个字符
 * 出现则找到最后一个出现位置,然后对齐这个位置到该字符,尝试匹配
 */
public class Sunday {
    public static int sundaySearch(String txt, String pat) {
        int txtLength = txt.length(), patLength = pat.length();

        for (int i = 0, j, skip = -1; i < txtLength - patLength + 1; i += skip) {
            for (j = 0; j < patLength; j++)
                if (txt.charAt(i + j) != pat.charAt(j)) { // 找到不匹配的字母 向后跳
                    skip = patLength - getIndex(pat, txt.charAt(i + patLength)); // 根据i+patLength的字母进行匹配
                    break;
                }

            if (j == patLength) // 遍历未break 说明正常匹配
                return i;
        }

        return -1;
    }

    // 找到pat中最后面的c
    private static int getIndex(String pat, char c) {
        for (int i = pat.length() - 1; i >= 0; i--) // 对pat从后往前匹配
            if (pat.charAt(i) == c)
                return i;

        return -1;
    }

    public static void main(String[] args) {
        String txt = "BBC ABCDAB AACDABABCDABCDABD";
        String pat = "ABCDABD";
        System.out.println(sundaySearch(txt, pat));
    }
}