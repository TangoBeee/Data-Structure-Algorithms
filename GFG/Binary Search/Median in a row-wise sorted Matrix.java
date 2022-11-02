class Solution {
    int median(int matrix[][], int R, int C) {
        int[] arr = new int[R*C];
        int k = 0;
        
        for(int[] i : matrix)
            for(int j : i)
                arr[k++] = j;
        
        Arrays.sort(arr);
        
        return arr[(((R*C)+1)/2)-1];
    }
}

//TC: O(N*M)
//SC: O(N*M)

//Naive Solution ^^

/* --------------------------------------------------------------------------- */


