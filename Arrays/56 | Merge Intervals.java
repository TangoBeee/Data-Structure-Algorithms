/* |----------------------------------------------------------------------------------------------|
   |--------------------------Naive Solution (TC: O(N^2) | SC: O(N))------------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public int[][] merge(int[][] intervals) {
        int[] arr = new int[intervals.length];  // to track which indexes are merged
        int len = intervals.length;
        int count = 0;
        
        for(int i=0; i<len; i++) {
            for(int j=i+1; j<intervals.length; j++) {
                if(arr[j] == -1) continue;   // don't visit
                
                int fs = intervals[i][0];
                int fe = intervals[i][1];
                int ss = intervals[j][0];
                int se = intervals[j][1];
                
                // System.out.println("("+fs + " >= " + ss + " && " + fs + " <= " + se + ")" + " || " + "("+ss + " <= " + fe + " && " + ss + " >= " + fs + ")");
                
                if((fs >= ss && fs <= se) || (ss <= fe && ss >= fs)) {
                    // there is a overlap.
                    intervals[i][0] = Math.min(fs,ss);
                    intervals[i][1] = Math.max(fe,se);
                    arr[j] = -1;    // mark this index in arr as -1 as it got merged
                    count++;   // increment the count
                    i--;       // i should point to same index. so decr now and for loop increments it to breakeven
                    break;
                } 
            }
        }
        // calculate the size of out array by len and count
        int[][] out = new int[len-count][];
        int out_len = 0;
        for(int i=0; i<len; i++) {
            if(arr[i] != -1) {
                out[out_len++] = intervals[i];
            }
        }
        return out;
    }
}

// if matrix rows were not sorted then we first we have to sort them and then the time complexity will be O(N log N)+O(N^2)

/* |----------------------------------------------------------------------------------------------|
   |--------------------------Optimal Solution (TC: O(N) | SC: O(N))------------------------------|
   |----------------------------------------------------------------------------------------------| */

