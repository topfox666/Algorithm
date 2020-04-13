
import java.util.*;

/**
 * A:快手
 * B:求最完美幂因子
 * C:数学问题
 * D:给定一个数和进制，问是否完美，完美返回序列
 * E: input :39,3 output: 1,2,3: 因为39=3^3+3^2+3
 * F:不断地除以进制，如果不等于1说明不完美，你可以试一下，找找规律和感觉
 */

public class Kuaishou2 {
    public static void main(String[] args) {
        Kuaishou2 k=new Kuaishou2();
        for(int i:k.GetPowerFactor(39,3)){
            System.out.println(i);
        }
    }
    /**
     * 返回无重复幂因子的 N进制完美数之和的所有幂因子
     * @param R int整型
     * @param N int整型 N进制
     * @return int整型一维数组
     */
    public int[] GetPowerFactor (int R, int N) {
        // write code here
        int count=0;
        List<Integer> list=new ArrayList<>();
        while(R/N>0){
             count++;
             if(R%N>1) return new int[]{};
             if(R%N==1){
                 list.add(count-1);
             }
             R=R/N;
        }
        list.add(count);
        int[] result=new int[list.size()];
        for(int i=0;i<list.size();i++){
            result[i]=list.get(i);
        }
        return result;
    }
}
