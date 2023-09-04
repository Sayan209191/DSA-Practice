import java.util.HashSet;

public class IntersectionOfTwoArray {
    public static int NumberofElementsInIntersection(int a[], int b[], int n, int m) {
        // Your code here
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=0; i<n; i++) {
            set.add(a[i]);
        }
        
        int count = 0;
        for(int j=0; j<m; j++) {
            if(set.contains(b[j])) {
                count++;
                set.remove(b[j]);
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        int n = 5, m = 3;
        int a[] = {89, 24, 75, 11, 23};
        int b[] = {89, 2, 4};

        System.out.println(NumberofElementsInIntersection(a, b, n, m));
    }
}
