/* |----------------------------------------------------------------------------------------------|
   |---------------------------Naive Solution (TC: O(N+M) | SC: O(N+M))---------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length+nums2.length];

        int i = 0, j = 0, k = 0;

        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] <= nums2[j]) 
                result[k] = nums1[i++];
            else
                result[k] = nums2[j++];
          
            k++;
        }
        


        while(i < nums1.length) 
            result[k++] = nums1[i++];

        while(j < nums2.length)
            result[k++] = nums2[j++];
        

        if((result.length)%2 == 0) {
            int mid = (result.length/2)-1;
            double ans = result[mid]+result[mid+1];
            return ans/2;
        }

        else
            return result[(result.length/2)];

    }
}



/* |----------------------------------------------------------------------------------------------|
   |-------------------------Better Solution (TC: O(N+M) | SC: O(1))------------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if((nums1.length+nums2.length)%2==0){
            int pos = 0;
            int i =0;
            int j = 0;
            int num1 = 0;
            int num2 = 0;
            while(i<nums1.length&&j<nums2.length){
                if(nums1[i]<nums2[j]){
                    pos++;
                    if(pos==(nums1.length+nums2.length)/2){
                        num1 = nums1[i];
                    }else if(pos==(nums1.length+nums2.length)/2+1){
                        num2 = nums1[i];
                    }
                     i++;
                }else{
                    pos++;
                    if(pos==(nums1.length+nums2.length)/2){
                        num1 = nums2[j];
                    }else if(pos==(nums1.length+nums2.length)/2+1){
                        num2 = nums2[j];
                    }
                     j++;
                }
            }
            while(i<nums1.length){
                 pos++;
                    if(pos==(nums1.length+nums2.length)/2){
                        num1 = nums1[i];
                    }else if(pos==(nums1.length+nums2.length)/2+1){
                        num2 = nums1[i];
                    }
                     i++;
            }
            while(j<nums2.length){
                 pos++;
                    if(pos==(nums1.length+nums2.length)/2){
                        num1 = nums2[j];
                    }else if(pos==(nums1.length+nums2.length)/2+1){
                        num2 = nums2[j];
                    }
                     j++;
            }
            return ((double)num1+num2) / (double) 2; 
                 
        }else{
                int pos = 0;
            int i =0;
            int j = 0;
            int num = 0;
            while(i<nums1.length&&j<nums2.length){
                if(nums1[i]<nums2[j]){
                    pos++;
                    if(pos==(nums1.length+nums2.length)/2+1){
                        num = nums1[i];
                    }
                     i++;
                }else{
                    pos++;
                    if(pos==(nums1.length+nums2.length)/2+1){
                        num = nums2[j];
                    }
                      j++;
                }
            }
               while(i<nums1.length){
                 pos++;
                   if(pos==(nums1.length+nums2.length)/2+1){
                        num = nums1[i];
                    }
                     i++;
            }
            while(j<nums2.length){
                 pos++;
                    if(pos==(nums1.length+nums2.length)/2+1){
                        num = nums2[j];
                    }
                     j++;
            }
            return (double)num;
                 
        }
    }
}


/* |----------------------------------------------------------------------------------------------|
   |--------------------Optimal Solution (TC: O(log(min(N+M))) | SC: O(1))------------------------|
   |----------------------------------------------------------------------------------------------| */ //min because We are applying binary search on the array which has a minimum size.

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums2.length < nums1.length)
            return findMedianSortedArrays(nums2, nums1);

        int low = 0, high = nums1.length;
        int len = ((nums1.length+nums2.length)+1)/2;

        while(low <= high) {
            int cut1 = (low+high) >>> 1;
            int cut2 = len-cut1;

            int left1 = cut1 <= 0 ? Integer.MIN_VALUE : nums1[cut1-1];
            int left2 = cut2 <= 0 ? Integer.MIN_VALUE : nums2[cut2-1];

            int right1 = cut1 >= nums1.length ? Integer.MAX_VALUE : nums1[cut1];
            int right2 = cut2 >= nums2.length ? Integer.MAX_VALUE : nums2[cut2];


            if(left1 <= right2 && left2 <= right1) {
                if((nums1.length+nums2.length)%2 == 0)
                    return (Math.max(left1, left2) + Math.min(right1, right2))/2.0;
                else
                    return Math.max(left1, left2);
            }

            else if(left1 > right2) {
                high = cut1-1;
            }

            else {
                low = cut1+1;
            }
        }

        return -1;
    }
}
