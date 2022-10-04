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
  // TC: O(N*M)
  // SC: O(1)
  
  /*------------------------------------------------------------------------*/
  
class Solution {

    int rowWithMax1s(int arr[][], int n, int m) {
        int i=0, j = m-1, res = -1;
        while(i<n&&j>=0){
            if(arr[i][j]==1){
        	    j--;
        	    res = i;
        	}
        	else {
        	    i++;
        	}
        }
        return res;
    }

}
    
//TC: O(N+M)
//SC: O(1)
    
   //Optimal Solution ^^
