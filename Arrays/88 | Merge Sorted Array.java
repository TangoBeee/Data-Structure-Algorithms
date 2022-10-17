/* |----------------------------------------------------------------------------------------------|
   |---------------------------Naive Solution (TC: O(N) | SC: O(N))-------------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int result[] = new int[m+n];
        
        int i = 0;
        
        while(i < m) {
            result[i] = nums1[i];
            i++;
        }
        
        int j = 0;
        while(j < n) {
            result[i] = nums2[j];
            i++;
            j++;
        }
        Arrays.sort(result);
        for(i = 0; i < m+n; i++) {
            nums1[i] = result[i];
        }
    }
}


/* |----------------------------------------------------------------------------------------------|
   |--------------------------Optimal Solution (TC: O(N) | SC: O(1))------------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        if(n == 0) {
            return;
        }
        
        if(m == 0) {
            for(int i = 0; i < nums2.length; i++)
                nums1[i] = nums2[i];
            return;
        }
        
        int n1 = m-1, n2 = n-1, index = m+n-1;
        
        while(n2 >= 0 && n1 >= 0) {
            if(nums1[n1] > nums2[n2])
                nums1[index] = nums1[n1--];
            else
                nums1[index] = nums2[n2--];
            index--;
        }
        while(n2 >= 0)
            nums1[index--] = nums2[n2--];
    }
}
