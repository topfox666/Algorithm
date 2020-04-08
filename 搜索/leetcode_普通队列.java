/**
 *    A:力扣
 *    B:广度优先搜索
 *    C:地图分析
 *    D:有个N*N的地图，每个区域用0和1标记，0是海洋，1是陆地，求海洋区域离陆地距离最远的值
 *    E：input:[[1,0,1],[0,0,0],[1,0,1]]   output:2
 *    F：1.用队列保存需要广度遍历的数据；2、添加所有陆地，再去遍历陆地旁边海洋，把他们添加；
 *       3.每次遍历都要一次性拿出同一层的所有节点进行扩展
 **/
import java.util.*;
class Solution {
    public int maxDistance(int[][] grid) {
        int N=grid.length;
        //广度优先用队列，先进先出扩展。
        Queue<int[]> q=new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    q.add(new int[]{i, j});
                }
            }
        }
        if(q.size()==N*N || q.isEmpty()) return -1;
        int res=-1;
        while(!q.isEmpty()){
            res++;
            //该层有多少个节点
            int n=q.size();
            //把这些节点一次性取出来并扩展
            for(int i=0;i<n;i++){
                int[] temp=q.poll();
                int row=temp[0];
                int col=temp[1];
                if( row-1>=0 && grid[row-1][col]==0){
                    grid[row-1][col]=2;
                    q.add(new int[]{row-1,col});
                }
                if(row+1<N && grid[row+1][col]==0 ){
                    grid[row+1][col] =2;
                    q.add(new int[]{row+1,col});
                }
                if(col-1>=0 && grid[row][col-1]==0  ){
                    grid[row][col-1] =2;
                    q.add(new int[]{row,col-1});
                }
                if(col+1<N && grid[row][col+1]==0){
                    grid[row][col+1]=2;
                    q.add(new int[]{row,col+1});
                }
            }
            }
        }
        return res;

    }
}