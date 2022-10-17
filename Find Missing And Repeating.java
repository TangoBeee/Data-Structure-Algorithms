class Solve {
    int[] findTwoElement(int arr[], int n) {
        int[] nums = new int[n+1];
        
        int dup = 0;
        int miss = 0;
        
        for(int i : arr) {
            nums[i] += 1;
            
            if(nums[i] > 1)
                dup = i;
        }
        
        for(int i = 1; i < n+1; i++) {
            if(nums[i] == 0)
                miss = i;
        }
        
        return new int[] {dup, miss};
    }
}

// TC: O(N)
// SC: O(N)
// Naive Solution

----------------------------------------------------------------------------------
  
  
