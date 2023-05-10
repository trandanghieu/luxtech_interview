package interview;

import java.util.HashSet;
import java.util.Set;

public class Ex01 {
	public static void main(String[] args) {
		String x = "aabbccdef12";
		String y = "abcfgh12";
		makeSimilar(x, y);

	}

	public static void makeSimilar(String X, String Y) {
		Set<Character> setX = new HashSet<Character>();
		Set<Character> setY = new HashSet<Character>();
		for (int i = 0; i < X.length(); i++) {
			setX.add(X.charAt(i));
		}
		for (int i = 0; i < Y.length(); i++) {
			setY.add(Y.charAt(i));
		}

		Set<Character> commonChars = new HashSet<Character>(setX);
		commonChars.retainAll(setY);

		// Check if X and Y are already similar
		if (commonChars.containsAll(setX) && commonChars.containsAll(setY)) {
			System.out.println("X and Y are already similar: " + X + " and " + Y);
			System.out.println("Common characters: " + commonChars);
			return;
		}

		// Find the set of characters that are in both X and Y
		Set<Character> combinedChars = new HashSet<Character>(setX);
		combinedChars.addAll(setY);

		// Add characters to X and Y until they are similar
		StringBuilder newX = new StringBuilder(X);
		StringBuilder newY = new StringBuilder(Y);
		while (!commonChars.containsAll(setX) || !commonChars.containsAll(setY)) {
			for (Character c : combinedChars) {
				if (!setX.contains(c)) {
					newX.append(c);
				}
				if (!setY.contains(c)) {
					newY.append(c);
				}
			}
			// Update the sets of characters in X and Y
			setX = new HashSet<Character>();
			setY = new HashSet<Character>();
			for (int i = 0; i < newX.length(); i++) {
				setX.add(newX.charAt(i));
			}
			for (int i = 0; i < newY.length(); i++) {
				setY.add(newY.charAt(i));
			}
			// Update the set of common characters
			commonChars = new HashSet<Character>(setX);
			commonChars.retainAll(setY);
		}
		System.out.println("X after adding characters: " + newX);
		System.out.println("Y after adding characters: " + newY);
		System.out.println("Common characters: " + commonChars);
	}

}
