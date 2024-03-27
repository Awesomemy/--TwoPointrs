package test1;

/*
给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。

如果剩余字符少于 k 个，则将剩余字符全部反转。
如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 */
public class StringReverse2 {
    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        for(int i=0 ; i<ch.length ; i+=2*k){//不必再i++,一次跨越所需长度即可
            int min = Math.min(i+k-1, ch.length-1);   //翻转长度是否足够两种情况都包含在内
            reverse(ch, i, min);
        }
        return new String(ch);
    }

    public void reverse(char[] ch,int i, int j){
        for(; i<j ; i++,j--){
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
        }
    }
}
