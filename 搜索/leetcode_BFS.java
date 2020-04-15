/**
 * A:力扣
 * B:矩阵
 * C:BFS
 * D:给一个由0,1构成的矩阵，求每个元素和0最近的距离
 * E:input 0,1,1,1 output:0,1,1,2
 * F:用队列记录每个可达点的思维。
 */

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0)
                    q.offer(new int[]{i,j});    //将0入队
                else
                    matrix[i][j]=-1;
            }
        }

        int[] dx=new int[] {-1,1,0,0};
        int[] dy=new int[]{0,0,-1,1};
        while(!q.isEmpty()){
            int[] point=q.poll();
            int x=point[0],y=point[1];
            for(int i=0;i<4;i++){
                int newX=x+dx[i];
                int newY=y+dy[i];
                if(newX>=0 && newX<matrix.length && newY>=0 && newY<matrix[0].length && matrix[newX][newY]==-1){
                    matrix[newX][newY]=matrix[x][y]+1;
                    q.offer(new int[]{newX,newY});
                }
            }
        }
        return matrix;

    }
}
