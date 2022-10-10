/* |----------------------------------------------------------------------------------------------|
   |--------------------------Naive Solution (TC: O(N^3) | SC: O(M))------------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> list = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                for(int k = j+1; k < nums.length; k++) {
                    List<Integer> temp = new ArrayList<>();
                    if(nums[i]+nums[j]+nums[k] == 0) {
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        
                        Collections.sort(temp);
                        
                        if(!list.contains(temp)) list.add(temp);
                    }
                }
            }
        }
        
        return list;
    }
}

/* |----------------------------------------------------------------------------------------------|
   |-------------------------Better Solution (TC: O(N^2) | SC: O(M+N))----------------------------|
   |----------------------------------------------------------------------------------------------| */

