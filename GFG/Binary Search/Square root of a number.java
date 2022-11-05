class Solution
{
     long floorSqrt(long x)
	 {
		// Your code here
		return (long)Math.sqrt(x);
	 }
}

//TC: O(log x) <i'm not sure>
//SC: O(1)

//Naive Solution ^^

/* ------------------------------------------------------------------------------ */

class Solution
{
     long floorSqrt(long x)
     {
        // Your code here
        long result = 1, i = 1;
        
        while(result <= x) {
            i++;
            
            result = i*i;
        }
        
        return i-1;
     }
}

//TC: O(√x)
//SC: O(1)

//Better Solution ^^


/* ------------------------------------------------------------------------------ */

class Solution
{
     long floorSqrt(long x)
     {
        // Your code here
        long low = 1, high = x;
        long ans=0;
        
        while(low <= high) {
            long mid = (low+high) >>> 1;
            
            if((mid*mid) == x)
                return mid;
                
            else if((mid*mid) > x)
                high = mid-1;
                
            else {
                low = mid+1;
                ans = mid;
            }
        }
        
        return ans;
     }
}

//TC: O(log N)
//SC: O(1)

//Optimal Solution ^^
