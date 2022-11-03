class Solution {
    int median(int matrix[][], int R, int C) {
        int[] arr = new int[R*C];
        int k = 0;
        
        for(int[] i : matrix) //---|
                             //     ---> O(N*M)
            for(int j : i)    //---|
                arr[k++] = j;
        
        Arrays.sort(arr); // O(log N*M)
        
        return arr[(R*C)/2];
    }
}

//TC: O(N*M (log N*M))
//SC: O(N*M)

//Naive Solution ^^

/* --------------------------------------------------------------------------- */


