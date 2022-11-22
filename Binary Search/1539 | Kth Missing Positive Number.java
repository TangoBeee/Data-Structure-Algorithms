/* |----------------------------------------------------------------------------------------------|
   |------------------------Naive Solution (TC: O(N+1000) | SC: O(N))-----------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public int findKthPositive(int[] arr, int k) {
        int count = 0, ans = 0;

        ArrayList<Integer> list = new ArrayList<>();

        for(int j : arr) {
            list.add(j);
        }


        int i = 1;

        while(true) {

            if(!(list.contains(i))) {
                count++;
                ans = i;

                if(count == k)
                    return ans;
            }

            i++;
        }

    }
}


/* |----------------------------------------------------------------------------------------------|
   |-------------------------Better Solution (TC: O(N) | SC: O(1))--------------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public int findKthPositive(int[] arr, int k) {
       
       int arridx = 0, cnt = 0, ans = 2000;
       
       for(int i = 1;i<2000;i++) {
           if(i == arr[arridx]) {
               if(arridx != arr.length-1) arridx++;
           }
              
           else cnt++;
              
           if(cnt == k){
               ans = i;
               break;
           }
       }
            
       return ans;
    }
}



/* |----------------------------------------------------------------------------------------------|
   |-----------------------Optimal Solution (TC: O(log(N)) | SC: O(1))----------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public int findKthPositive(int[] arr, int k) {

        int low = 0, high = arr.length-1;

        while(low <= high) {
            int mid = (low+high) >>> 1;

            if(arr[mid]-(mid+1) > k) {
                high = mid-1;
            }

            else {
                low = mid+1;
            }
        }

        return low+k;
    }
}
