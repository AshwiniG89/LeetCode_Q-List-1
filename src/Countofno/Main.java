package Countofno;

import java.util.Scanner;

// count of no. of values with the target
public class Main
{
    public static int presenceOfT(int[] a, int t){
        // int[] ans=new int[2];
        int m=firstOccu(a,t);
        int n=lastOccu(a,t);
        int count=m+n;
        return count;
    }
    public static int firstOccu(int[] a,int t){
        int l=0; int r=a.length-1; int res=-1; int count=0;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(a[mid]>t) {r=mid-1;}
            else if(a[mid]<t) {l=mid+1;}
            else {res=mid; count++;//System.out.println(mid);
                r=mid-1;}
            System.out.println("f:"+count);
        }
        return count;
    }
    public static int lastOccu(int[] a,int t){
        int l=0; int r=a.length-1; int res=-1; int count=0;
        if(firstOccu(a,t)>=1){ count=-1;}
        while(l<=r){
            int mid=l+(r-l)/2;
            if(a[mid]>t) {r=mid-1;}
            else if(a[mid]<t) {l=mid+1;}
            else {res=mid; count++;
                l=mid+1;}
            System.out.println("l:"+count);
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int t=sc.nextInt();
        int[] a=new int[m];

        for(int i=0;i<m;i++){
            a[i]=sc.nextInt();;
        }

        System.out.println(presenceOfT(a,t));
    }
}