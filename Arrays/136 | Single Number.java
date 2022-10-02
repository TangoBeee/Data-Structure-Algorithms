/* |----------------------------------------------------------------------------------------------|
   |---------------------------Naive Solution (TC: O(N) | SC: O(N))-------------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int  i : nums)
            map.put(i, map.getOrDefault(i, 0)+1);
        
        for(Map.Entry<Integer, Integer> i : map.entrySet()) {
            if(i.getValue() == 1)
                return i.getKey();
        }
        return -1;
    }
}


/* |----------------------------------------------------------------------------------------------|
   |---------------------------Optimal Solution (TC: O(N) | SC: O(1))-----------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        
        for(int i : nums) 
            ans ^= i;
        
        return ans;
    }
}
