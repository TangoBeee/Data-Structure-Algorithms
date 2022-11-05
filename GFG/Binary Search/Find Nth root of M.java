class Solution
{
    public int NthRoot(int n, int m)
    {
        int low = 0, high = m;
        
        while(low <= high) {
            int mid = (low+high) >>> 1;
            
            double temp = Math.pow(mid, n);
            
            if(temp == m)
                return mid;
                
            else if(temp > m)
                high = mid-1;
            else
                low = mid+1;
        }
        
        return -1;
    }
}

//TC: O(N * log(M))
//SC: O(1)

//Optimal Solution ^^
