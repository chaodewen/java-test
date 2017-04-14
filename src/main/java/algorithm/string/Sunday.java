package algorithm.string;

/**
 * Created by Cc on 2017/4/15.
 */

/**
 * i指txt,j指pat
 * 匹配失败时考虑i+pat.length()字符在pat中有没有出现
 * 没出现考虑再下一个字符
 * 出现则找到最后一个出现位置,然后对齐这个位置到该字符,尝试匹配
 */
public class Sunday {
    public static int sundaySearch(String txt, String pat) {
        int txtLength = txt.length(), patLength = pat.length();

        for(int i = 0, j, skip = -1; i < txtLength - patLength + 1; i += skip) {
            for(j = 0; j < patLength; j ++)
                if(txt.charAt(i + j) != pat.charAt(j)) {
                    if(i + patLength < txtLength) // 判断有没有需要判断的下一个合法字符
                        skip = patLength - getIndex(pat, txt.charAt(i + patLength));
                    break;
                }

            if(j == patLength)
                return i;
        }

        return -1;
    }
    private static int getIndex(String pat, char c) {
        for(int i = pat.length() - 1; i >= 0; i --) // 对pat从后往前匹配
            if(pat.charAt(i) == c)
                return i;

        return -1;
    }

    public static void main(String[] args) {
        String txt = "BBC ABCDAB AACDABABCDABCDABD";
        String pat = "ABCDABD";
        System.out.println(sundaySearch(txt, pat));
    }
}