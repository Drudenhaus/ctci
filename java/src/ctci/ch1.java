package ctci;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class ch1
{
    // #1
	public static boolean IsUniqueNoSpace(String inputString)
	{
		/*
		 * Time complexity: O(n^2) with respect to the string's length due to nested looping
		 * Space complexity: O(1) for variable storage
		 */
		if (inputString.length() == 0)
		{
			return false;
		}
		else if (inputString.length() == 1)
		{
			return true;
		}

		for (int outerPos = 1; outerPos < inputString.length(); outerPos++)
		{
			for (int innerPos = 0; innerPos < outerPos; innerPos++)
			{
				if ((innerPos != outerPos) && (inputString.charAt(innerPos) == inputString.charAt(outerPos)))
				{
					return false;
				}
			}
		}
		return true;
	}

	public static boolean IsUniqueHashset(String inputString)
	{
		/*
		 * Time complexity: O(n) with respect to the string's length
		 * Space complexity: O(n) with respect to the string's length for the HashSet
		 */
		HashSet<Character> charSet = new HashSet<Character>();
		for (char ch : inputString.toCharArray())
		{
			charSet.add(ch);
		}
		return inputString.length() == charSet.size();
	}

	// #2
	public static boolean CheckPermutation(String inputStringA, String inputStringB)
	{
		/*
		 * Time complexity: O(n log n) for Arrays.sort (QuickSort)
		 * Space complexity: O(n) with respect to the string length for char arrays and for Arrays.sort
		 */
		if ((inputStringA.length() != inputStringB.length()) || (inputStringA.length() == 0))
		{
			return false;
		}
		char[] charArrayA = inputStringA.toCharArray();
		char[] charArrayB = inputStringB.toCharArray();
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

	// #3 TODO
	public static String URLify(String inputString, int realLength)
	{
        return inputString;
	}

	// #4
    public static boolean IsPermutationPalindrome(String inputString)
    {
        /*
         * Time complexity: O(n) with respect to the length of inputString
         * Space complexity: O(n) for the hashmap
         * Assumptions: includes all characters including spaces, cases are distinct (a != A)
         */
        HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();
        int numOddChars = 0;
        for (char ch : inputString.toCharArray())
        {
            Character thisChar = Character.valueOf(ch);
            if (charCountMap.containsKey(thisChar))
            {
                // Making an odd quantity even
                if (charCountMap.get(thisChar) % 2 == 1)
                {
                    numOddChars--;
                }
                else
                {
                    numOddChars++;
                }
                charCountMap.put(thisChar, charCountMap.get(thisChar) + 1);
            }
            else
            {
                charCountMap.put(thisChar, Integer.valueOf(1));
                numOddChars++;
            }
        }
        return numOddChars < 2;
    }

	// #5 TODO
	public static boolean OneAway(String inputString)
	{
	    return false;
	}

	// #6 TODO
	public static String StringCompression(String inputString)
	{
	    return inputString;
	}

	// #7
	public static boolean RotateMatrix(int[][] inputMatrix)
	{
	    /*
	     * Time complexity: O(N^2) with respect to the length of a dimension of the matrix
	     * Space complexity: O(1) as this is an in-place operation
	     */
	    int numRows = inputMatrix.length;
	    // Verify the matrix is non-empty and is NxN
	    if (inputMatrix[0].length == 0)
	    {
	        return false;
	    }
	    else
	    {
	        for (int i = 0; i < numRows; i++)
	        {
	            if (inputMatrix[i].length != numRows)
	            {
	                return false;
	            }
	        }
	    }

	    // Perform in-place rotation
	    // Work from the outside to the inside
	    for (int layer = 0; layer < numRows / 2; layer++)
	    {
	        int startColumn = layer;
	        int endColumn = numRows - 1 - layer;
	        // Top to left
	        for (int column = startColumn; column < endColumn; column++)
	        {
	            int targetColumn = endColumn;
	            int targetRow = 0 + column;
	            int valueAtTarget = inputMatrix[targetRow][targetColumn];
	            inputMatrix[targetRow][targetColumn] = inputMatrix[layer][column];
	            inputMatrix[layer][column] = valueAtTarget;
	        }

	        // Top to bottom
	        for (int column = layer, targetColumn = endColumn; column < endColumn; column++, targetColumn--)
	        {
	            int targetRow = endColumn;
	            int valueAtTarget = inputMatrix[targetRow][targetColumn];
	            inputMatrix[targetRow][targetColumn] = inputMatrix[layer][column];
	            inputMatrix[layer][column] = valueAtTarget;
	        }

	        // Top to right
	        for (int column = startColumn; column < endColumn; column++)
	        {
	            int targetColumn = layer;
	            int targetRow = numRows - column - 1;
	            int valueAtTarget = inputMatrix[targetRow][targetColumn];
	            inputMatrix[targetRow][targetColumn] = inputMatrix[layer][column];
	            inputMatrix[layer][column] = valueAtTarget;
	        }
	    }
        return true;
	}

	// #8 TODO
	public static String[][] ZeroMatrix(String[][] inputMatrix)
	{
	    return inputMatrix;
	}

	// #9
	public static boolean StringRotation(String originalString, String testString)
	{
	    /*
	     * Time complexity: O(n^2) using string concatenation or O(n) using StringBuffer with respect to the size of testString
	     * Space complexity: O(n) with respect to the size of testString
	     *
	     * isSubstring is not provided so this uses String.contains in its place
	     */
	    if (originalString.length() != testString.length() || originalString.length() == 0)
	    {
	        return false;
	    }
	    StringBuffer buffer = new StringBuffer(testString.length() * 2);
	    String doubleTestString = buffer.append(testString).append(testString).toString();
//	    String doubleTestString = testString + testString;
	    return doubleTestString.contains(originalString);
	}
}
