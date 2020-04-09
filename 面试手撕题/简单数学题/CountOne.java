/**
 * 计算一个数字中含有1的个数
 */

import java.util.Scanner;

public class CountOne {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int result=0;
        String nums=String.valueOf(num);
        for(char c:nums.toCharArray()){
           if(c=='1') result++;
        }
        System.out.println("The number of one is "+result);
    }
}
