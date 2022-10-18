class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long inversionCount(long nums[], long n)
    {
        long ans = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                if(i < j && nums[i] > nums[j]) {
                    ans++;
                }
            }
        }
    
        return ans;
    }
}

// TC: O(N^2)
// SC: O(1)

// Naive Solution

---------------------------------------------------------------------------
  
