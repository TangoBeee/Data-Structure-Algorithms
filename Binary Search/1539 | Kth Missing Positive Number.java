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
