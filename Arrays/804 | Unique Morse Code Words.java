/* |----------------------------------------------------------------------------------------------|
   |------------------------Naive/Optimal Solution (TC: O(N) | SC: O(N))--------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        Set<String> seen = new HashSet<>();
        
        for(String word : words) {
            StringBuilder builder = new StringBuilder();
            
            for(char c : word.toCharArray()) {
                builder.append(morse[c-'a']);
            }
            
            seen.add(builder.toString());
        }
        
        return seen.size();
    }
}
