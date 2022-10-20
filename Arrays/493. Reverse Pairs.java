/* |----------------------------------------------------------------------------------------------|
   |--------------------------Naive Solution (TC: O(N^2) | SC: O(1))------------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public int reversePairs(int[] nums) {
        int pairs = 0;
        
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                if((long)nums[i] > (long)2*nums[j]) {
                    pairs++;
                }
            }
        }
        
        return pairs;
    }
}


/* |----------------------------------------------------------------------------------------------|
   |------------------------Optimal Solution (TC: O(N logN) | SC: O(N))---------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
    
    private int mergeSort(int[] nums, int left, int right) {
        if(left >= right) return 0;
        
        int count = 0;
        
        int mid = (left+right)/2;
        
        count += mergeSort(nums, left, mid);
        count += mergeSort(nums, mid+1, right);
        
        count += merge(nums, left, mid, right);
        
        return count;
    }
    
    private int merge(int[] nums, int left, int mid, int right) {
        int count = 0, k = 0;
        
        int[] temp = new int[right-left+1];
        
        int i = left;
        int j = mid+1;
        
        while(i <= mid && j <= right) {
            if((long)nums[i] > (long)2*nums[j]) {
                count += mid+1-i;
                j++;
            }
            else {
                i++;
            }
                
        }
                
        i = left;
        j = mid+1;
        
        while(i <= mid && j <= right) {
            if(nums[i] <= nums[j])
                temp[k] = nums[i++];
            else {
                temp[k] = nums[j++];
            }
            k++;
        }
        
        while(i <= mid)
            temp[k++] = nums[i++];
        while(j <= right)
            temp[k++] = nums[j++];
        
        for(int index = left; index <= right; index++) {
            nums[index] = temp[index-left];
        }
        
        return count;
    }
}


