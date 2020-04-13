import java.util.Scanner;

/**
 * A:快手
 * B:括号匹配
 * C:没啥结构
 * D:输入一个表达式，生成匹配括号的对数，左括号个数，右括号个数
 * E:input :(6+33-8)*10()((()
 * F:跟表达式没太大关系，匹配括号就好
 */


public class Kuaishou1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        char[] array=s.toCharArray();
        int match=0;
        int left=0;
        int right=0;
        int temp=0;
        for(char c:array){
            if(c=='(') {
                temp++;
                left++;
            }
            if(c==')'&& temp>0) {
                temp--;
                match++;
                right++;
                continue;
            }
            if(c==')'&& temp<=0){
                right++;
            }
        }
        left=left-match;
        right=right-match;
        System.out.println(match+" "+left+" "+right);
    }
}
