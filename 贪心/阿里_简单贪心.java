/**
 * A:阿里
 * B:打怪
 * C:贪心
 * D:小强特训时间n秒，有m个木头人，每个人血量a，小强的攻击范围b，每次最多对b个存活的木头人造成1点伤害，每次攻击1s，当木头人血量为0，死亡。最多消灭几个人？
 * E:input:1;5 5 2 2 ; output:5
 * F:每次都用b,注意要比较时间和血量，若时间本来就小于血量那无法打败怪兽，因为一次只能伤害一个点。
 */

import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            T--;
            long n = sc.nextInt();
            long m = sc.nextInt();
            long a = sc.nextInt();
            long b = sc.nextInt();
            if (n < a) {
                System.out.println(0);
            } else {
                long sum = n * b;
                long res = sum / a;
                System.out.println(Math.min(res, m));
            }
        }
    }
}