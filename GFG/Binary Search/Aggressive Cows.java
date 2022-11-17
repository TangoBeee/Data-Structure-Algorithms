class Solution {
    public static int solve(int stalls, int cows, int[] posStalls) {
        Arrays.sort(posStalls);

    	int maxDis = posStalls[stalls-1]-posStalls[0];

    	int ans = 0;

    	for(int d = 1; d <= maxDis; d++) {
    		boolean check = isValid(posStalls, d, cows);

    		if(check) {
    			ans = Math.max(ans, d);
    		}
    	}

    	return ans;
    }

    private static boolean isValid(int[] arr, int dis, int cows) {
    	int n = arr.length;

    	int k = arr[0];
    	cows--;

    	for(int i = 1; i < n; i++) {
    		if(arr[i]-k >= dis) {
    			
    			cows--;

    			if(cows == 0) {
    				return true;
    			}

    			k = arr[i];
    		}

    	}

    	return false;
    }
}

//TC: O(N^M) where n is length of array and m is maxDistance
//SC: O(1)

//Naive Solution ^^


/* --------------------------------------------------------------------------------------------- */

class Solution {
    public static int solve(int stalls, int cows, int[] posStalls) {
        Arrays.sort(posStalls);

    	int low = 0, high = posStalls[stalls-1]-posStalls[0];

    	while(low <= high) {
    	    int mid = (low+high) >>> 1;
    	    
    	    if(isValid(posStalls, mid, cows)) {
    	        low = mid+1;
    	    }
    	    
    	    else
    	        high = mid-1;
    	}

    	return high;
    }

    private static boolean isValid(int[] arr, int dis, int cows) {
    	int n = arr.length;

    	int k = arr[0];
    	cows--;

    	for(int i = 1; i < n; i++) {
    		if(arr[i]-k >= dis) {
    			
    			cows--;

    			if(cows == 0) {
    				return true;
    			}

    			k = arr[i];
    		}

    	}

    	return false;
    }
}

//TC: O(N*log(M)) where n is length of the array and m is max distance(high)
//SC: O(1)

//Optimal Solution
