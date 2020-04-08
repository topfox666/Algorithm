/**
 *  A:阿里
 *  B：优先队列
 *  C：小强的养鸡场
 *  D：有n个养鸡场，第i个养鸡场初始有a[i]只小鸡，每个养鸡场每天会增加k只鸡
 *     每天结束会把养鸡场即最多的卖一半，剩x/2向下取整，
 *     m天后小强的n个养鸡场有多少只鸡
 *  E：第一行n,m,k；第二行n个真正书分别表示初始鸡；1<=m、n<=100000，1<=k<=10000,1<=a[i]<=100000
 *  F: 用优先队列来保存鸡的数量，应当保存加了k天后的，使所有机场在同一起跑线上。
 */

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int k=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        //优先队列，堆顶是鸡最多的。
        PriorityQueue<Integer> heap=new PriorityQueue<>(Collections.reverseOrder());
        for(int j: a){
            heap.offer(j+m*k);
        }
        for(int i=m;i>0;i--){
            int curMax=heap.poll();
            //本该剩下的
            int shallRemain=(curMax-i*k)/2+k/2;
            //现在剩下的
            int butRemain=(curMax-(i-1)*k);
            //扣除
            curMax=curMax-(butRemain-shallRemain);
            heap.offer(curMax);
        }
        int count=0;
        for(int i=0;i<n;i++){
            count+=heap.poll();
        }
        System.out.println(count);
    }
}