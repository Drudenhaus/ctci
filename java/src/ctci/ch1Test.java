package ctci;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ch1Test 
{
    // TODO Add tests for edge cases. These are tests are super basic.
    
    @Test
    void testIsUniqueNoSpaceTrue()
    {
        String testString = "asdf";
        assertTrue(ch1.IsUniqueNoSpace(testString));
    }

    @Test
    void testIsUniqueNoSpaceFalse()
    {
        String testString = "asdff";
        assertFalse(ch1.IsUniqueNoSpace(testString));
    }

    @Test
    void testIsUniqueHashsetTrue()
    {
        String testString = "asdf";
        assertTrue(ch1.IsUniqueHashset(testString));
    }

    @Test
    void testIsUniqueHashsetFalse()
    {
        String testString = "asdff";
        assertFalse(ch1.IsUniqueHashset(testString));
    }

    @Test
    void testCheckPermutationTrue()
    {
        String testStringA = "abcd";
        String testStringB = "badc";
        assertTrue(ch1.CheckPermutation(testStringA, testStringB));
    }

    @Test
    void testCheckPermutationFalse()
    {
        String testStringA = "abcd";
        String testStringB = "1234";
        assertFalse(ch1.CheckPermutation(testStringA, testStringB));
    }

    @Test
    void testIsPermutationPalindromeTrueEvenLength()
    {
        String testString = "aabbcc";
        assertTrue(ch1.IsPermutationPalindrome(testString));
    }

    @Test
    void testIsPermutationPalindromeTrueOddLength()
    {
        String testString = "aabbccd";
        assertTrue(ch1.IsPermutationPalindrome(testString));
    }

    @Test
    void testIsPermutationPalindromeFalseEvenLength()
    {
        String testString = "abcdef";
        assertFalse(ch1.IsPermutationPalindrome(testString));
    }

    @Test
    void testIsPermutationPalindromeFalseOddLength()
    {
        String testString = "abcdefg";
        assertFalse(ch1.IsPermutationPalindrome(testString));
    }

    @Test
    void testMatrixRotationEmpty()
    {
        int[][] originalMatrix = {{}};
        int[][] expectedMatrix = {{}};
        assertFalse(ch1.RotateMatrix(originalMatrix));
        assertArrayEquals(expectedMatrix, originalMatrix);
    }

    @Test
    void testMatrixRotationNotNxN()
    {
        int[][] originalMatrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15}};
        int[][] expectedMatrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15}};
        assertFalse(ch1.RotateMatrix(originalMatrix));
        assertArrayEquals(expectedMatrix, originalMatrix);
    }

    @Test
    void testMatrixRotation()
    {
        int[][] originalMatrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] expectedMatrix = {{13, 9, 5, 1}, {14, 10, 6, 2}, {15, 11, 7, 3}, {16, 12, 8, 4}};
        assertTrue(ch1.RotateMatrix(originalMatrix));
        assertArrayEquals(expectedMatrix, originalMatrix);
    }

    @Test
    void testStringRotationTrue()
    {
        String originalString = "helloworld";
        String rotatedString = "worldhello";
        assertTrue(ch1.StringRotation(originalString, rotatedString));
    }

    @Test
    void testStringRotationFalse()
    {
        String originalString = "helloworld";
        String rotatedString = "hellow0rld";
        assertFalse(ch1.StringRotation(originalString, rotatedString));
    }

    @Test
    void testStringRotationEmptyFalse()
    {
        String originalString = "";
        String rotatedString = "";
        assertFalse(ch1.StringRotation(originalString, rotatedString));
    }

    @Test
    void testStringRotationDifferentSizesFalse()
    {
        String originalString = "helloworld";
        String rotatedString = "worldhelloto";
        assertFalse(ch1.StringRotation(originalString, rotatedString));
    }
}
