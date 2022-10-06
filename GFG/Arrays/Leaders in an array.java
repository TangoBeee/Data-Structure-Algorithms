class Solution{

    static ArrayList<Integer> leaders(int nums[], int n){
    
      ArrayList<Integer> ans = new ArrayList<>();

      for(int i = n-1; i >= 0; i--) {
        if(ans.isEmpty()) ans.add(nums[i]);
        
        else if(nums[i] > ans.get(ans.size()-1)) ans.add(nums[i]);
      }

      Collections.reverse(ans);

      return ans;
    }
}

// TC: O(N) <for loop> + O(N) <Collection.reverse> => O(N)
// SC: O(N)

// Optimal Solution
