/**
 * A:力扣
 * B:鸡蛋掉落
 * C:动态规划
 * D:你有K个鸡蛋，N层楼，存在F楼高于F都会碎低于F都不碎，最小移动次数
 * E: input: K=1,N=2 ;output: 2
 * F: 假设k个鸡蛋扔m次最多能确定几层楼，dp[k][m]表示层数；
 *    dp[k][m]=1+dp[k][m-1]+dp[k-1][m-1],
 *    初始化所有能确定的楼数为0，一直到算出K个鸡蛋最多能确定N层，得到m就是最少扔鸡蛋次数
 */

public class Solution {
    public int superEggDrop(int K, int N) {
        //初始化所有能确定的楼数都是0
        int[][] dp=new int[K+1][N+1];
        int m=0;
        //当能确定的楼数还少于N，说明还得继续移动
        while(dp[K][m]<N){
            m++;
            for(int k=1;k<=K;k++){
            dp[k][m]=1+dp[k][m-1]+dp[k-1][m-1];}
        }
        return m;
    }
}
