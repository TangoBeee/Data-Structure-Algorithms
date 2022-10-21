/* |----------------------------------------------------------------------------------------------|
   |---------------------------Naive Solution (TC: O(N^2) | SC: O(N))-------------------------------|
   |----------------------------------------------------------------------------------------------| */

public boolean check(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            int[] tempArr = new int[n];
            
            for(int j = 0; j < n; j++) {
                tempArr[j] = nums[(j + i) % n];
            }
            
            if(isIncreasing(tempArr)) {
                return true;
            }
        }
        
        return false;
    }
    
    public static boolean isIncreasing(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i] > arr[i + 1]) {
                return false;
            }
        }
        
        return true;
    }
    
    /* |----------------------------------------------------------------------------------------------|
       |--------------------------Better Solution (TC: O(N^2) | SC: O(1))-----------------------------|
       |----------------------------------------------------------------------------------------------| */
    
public boolean check(int[] nums) {
        for(int j = 0; j < nums.length; j++) {
            boolean flag = true;
            for(int i = 0; i < nums.length - 1; i++) {
                if(nums[(j + i) % nums.length] > nums[(j + i + 1) % nums.length]) {
                    flag = false;
                    break;
                }
            }
            if(flag == true) {
                return true;
            }
        }
        
        return false;
        
    }


/* |----------------------------------------------------------------------------------------------|
   |---------------------------Optimal Solution (TC: O(N) | SC: O(1))-----------------------------|
   |----------------------------------------------------------------------------------------------| */
   
class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int count = 0;
        
        for(int i = 0; i < n; i++) {
            if(nums[i] > nums[(i+1)%n]) {
                count++;
            }
            
            if(count > 1) {
                return false;
            }
        }
        
        return true;
    }
}
