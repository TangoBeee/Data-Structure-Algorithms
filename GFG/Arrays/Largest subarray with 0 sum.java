class GfG
{
    int maxLen(int nums[], int n)
    {
        int result = 0;

		for(int i = 0; i < n; i++) {
			for(int j = i; j < n; j++) {
				int temp = 0;
				int sum = 0;
				for(int k = i; k <= j; k++) {
					sum+= nums[k];
					temp++;
					if(sum == 0)
						result = Math.max(result, temp);
				}
			}
		}

		return result;
    }
}

// TC -> O(N^3)
// SC -> O(1)
// Naive Solution ^^

/* ---------------------------------------------------------------------------------- */

class GfG
{
    int maxLen(int nums[], int n)
    {
		int result = 0;

		for(int i = 0; i < n; i++) {
			int sum = 0;
			for(int j = i; j < nums.length; j++) {
				sum += nums[j];
				if(sum == 0) 
					result = Math.max(result, j-i+1);
			}
		}

		return result;
    }
}

// TC -> O(N^2)
// SC -> O(1)
// Better Solution ^^

/* ---------------------------------------------------------------------------------- */

