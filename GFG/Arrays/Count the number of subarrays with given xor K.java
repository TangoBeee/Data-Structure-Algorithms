class Solution{
    static int subsetXOR(int arr[], int N, int K) {
        int count = 0;
        int xor = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < N; i++) {
            xor ^= arr[i];
            
            if(map.get(xor ^ K) != null) {
                count += map.get(xor^K);
            }
            
            if(xor == K) {
                count++;
            }
            
            if(map.get(xor) != null) {
                map.put(xor, map.get(xor)+1);
            }
            
            else {
                map.put(xor, 1);
            }
        }
        
        return count;
        
    }
    
    
//TC : O(N)
//SC : O(N)
  
  //Optimal Solution ^^ || This solution will not workin GFG
