import java.util.ArrayList;
import java.util.List;

/**
 * A:力扣
 * B:深度优先搜索
 * C:括号生成
 * D:数字n表示生成括号的对数，设计一个函数返回所有有效的括号
 * E:input:n=3   output:[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 * F:深度优先适合解决需要所有组合结果的题目，
 *   dfs用来从根走到叶子，设置好结束的条件让其返回到并列的情况下。
 */
class Solution{
    boolean[][] visited=new boolean[2][3];  //用来记录是否走过
    int m=2,n=3,k=1;
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.generateParenthesis(3));

    }
    List<String> res=new ArrayList<>();
    public List<String> generateParenthesis(int n){
        dfs(n,n,"");
        return res;
    }
    //左括号和右括号个数，当前字符串；
    private void dfs(int left,int right,String curStr){
        //两个括号都不剩下,最深的一层
        if(left==0 & right==0){
            res.add(curStr);   //将结果加入
            return;
        }
        //左边括号只要有剩就可以用
        if(left>0){
            //继续深度优先去考虑用掉一个左括号的情况
            dfs(left-1,right,curStr+"(");
        }
        //如果右括号大于左括号的个数，则可以用；
        //要保证剩下的左括号都有又括号配，也就是剩下的左括号不大于右
        if(right>left){
            dfs(left,right-1,curStr+")");
        }

    }
}