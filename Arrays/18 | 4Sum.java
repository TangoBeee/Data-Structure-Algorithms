/* |----------------------------------------------------------------------------------------------|
   |--------------------------Naive Solution (TC: O(N^4) | SC: O(1))------------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i = 0; i < nums.length-3; i++) {
            for(int j = i+1; j < nums.length; j++) {
                for(int k = j+1; k < nums.length; k++) {
                    for(int l = k+1; l < nums.length; l++) {
                        List<Integer> set = new ArrayList<>();
                        if(nums[i] + nums[j] + nums[k] + nums[l] == target) {
                            set.add(nums[i]);
                            set.add(nums[j]);
                            set.add(nums[k]);
                            set.add(nums[l]);
                        }
                        Collections.sort(set);
                        if(set.isEmpty()) continue;
                        else if(!result.contains(set)) result.add(set);
                    }
                }
            }
        }
        
        return result;
    }
}

// TC could be N^5 because of list.contains();

/* |----------------------------------------------------------------------------------------------|
   |--------------------------Naive Solution (TC: O(N^4) | SC: O(1))------------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length-3; i++) {
            for(int j = i+1; j < nums.length; j++) {
                for(int k = j+1; k < nums.length; k++) {
                    int l = k+1;
                    int sum = nums[i] + nums[j] + nums[k];
                    while(l < nums.length) {
                        if(sum + nums[l] == target) {
                            if(!result.contains(Arrays.asList(nums[i], nums[j], nums[k], nums[l])))
                                result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                            
                            while(l < nums.length && nums[l] == nums[i+1]) l++;
                            l++;
                        }
                        else l++;
                    }
                }
            }
        }
        
        return result;
    }
}

// TC could be N^5 because of list.contains();


/* |----------------------------------------------------------------------------------------------|
   |--------------------------Better Solution (TC: O(N^3) | SC: O(1))-----------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length-3; i++) {
            for(int j = i+1; j < nums.length; j++) {
                int low = j+1, high = nums.length-1;
                long sum = nums[i]+nums[j];
                while(low < high) {
                    long temp = nums[low]+nums[high];
                    if(sum+temp == target && !result.contains(Arrays.asList(nums[i], nums[j], nums[low], nums[high])))
                        result.add(Arrays.asList(nums[i], nums[j], nums[low++], nums[high--]));
                    else if(sum+temp < target) low++;
                    else high--;
                }
            }
        }
        
        return result;
    }
}

// TC could be N^4 because of list.contains();


/* |----------------------------------------------------------------------------------------------|
   |-------------------------Optimal Solution (TC: O(N^3) | SC: O(1))-----------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if (num == null || num.length == 0)
            return res;
        
        int n = num.length;
    
        Arrays.sort(num); 
    
        for (int i = 0; i < n; i++) {
        
            long target_3 = target - num[i];
        
            for (int j = i + 1; j < n; j++) {
            
                long target_2 = target_3 - num[j];
            
                int front = j + 1;
                int back = n - 1;
            
                while(front < back) {
                
                    int two_sum = num[front] + num[back];
                
                    if (two_sum < target_2) front++;
                
                    else if (two_sum > target_2) back--;
                
                    else {
                    
                        List<Integer> quad = new ArrayList<>(); 
                        quad.add(num[i]);
                        quad.add(num[j]);
                        quad.add(num[front]);
                        quad.add(num[back]);
                        res.add(quad);
                    
                        // Processing the duplicates of number 3
                        while (front < back && num[front] == quad.get(2)) ++front;
                    
                        // Processing the duplicates of number 4
                        while (front < back && num[back] == quad.get(3)) --back;
                
                    }
                }
                
                // Processing the duplicates of number 2
                while(j + 1 < n && num[j + 1] == num[j]) ++j;
            }
        
            // Processing the duplicates of number 1
            while (i + 1 < n && num[i + 1] == num[i]) ++i;
        
        }
        
    
        return res;
    }
}
