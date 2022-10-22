class Solution{
    
    static int findFloor(long arr[], int n, long x) {
        int res = -1;
        
        for(int i = 0; i < n; i++) {
            if(arr[i] <= x) 
                res = i;
        }
        
        return res;
    }
    
}

//TC: O(N)
//SC: O(1)

//Naive Solution ^^

/* ---------------------------------------------------------------------------------- */

class Solution{
  
    static int findFloor(long arr[], int n, long x) {
        int i = 0, j = n-1;
        long res = -1;
        
        while(i <= j) {
            int mid = (i+j)/2;
            if(arr[mid] <= x) {
                res = mid;
                i++;
            }
            else if(arr[mid] < x) {
                i = mid+1;
            }
            else
                j = mid-1;
        }
        
        return (int)res;
    }
    
}

// TC: O(log N)
// SC: O(1)

// Optimal Solution
