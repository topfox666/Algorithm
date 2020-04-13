import java.util.Scanner;

/**
 * A:快手
 * B:安排位置
 * C:回溯
 * D:给一个数组，*表示不能坐人，.表示能做人，疫情期间人与人不能坐在一起，就是左右前后不能是人，问一共能坐最多几个人
 * E:input :{{'.','.'},{'.','.'}}  output：2
 * F:回溯算法，在每次位置合法时选择坐与不坐，先走完行再走下一行，每次到底判断num是否大于max
 */
public class Kuaishou4{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        char[][] c=new char[][]{{'.','.'},{'.','.'}};
        pNum(c,0,0,0);
        System.out.println(max);
    }
    static int max=0;
    static void pNum(char[][] c,int x,int y,int num){
       int row=c.length;
       int col=c[0].length;
       if(y>=col){
           //如果在最后一行，那么就是这一遍到底了
           if(x>=row-1){
           max=Math.max(max,num);
           return;
           }
           //如果不是到下一行
           else
               pNum(c,x+1,0,num);
       }
       else if(c[x][y]=='*' || !isValid(c,x,y))
           pNum(c,x,y+1,num);
       else{
           num++;
           c[x][y]='!';
           pNum(c,x,y+1,num);  //先向col方向移动，进行一行一行的遍历
           //回溯，删掉刚刚的操作
           num--;
           c[x][y]='.';
           pNum(c,x,y+1,num);
       }
    }
    static boolean isValid(char[][] c,int x,int y){
        if(x-1>=0 && c[x-1][y]=='!') return false;
        if(y-1>=0 && c[x][y-1]=='!') return false;
        if(y+1<=c[0].length-1 && c[x][y+1]=='!') return false;
        if(x+1<=c.length-1 && c[x+1][y]=='!') return false;
        return true;
    }
}