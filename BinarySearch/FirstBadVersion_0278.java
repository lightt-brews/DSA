package BinarySearch;
class VersionControl {

    private int firstBadVersion;

    public VersionControl(int firstBadVersion) {
        this.firstBadVersion = firstBadVersion;
    }

    public boolean isBadVersion(int version) {
        return version >= firstBadVersion;
    }
}

public class FirstBadVersion_0278 extends VersionControl{
    public FirstBadVersion_0278(int firstBad) {
        super(firstBad);
    }

    public int firstBadVersion(int n) {
        int left = 1;
        int right= n;
        while(left <right){
            int mid = left+(right-left)/2;
            if(isBadVersion(mid)){
                right = mid;
            }
            else{
                left = mid+1;
            }
        }
        return left;
    }

    public static void main(String[] args){
        FirstBadVersion_0278 s = new FirstBadVersion_0278(1702766719); // Version 4 is the first bad version
        System.out.println(s.firstBadVersion(2126753390));  // Output: 4
    }
}