/* In this approach we will sort the array and get the last element of the array which will be largest element of the array */

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

/* In this approach we will linearly iterate from 0 to n and store the largest element in the var using 'Math.max()' function */

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
