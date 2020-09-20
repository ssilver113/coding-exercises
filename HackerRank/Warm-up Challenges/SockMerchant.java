import java.util.*;

public class Solution {

	public static void main(String[] args) {
		int[] input = {1,1,2,2,2,3};
		System.out.println("Socks " + sockMerchant(6, input));
	}

	static int sockMerchant(int n, int[] ar) {
		ArrayList<Integer> sockList = new ArrayList<>();
		int sockPairCounter = 0;

		for (int sock : ar) {
			if (sockList.contains(sock)) {
				sockList.remove(Integer.valueOf(sock)); // remove by object, not index
				sockPairCounter++;
			} else {
				sockList.add(sock);
			}
		}

		return sockPairCounter;
	}
}
