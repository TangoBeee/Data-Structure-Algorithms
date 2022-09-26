/* |----------------------------------------------------------------------------------------------|
   |---------------------------Naive Solution (TC: O(N) | SC: O(1))-------------------------------|
   |----------------------------------------------------------------------------------------------| */
   
class Solution {
    public int finalValue(String[] operations) {
            int value = 0;
            for (String s : operations) {
                switch (s) {
                    case "--X", "X--" -> value--;
                    case "++X", "X++" -> value++;
                }
            }
            return value;
    }
}


/* |----------------------------------------------------------------------------------------------|
   |---------------------------Optimal Solution (TC: O(N) | SC: O(1))-----------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
   public static int finalValueAfterOperations(String[] operations) {
       
    return Arrays.stream(operations,0,operations.length)
            .mapToInt(operation->operation.charAt(1)=='+'?1:-1)
            .sum();
       
    }
}
