// binary search

class Solution {
    public int search(int[] a, int target) {
        //if(a.length==0) return -1;
        int l=0; int r=a.length-1; //int mid=0;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(a[mid]==target) return mid;
            else if(a[mid]<target) l=mid+1;
            else r=mid-1;
        }
        return -1;
    }
}