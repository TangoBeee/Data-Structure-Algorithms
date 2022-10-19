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

        long count=0;

        int n = (int)N - 1;

        count=merge_sort(arr,0, n);

        return count;

    }

    public static long merge_sort(long arr[],int left,int right) {

        if(left>=right) return 0;

        long count=0;

        int mid = (left+right)/2;

        count += merge_sort(arr,left,mid);
        count += merge_sort(arr,mid+1,right);

        count += merge(arr,left,mid,right);

        return count;

    }


    public static long merge(long arr[], int left, int mid, int right) {

        long temp[] = new long[right-left+1];

        long count = 0; int k=0;

        int indx1 = left;

        int indx2 = mid+1;

        while(indx1<=mid && indx2<=right) {

            if(arr[indx1]<=arr[indx2])
                temp[k++] = arr[indx1++];

            else {
                temp[k++] = arr[indx2++];
                count += (mid+1-indx1);
            }
        }

        while(indx1<=mid)
            temp[k++] = arr[indx1++];

        while(indx2<=right)
            temp[k++] = arr[indx2++];

        for(int i=0, j=left ; i<temp.length; i++)
            arr[j++] = temp[i];

        return count;

    }
}

// TC: O(N log(N))
// SC: O(N) <*only if you dont want to modify your original array otherwise SC will be O(1)*>
// Optimal Solution
