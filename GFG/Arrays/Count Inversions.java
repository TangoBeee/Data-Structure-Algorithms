class Solution
{
    static long inversionCount(long nums[], long n) {
        long ans = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                if(i < j && nums[i] > nums[j]) {
                    ans++;
                }
            }
        }
    
        return ans;
    }
}

// TC: O(N^2)
// SC: O(1);
// Naive Solution

// ---------------------------------------------------------------------------------------

//Using Merge Sort :-

class Solution {

    static long inversionCount(long arr[], long N) {

        // Your Code Here

        long count=0;

        int n = (int)N - 1;

        count=merge_sort(arr,0, n);

        return count;

    }

    public static long merge_sort(long arr[],int si,int ei) {

        if(si>=ei) return 0;

        long count=0;

        int mid = (si+ei)/2;

        count += merge_sort(arr,si,mid);
        count += merge_sort(arr,mid+1,ei);

        count += merge(arr,si,mid,ei);

        return count;

    }


    public static long merge(long arr[], int si, int mid, int ei) {

        long temp[] = new long[ei-si+1];

        long count = 0; int k=0;

        int indx1 = si;

        int indx2 = mid+1;

        while(indx1<=mid && indx2<=ei) {

            if(arr[indx1]<=arr[indx2])
                temp[k++] = arr[indx1++];

            else {
                temp[k++] = arr[indx2++];
                count += (mid+1-indx1);
            }
        }

        while(indx1<=mid)
            temp[k++] = arr[indx1++];

        while(indx2<=ei)
            temp[k++] = arr[indx2++];

        for(int i=0, j=si ; i<temp.length; i++)
            arr[j++] = temp[i];

        return count;

    }
}

// TC: O(N log(N))
// SC: O(N) <*only if you dont want to modify your original array otherwise SC will be O(1)*>
// Optimal Solution
