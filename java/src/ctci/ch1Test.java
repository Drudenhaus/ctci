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
}
