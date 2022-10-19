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
  
  

class Solve {
    int[] findTwoElement(int nums[], int n) {
		long miss = 0;
		long dup = 0;

		long sum = (n*(n+1))/2; //get sum from 1 to n (1 + 2 + .... + n)
		long power = (n*(n+1) * (2*n+1))/6;//get squre sum from 1 to n (1^2 + 2^2 + .... + n^2)

		for(int i = 0; i < n; i++) {
			sum -= (long)nums[i];
			power -= (long)(nums[i] * nums[i]);
		}

		miss = (sum + power/sum)/2;
		dup = miss-sum;

		return new int[] {(int)dup, (int)miss};
    }
}

// TC: O(N)
// SC: O(1)
// Optimal Solution using Math trick
