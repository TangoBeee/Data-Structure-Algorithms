class Solution {
    int median(int matrix[][], int R, int C) {
        int[] arr = new int[R*C];
        int k = 0;
        
        for(int[] i : matrix) //---|
                             //     ---> O(N*M)
            for(int j : i)    //---|
                arr[k++] = j;
        
        Arrays.sort(arr); // O(log N*M)
        
        return arr[(R*C)/2];
    }
}

//TC: O(N*M (log N*M))
//SC: O(N*M)

//Naive Solution ^^

/* --------------------------------------------------------------------------- */


class Solution {
    int median(int matrix[][], int R, int C) {
        int low = minFinder(matrix);
        int high = maxFinder(matrix);
        
        int minNumbers = ((R*C)/2)+1;
        
        while(low <= high) {
            int mid = (low+high) >>> 1;
            int numCount = numberOfElements(matrix, mid);
            
            if(numCount >= minNumbers)
                high = mid-1;
            else
                low = mid+1;
        }
        
        return low;
    }
    
    //Finding how many numbers are smaller or equal(because in matrix we have duplicate numbers) then target.
    private int numberOfElements(int[][] mat, int target) {
        int count = 0;
        
        for(int[] i : mat) {
            for(int j : i) {
                if(j <= target)
                    count++;
            }
        }
        
        return count;
    }
    
    //Finding smallest element in matrix
    private int minFinder(int[][] mat) {
        int min = Integer.MAX_VALUE;
        
        for(int[] i : mat) {
            for(int j : i) {
                min = j <= min ? j : min;
            }
        }
        
        return min;
    }
    
    //Finding largest element in the matrix
    private int maxFinder(int[][] mat) {
        int max = Integer.MIN_VALUE;
        
        for(int[] i : mat) {
            for(int j : i) {
                max = j >= max ? j : max;
            }
        }
        
        return max;
    }
}

//TC: O(32 * R * log(C))
//SC: O(1)

//Optimal Solution ^^
