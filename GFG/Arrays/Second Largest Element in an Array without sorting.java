import java.util.Arrays;

public class untitled{
    public static void main(String[] args) {
    	int[] nums = {1, 2, 3, 4, 5, 6, 7};

    	System.out.println(Arrays.toString(largestAndSmallestElements(nums)));
    }

    private static int[] largestAndSmallestElements(int[] nums) {

    	int n = nums.length;

    	int max = largestElement(nums, n);
    	int min = smallestElement(nums, n);

    	int sl = -1;
    	int ss = -1;

    	for(int i = 0; i < n; i++) {
    		if(nums[i] != max) {
    			if(sl == -1) sl = nums[i];
    			else if(nums[i] > sl) sl = nums[i];
    		}
    		if(nums[i] != min) {
    			if(ss == -1) ss = nums[i];
    			else if(nums[i] < ss) ss = nums[i];
    		}
    	}

    	return new int[] {ss, sl};

    }

    private static int largestElement(int[] nums, int n) {
    	int result = 0;

    	for(int i = 0; i < n; i++) {
    		result = Math.max(result, nums[i]);
    	}

    	return result;
    }
    private static int smallestElement(int[] nums, int n) {
    	int result = Integer.MAX_VALUE;

    	for(int i = 0; i < n; i++) {
    		result = Math.min(result, nums[i]);
    	}

    	return result;
    }
}

// Naive Solution ^^
// TC: O(n)
//SC: O(1)

//-----------------------------------------------------------------------------------------------------



import java.util.Arrays;

public class untitled{
    public static void main(String[] args) {
    	int[] nums = {1,2, 3, 4, 5, 6, 7};

    	System.out.println(Arrays.toString(secondlargestAndSecondSmallestElements(nums)));
    }

    private static int[] secondlargestAndSecondSmallestElements(int[] nums) {

    	int n = nums.length;
    	if(n < 2) return new int[] {-1, -1};

    	int sl = largestElement(nums, n);
    	int ss = smallestElement(nums, n);

    	return new int[] {ss, sl};

    }

    private static int largestElement(int[] nums, int n) {
    	int max = Integer.MIN_VALUE;
    	int smax = Integer.MIN_VALUE;

    	for(int i = 0; i < n; i++) {
    		if(nums[i] > max) {
    			smax = max;
    			max = nums[i];
    		}

    		else if(nums[i] > smax && nums[i] != max) {
    			smax = nums[i];
    		}
    	}

    	return smax;

    }
    private static int smallestElement(int[] nums, int n) {
    	int min = Integer.MAX_VALUE;
    	int smin = Integer.MAX_VALUE;

    	for(int i = 0; i < n; i++) {
    		if(nums[i] < min) {
    			smin = min;
    			min = nums[i];
    		}

    		else if(nums[i] < smin && nums[i] != min) {
    			smin = nums[i];
    		}
    	}

    	return smin;
    }
}

// Optimal Solution ^^
// O(n)
//O(1)
