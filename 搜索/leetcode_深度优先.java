/**
 * A:力扣
 * B:深度优先搜索
 * C:机器人的运动范围
 * D:地上有一个m行n列的方格，从[0][0]开始移动，每次只能上下左右一格，
 *    也不能进入位数之和大于K的格子，求能到达多少个格子
 * E:input:m=2,n=3,k=1   output:3
 * F:向下面和右边走，深度优先，不行就返回，直到跳出循环。
 */
class Solution{
    boolean[][] visited=new boolean[2][3];  //用来记录是否走过
    int m=2,n=3,k=1;
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.dfs(0,0,0,0));

    }
    //i,j为现在的坐标，si,sj为拆分位的和
    public int dfs(int i, int j, int si, int sj) {
        //大于格子外或者相加超过K或者走过改点了，就返回。
        if(i >= m || j >= n || k < si + sj || visited[i][j]) return 0;
        visited[i][j] = true;    //该点走过
        //否则的话符合要求+1,且向下走:j不变，i要么+1,遇到10的话十位+1个位-9一共-8;向右走；
        return 1 + dfs(i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj) + dfs(i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8);
    }
}