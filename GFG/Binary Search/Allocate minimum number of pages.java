class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M) {
        if(N < M)
            return -1;
        int low = A[0], high = 0;
        
        for(int i : A) {
            low = Math.min(i, low);
            high += i;
        }
        
        int ans = -1;
        
        while(low <= high) {
            int mid = (low+high) >>> 1;
            
            if(minAllocation(A, mid, M)) {
                ans = mid;
                high = mid-1;
            }
            
            else
                low = mid+1;
        }
        
        return ans;
    }
    
    private static boolean minAllocation(int[] nums, int minBooks, int stud) {
        
        int sum = 0, book = 0;
        
        for(int i : nums) {
            if((sum + i) > minBooks) {
                book++;
                sum = i;
                if(sum > minBooks)
                    return false;
            }
            
            else 
                sum += i;
        }
        
        if(book < stud)
            return true;
        return false;
        
    }
}

//TC: O(N*log(M)) where n is length of the array and m is sum of all elements in array(high)
//SC: O(1)

//Optimal Solution
