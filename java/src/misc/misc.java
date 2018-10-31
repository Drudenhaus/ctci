package misc;

public class misc
{
    public static String longestSubstring(String first, String second)
    {
        if (first.length() == 0 || second.length() == 0)
        {
            return "";
        }

        String longest = "";
        int[][] cache = new int[first.length()][second.length()];
        for (int i = 0; i < first.length(); i++)
        {
            for (int j = 0; j < second.length(); j++)
            {
                if (first.charAt(i) == second.charAt(j))
                {
                    if (i == 0 || j == 0)
                    {
                        cache[i][j] = 1;
                    }
                    else
                    {
                        cache[i][j] = cache[i-1][j-1] + 1;
                    }
                    if (cache[i][j] > longest.length())
                    {
                        longest = first.substring(i - cache[i][j] + 1, i + 1);
                    }
                }
            }
        }
        return longest;
    }

    public static boolean mazeRoute(int maze[][])
    {
        if (maze.length == 0 || maze[0].length == 0)
        {
            return false;
        }
        int[][] path = new int[maze.length][maze[0].length];
        return navigateMaze(maze, 0, 0, maze.length - 1, maze[0].length - 1, path);
    }

    private static boolean isOpen(int maze[][], int x, int y)
    {
        return (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 1);
    }

    public static boolean navigateMaze(int maze[][], int x, int y, int xDest, int yDest, int path[][])
    {
        if (x == xDest && y == yDest)
        {
            path[x][y] = 1;
            return true;
        }
        if (isOpen(maze, x, y))
        {
            System.out.println("isOpen: " + x + "," + y);
            path[x][y] = 1;

            if (navigateMaze(maze, x + 1, y, xDest, yDest, path))
            {
                return true;
            }
            if (navigateMaze(maze, x, y + 1, xDest, yDest, path))
            {
                return true;
            }

            path[x][y] = 0; 
            return false;
        }
        return false;
    }
}
