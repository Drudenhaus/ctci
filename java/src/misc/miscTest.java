package misc;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class miscTest
{

    @Test
    public void testLongestSubstring()
    {
        assertEquals("asdf", misc.longestSubstring("asdf123", "asdf456"));
        assertEquals("1", misc.longestSubstring("1abc", "1def"));
        assertEquals("1", misc.longestSubstring("def1", "abc1"));
    }

    @Test
    public void testMazeRoute()
    {
        int maze[][] = {{1, 0, 0, 0}, 
                        {1, 1, 0, 1}, 
                        {0, 1, 0, 0}, 
                        {1, 1, 1, 1}};
        int maze2[][] = {{1, 0, 0, 0}, 
                         {0, 0, 0, 0}, 
                         {0, 1, 0, 0}, 
                         {1, 1, 1, 1}};
        assertEquals(true, misc.mazeRoute(maze));
        assertEquals(false, misc.mazeRoute(maze2));
    }
}
