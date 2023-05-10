package interview;

import java.util.ArrayList;
import java.util.List;

public class Ex02 {
	public static void main(String[] args) {
		int[] array =  {-1,3,-4,5,1,-6,2,1};
		System.out.println(findEquilibriumIndices(array));
	}

	public static ArrayList<Integer> findEquilibriumIndices(int[] arr) {
		ArrayList<Integer> result = new ArrayList<Integer>();

		// Calculate prefix sum
		int[] prefixSum = new int[arr.length];
		prefixSum[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			prefixSum[i] = prefixSum[i - 1] + arr[i];
		}

		// Check for equilibrium indices
		for (int i = 0; i < arr.length; i++) {
			int leftSum = i == 0 ? 0 : prefixSum[i - 1];
			int rightSum = prefixSum[arr.length - 1] - prefixSum[i];
			if (leftSum == rightSum) {
				result.add(i);
			}
		}

		// Return result
		if (result.size() == 0) {
			return null;
		} else {
			return result;
		}
	}

}
