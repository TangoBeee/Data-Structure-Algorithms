/* |----------------------------------------------------------------------------------------------|
   |------------------------Naive/Optimal Solution (TC: O(N) | SC: O(N))--------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
                
        int n = deck.length;
        
        if(n <= 1) {
            return false;
        }
        
        int result = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i : deck) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        
        for(int i : map.keySet()) {
            result = gcd(result, map.get(i));
        }
        
        return result > 1;
        
    }
    
    private int gcd(int a, int b) {
        return b > 0 ? gcd(b, (a%b)) : a;
    }
}
