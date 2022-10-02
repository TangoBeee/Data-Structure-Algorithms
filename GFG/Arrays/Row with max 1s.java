class Solution {
    int rowWithMax1s(int arr[][], int n, int m) {
        int ans = -1;
        int max = 0;
        
        for(int i = 0; i < n; i++) {
            int temp = 0;
            for(int j = 0; j < m; j++) {
                if(arr[i][j] == 1)
                    temp++;
            }
            if(max < (Math.max(max, temp))) {
                max = Math.max(max, temp);
                ans = i;
            }
            
            
        }
        
        return ans;
    }
  
  // Naive Solution ^^
  // TC: O(N^2)
  // SC: O(1)
  
  /*------------------------------------------------------------------------*/
  
  
