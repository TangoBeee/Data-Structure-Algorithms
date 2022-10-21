class Compute {
    
    public int largest(int arr[], int n)
    {
        Arrays.sort(arr);
        
        return arr[n-1];
    }
}

// TC : O(N logN)
// SC : O(1)

//Naive Solution

/* --------------------------------------------------------------------- */

class Compute {
    
    public int largest(int arr[], int n)
    {
        int ans = 0;
        
        for(int i = 0; i < n; i++) {
            ans = Math.max(ans, arr[i]);
        }
        
        return ans;
    }
}

// TC: O[n] 
// SC: O[1]

//Optimal Solution
