
class Solution {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        int[] nums = new int[n+m];

        int i = 0, j = 0;
        int t = 0;

        while(i < n && j < m) {
        	if(arr1[i] <= arr2[j])
        		nums[t] = arr1[i++];
        	else if(arr1[i] >= arr2[j])
        		nums[t] = arr2[j++];
        	t++;
        }

        while(i < n)
        	nums[t++] = arr1[i++];

        while(j < m)
        	nums[t++] = arr2[j++];


        return (long)nums[k-1];
        
    }
}

//TC: O(N+M)
//SC: O(N+M)

// Naive Solution

/* -------------------------------------------------------------------------------------------------- */

class Solution {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {

        int i = 0, j = 0;
        int t = 0, ans = 0;

        while(i < n && j < m) {
        	if(t == k) break;

        	else if(arr1[i] <= arr2[j])
        		ans = arr1[i++];
        	else if(arr1[i] >= arr2[j])
        		ans = arr2[j++];

        	t++;
        }

        while(i < n) {
        	if(t == k) break;
        	ans = arr1[i++];
        	t++;
        }

        while(j < m) {
        	if(t == k) break;
        	ans = arr2[j++];
        	t++;
        }


        return (long)ans;
        
    }
}

//TC: O(K)
//SC: O(1)

// Better Solution ^^

/* ----------------------------------------------------------------------------------------------- */

class Solution {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        
        if(n > m)
            kthElement(arr2, arr1, m, n, k);
        
        int low = Math.max(0,k-m), high = Math.min(k,n);
        
        while(low <= high) {
            int cut1 = (low+high)/2;
            int cut2 = k-cut1;
            
            long left1 = cut1 == 0 ? Integer.MIN_VALUE : arr1[cut1-1];
            long left2 = cut2 == 0 ? Integer.MIN_VALUE : arr2[cut2-1];
            
            long right1 = cut1 == n ? Integer.MAX_VALUE : arr1[cut1];
            long right2 = cut2 == m ? Integer.MAX_VALUE : arr2[cut2];
            
            if(left1 <= right2 && left2 <= right1)
                return Math.max(left1, left2);
            
            else if(left1 > right2)
                high = cut1-1;
                
            else
                low = cut1+1;
        }
        
        return -1;
    }
}

//TC: O(Log(min(n m)))
//sc: O(1)

// Optimal Solution(will be there) ^^
