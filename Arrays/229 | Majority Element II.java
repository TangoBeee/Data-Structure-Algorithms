/* |----------------------------------------------------------------------------------------------|
   |--------------------------Naive Solution (TC: O(N^2) | SC: O(1))------------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++) {
            int count = 0;
            for(int j = 0; j < nums.length; j++) {
                if(nums[i] == nums[j]) {
                    count++;
                    if(count > (nums.length/3) && !(list.contains(nums[i]))) list.add(nums[i]);
                }
            }
        }
        
        return list;
    }
}


/* |----------------------------------------------------------------------------------------------|
   |---------------------------Better Solution (TC: O(N) | SC: O(N))------------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        
        for(int i : nums) map.put(i, map.getOrDefault(i, 0)+1);
        
        for(Map.Entry<Integer, Integer> i : map.entrySet()) {
            if(i.getValue() > nums.length/3) list.add(i.getKey());
        }
        
        return list;
    }
}


/* |----------------------------------------------------------------------------------------------|
   |---------------------------Optimal Solution (TC: O(N) | SC: O(1))-----------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        int num1 = Integer.MIN_VALUE;
        int num2 = Integer.MIN_VALUE;
        
        int count1 = 0;
        int count2 = 0;
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++) {
            if(num1 == nums[i]) count1++;
            
            else if(num2 == nums[i]) count2++;
            
            else if(count1 == 0) {
                num1 = nums[i];
                count1 = 1;
            }
            
            else if(count2 == 0) {
                num2 = nums[i];
                count2 = 1;
            }
            
            else {
                count1--;
                count2--;
            }
        }
        
        count1 = 0;
        count2 = 0;
        
        for(int i = 0; i < nums.length; i++) {
            if(num1 == nums[i]) count1++;
            else if(num2 == nums[i]) count2++;
        }
        
        if(count1 > nums.length/3) list.add(num1);
        if(count2 > nums.length/3) list.add(num2); 
        
        return list;
    }
}
