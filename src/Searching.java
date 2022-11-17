import java.util.Scanner;

public class Searching {
    // finding element in rotated array(O(log n))

    public class Main {
        public static int searchOfE(int[] a, int t) {
            int start = 0;
            int end = a.length - 1;
            if (start > end) return -1;
            int p = findingPivot(a, start, end);
            System.out.println("p:" + p);
            if (p == -1) return binarySearch(a, start, end, t);//not rotated
            if (a[p] == t) return p;
            // dividing at p to form two subarrays and search
            //for(search in left sub array)
            if (a[start] <= t) return binarySearch(a, start, p - 1, t);
            return binarySearch(a, p + 1, end, t);
        }

        public static int findingPivot(int[] a, int start, int end) {
            if (start > end) return -1;//base case
            if (start == end) return start;
            int mid = start + (end - start) / 2;
            if (mid < end && a[mid] > a[mid + 1]) {
                return mid;
            }
            if (mid > start && a[mid] < a[mid - 1]) {
                return mid - 1;
            }
            if (a[start] >= a[mid]) {
                return findingPivot(a, start, mid - 1);
            }
            return findingPivot(a, mid + 1, end);
        }

        public static int binarySearch(int[] a, int start, int end, int t) {
            if (start > end) return -1;//base case
            int mid = start + (end - start) / 2;
            System.out.println("b:" + mid);
            if (a[mid] == t) return mid;
            if (a[mid] >= t) return binarySearch(a, start, mid - 1, t);
            return binarySearch(a, mid + 1, end, t);
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int m = sc.nextInt();
            int t = sc.nextInt();
            int[] a = new int[m];
            for (int i = 0; i < m; i++) {
                a[i] = sc.nextInt();
                ;
            }
            System.out.println(searchOfE(a, t));
        }
    }
}
