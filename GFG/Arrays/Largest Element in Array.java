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
