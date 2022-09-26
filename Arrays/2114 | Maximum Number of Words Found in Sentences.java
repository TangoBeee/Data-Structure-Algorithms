/* |----------------------------------------------------------------------------------------------|
   |------------------------Naive/Optimal Solution (TC: O(N) | SC: O(1))--------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public int mostWordsFound(String[] sentences) {
        
        int ans = 0;
        
        for(String sentence : sentences) {
            ans = Math.max(ans, sentence.split(" ", 100).length);
        }
        
        return ans;
    }
}
