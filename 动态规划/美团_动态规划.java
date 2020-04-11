/**
 * A:美团
 * B:走金字塔
 * C:动态规划
 * D:从金字塔（四面体）的一个点走到另一个点算1步，问K步之后到原点的走法有几种
 * E:input : 3 ; output : 6
 * F:动态规划，dp[k][j]表示走k步到j点（假设原点为0，其他三个点是1,2,3）
 *            的走法一共有dp[k][j]种。
 *            那么dp[0][0]走0步到编号0有1种；dp[0][1]走0步到编号1有1种……
 *               dp[1][0]=0 dp[1][1]=1 dp[1][2]=1,由于dp[][1,2,3]是一样的值，所以存一个就好
 *               dp[k][0]=dp[k-1][1]+dp[k-1][2]+dp[k-1][3]=3*dp[k-1][1];
 *               dp[k][1]=dp[k-1][0]+2*dp[k-1][1]
 */

import java.util.Scanner;

public class Golden {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int k=sc.nextInt();
        //距离只有两种，距离0，距离1
        int[][] dp=new int[1000001][2];
        dp[0][0]=1;
        dp[0][1]=0;
        dp[1][0]=0;
        dp[1][1]=1;
        for(int i=2;i<=k;i++){
            dp[i][0]=3*dp[i-1][1];
            dp[i][1]=dp[i-1][0]+2*dp[i-1][1];
        }
        System.out.println(dp[k][0]);
    }
}
