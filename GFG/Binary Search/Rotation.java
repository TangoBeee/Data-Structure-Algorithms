class Solution {
    int findKRotation(int arr[], int n) {
        for(int i = 0; i < n-1; i++) {
            if(arr[i] > arr[i+1])
                return i+1;
        }
        
        return 0;
    }
}

//TC: O(N)
//SC: O(1)

//Naive Solution ^^

/* -------------------------------------------------------------------------- */

class Solution {
    int findKRotation(int nums[], int n) {
        int i = 0, j = n-1;
        
        while(i < j) {
            int mid = i+(j-i)/2;
            
            if(nums[j] < nums[mid])
                i = mid+1;
            else
                j = mid;
        }
        
        return i;
    }
}

//TC: O(log N)
//SC: O(1)

//Optimal Solution ^^
