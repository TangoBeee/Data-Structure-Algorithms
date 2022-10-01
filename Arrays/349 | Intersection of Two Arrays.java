/* |----------------------------------------------------------------------------------------------|
   |--------------------------Naive Solution (TC: O(N^2) | SC: O(N))------------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < nums1.length; i++) {
            for(int j = 0; j < nums2.length; j++) {
                if(nums1[i] == nums2[j]) {
                    if(list.size() == 0 || !(list.contains(nums1[i]))) {
                        list.add(nums1[i]);
                        break;
                    }
                }
            }
        }
        int[] result = new int[list.size()];
        
        for(int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        
        return result;
        
    }
}



/* |----------------------------------------------------------------------------------------------|
   |-------------------------Optimal Solution (TC: O(N+M) | SC: O(N+M))---------------------------|
   |----------------------------------------------------------------------------------------------| */


class Solution {
  public int[] set_intersection(HashSet<Integer> set1, HashSet<Integer> set2) {
    int [] output = new int[set1.size()];
    int idx = 0;
    for (Integer s : set1)
      if (set2.contains(s)) output[idx++] = s;

    return Arrays.copyOf(output, idx);
  }

  public int[] intersection(int[] nums1, int[] nums2) {
    HashSet<Integer> set1 = new HashSet<Integer>();
    for (Integer n : nums1) set1.add(n);
    HashSet<Integer> set2 = new HashSet<Integer>();
    for (Integer n : nums2) set2.add(n);

    if (set1.size() < set2.size()) return set_intersection(set1, set2);
    else return set_intersection(set2, set1);
  }
}

/* |----------------------------------------------------------------------------------------------|
   |-------------------------Optimal Solution (TC: O(N+M) | SC: O(N+M))---------------------------|
   |----------------------------------------------------------------------------------------------| */



class Solution {
  public int[] intersection(int[] nums1, int[] nums2) {
    HashSet<Integer> set1 = new HashSet<Integer>();
    for (Integer n : nums1) set1.add(n);
    HashSet<Integer> set2 = new HashSet<Integer>();
    for (Integer n : nums2) set2.add(n);

    set1.retainAll(set2);

    int [] output = new int[set1.size()];
    int idx = 0;
    for (int s : set1) output[idx++] = s;
    return output;
  }
}
