class Solve {
    Pair getFloorAndCeil(int[] arr, int n, int x) {
        Pair pair = new Pair(-1, Integer.MAX_VALUE);
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] <= x && pair.floor <= arr[i])
                pair.floor = arr[i];

            if(arr[i] >= x ) 
                pair.ceil = arr[i];
        }
        
        if(pair.ceil == Integer.MAX_VALUE)
            pair.ceil = -1;
        
        return pair;
    }
}

//TC: O(N)
//SC: O(1)

//Naive Solution OR we can say Optimal Solution ig

/* ----------------------------------------------------------------- */

// CANT ABLE TO FIND SOLUTION WHICH USE BINARY SEARCH
