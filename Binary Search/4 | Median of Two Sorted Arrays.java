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
   |-----------------------Optimal Solution (TC: O(log()) | SC: O(1))----------------------------|
   |----------------------------------------------------------------------------------------------| */


