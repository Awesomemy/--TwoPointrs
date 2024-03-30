package test1;
/*
给你一个字符串 s ，请你反转字符串中 单词 的顺序。

单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。

返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。

注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。


 */
public class ReverseEachWord {
    public String reverseWords(String s) {
        //字符串移除空格,和数组移除元素类似,都是使用快慢指针,这样可以不使用辅助空间,空间复杂度为O(1)
        //先去多余空格
        StringBuilder sb = removeSpace(s);
        //再反转整个字符串
        reverseString(sb, 0 , sb.length()-1);
        //最后分别反转每个单词
        reverseEachWord(sb);

        return sb.toString();
    }

    //去除字符串中所有不合要求的空格
    private StringBuilder removeSpace(String s){
        int start = 0;
        int end = s.length()-1;
        while (s.charAt(start) == ' ') {
            start++;
        }
        while (s.charAt(end) == ' ') {
            end--;
        }
        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            char c = s.charAt(start);
            if (c != ' ' || sb.charAt(sb.length()-1) != ' ') {
                sb.append(c);
            }
            start++;
        }
        return sb;
    }

    /**
     反转字符串指定区间[start,end]的字符
     */
    private void reverseString(StringBuilder sb , int start , int end){
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }

    //反转字符串中的每个单词
    private void reverseEachWord(StringBuilder sb){
        int start = 0;
        int end = 1;
        while (start < sb.length()) {
            while (end<sb.length() && sb.charAt(end)!=' ') {
                end++;
            }
            reverseString(sb, start, end-1);
            start = end + 1;
            end = start + 1;
        }
    }
}
