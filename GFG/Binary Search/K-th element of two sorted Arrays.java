
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


