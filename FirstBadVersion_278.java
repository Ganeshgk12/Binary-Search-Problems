package Programs.binarysearch;

public class FirstBadVersion_278 {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(firstBadVersion(n));
    }
    public static int firstBadVersion(int n) {

        int start = 0, end = n, fbv = -1;

        while(start <= end){
            int mid = start + (end - start)/2;
            if(isBadVersion(mid)){
                fbv = mid;
                end = mid - 1;
            }else  start = mid + 1;
        }
        return fbv;
    }

    public static boolean isBadVersion(int n){
        return n >= 3;
    }
    public static int firstBadVersion2(int n) {
        return getBadVer(1,n);
    }

    // ------------------ Recursive Approach ---------------------------------------------
    public static int getBadVer(int s , int e){
        if(s > e) return s;
        int m = s + (e - s)/2;
        if(!isBadVersion(m)) s = m + 1;
        else e = m - 1;
        return getBadVer(s,e);
    }
}
