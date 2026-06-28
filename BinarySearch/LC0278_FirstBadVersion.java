package BinarySearch;

// This part is a solution to the LeetCode problem "First Bad Version" (Problem 278). 
// The code defines a class `VersionControl` that simulates the behavior of checking if a version is bad.
//  The `FirstBadVersion_0278` class extends `VersionControl` and implements a binary search algorithm to find the first bad version among a range of versions.


class VersionControl {

    private int firstBadVersion;

    public VersionControl(int firstBadVersion) {
        this.firstBadVersion = firstBadVersion;
    }

    public boolean isBadVersion(int version) {
        return version >= firstBadVersion;
    }
}

class LC0278_FirstBadVersion extends VersionControl {
    public LC0278_FirstBadVersion(int firstBad) {
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
        LC0278_FirstBadVersion s = new LC0278_FirstBadVersion(1702766719); 
        System.out.println(s.firstBadVersion(2126753390)); 
    }
}