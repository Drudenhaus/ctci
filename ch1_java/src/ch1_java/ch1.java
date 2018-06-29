package ch1_java;

import java.util.Arrays;
import java.util.HashSet;

public class ch1
{
	public static boolean IsUniqueNoSpace(String testString)
	{
		/*
		 * Time complexity: O(n^2) with respect to the string's length due to nested looping
		 * Space complexity: O(1) for variable storage
		 */
		if (testString.length() == 0)
		{
			return false;
		}
		else if (testString.length() == 1)
		{
			return true;
		}

		for (int outerPos = 1; outerPos < testString.length(); outerPos++)
		{
			for (int innerPos = 0; innerPos < outerPos; innerPos++)
			{
				if ((innerPos != outerPos) && (testString.charAt(innerPos) == testString.charAt(outerPos)))
				{
					return false;
				}
			}
		}
		return true;
	}

	public static boolean IsUniqueHashset(String testString)
	{
		/*
		 * Time complexity: O(n) with respect to the string's length
		 * Space complexity: O(n) with respect to the string's length for the HashSet
		 */
		HashSet<Character> charSet = new HashSet<Character>();
		for (char ch : testString.toCharArray())
		{
			charSet.add(ch);
		}
		return testString.length() == charSet.size();
	}

	public static boolean CheckPermutation(String testStringA, String testStringB)
	{
		/*
		 * Time complexity: O(nlogn) for Arrays.sort (QuickSort)
		 * Space complexity: O(n) with respect to the string length for char arrays and for Arrays.sort
		 */
		if ((testStringA.length() != testStringB.length()) || (testStringA.length() == 0))
		{
			return false;
		}
		char[] charArrayA = testStringA.toCharArray();
		char[] charArrayB = testStringB.toCharArray();
		Arrays.sort(charArrayA);
		Arrays.sort(charArrayB);

		//Or Arrays.equal
		for (int pos = 0; pos < charArrayA.length; pos++)
		{
			if (charArrayA[pos] != charArrayB[pos])
			{
				return false;
			}
		}
		return true;
	}
}

