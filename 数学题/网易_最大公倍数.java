/**
 *    A:网易
 *    B:数学题（最大公倍数）
 *    C:牛牛的等差数列
 *    D:一个长度为n的数组，找一个最大的正整数d，对所有的i(1<=i<n)
 *        i之间的差是d的倍数。
 *    E：第一行输入长度n，第二行n个正整数；如果d不存在输出-1否则输出最大的d
 *    F：1.保存数组中所有元素的差，可以原地存储；2、求差的最大公倍数。
 **/
public class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long[] a=new long[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextLong();
        }
        //原地存储差
        for(int i=0;i<n-1;i++){
            a[i]=a[i+1]-a[i];
        }
        //算每个差的最大公倍数
        long d=gcd(a[0],a[1]);
        for(int i=1;i<n-1;i++){
            d=gcd(a[i],d);
        }
        if(d==1){d=-1;}
        System.out.println(d);

    }
    public static long gcd(long a,long b){
        if(b==0) {return a;}
        return a%b==0?b:gcd(b,a%b);
    }
}