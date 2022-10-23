class Solution {
    int count(int[] arr, int n, int x) {
        
        int count = 0;
        
        for(int i = 0; i < n; i++) {
            if(arr[i] == x)
                count++;
        }
        
        return count;
    }
}

//TC: O(N)
//SC: O(1)

//Naive Solution

/* ------------------------------------------------------------------- */

class Solution {
    int count(int[] arr, int n, int x) {
        int index = binarySearch(arr, n, x);
        
        if(index == -1)
            return 0;
            
        int count = 1;
        
        int left = index-1;
        while(left >= 0 && arr[left] == x) {
            count++;
            left--;
        }
        
        int right = index+1;
        while(right < n && arr[right] == x) {
            count++;
            right++;
        }
        
        return count;
    }
    
    private int binarySearch(int[] arr, int n, int x) {
        int i = 0, j = n-1;
        
        while(i <= j) {
            int mid = i+(j-i)/2;
            
            if(arr[mid] == x)
                return mid;
            else if(arr[mid] < x)
                i = mid+1;
            else
                j = mid-1;
        }
        
        return -1;
    }
}

//TC: O(log N)
//SC: O(1)

//Optimal Solution
