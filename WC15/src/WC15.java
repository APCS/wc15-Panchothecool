
/**
 * WC15 - This is a review of all kinds of concepts.
 * Only use AP official subset methods for ArrayLists, Strings, 1D arrays, etc.
 * These methods focus on various arrays, loops, and whatever else I think
 * you need practice on.
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.List;

public class WC15
{
  /**
   * 
   * Given a string of odd length, return the string length 3 from its middle,
   * so "Candy" yields "and".
   * 
   * <pre>
   * The string length will be at least 3.
   * 
   * middleThree("Candy") -> "and" 
   * middleThree("and") -> "and"
   * middleThree("solving") -> "lvi"
   * </pre>
   * 
   * @param letters
   * @return
   */
  public static String centralThree(String letters)
  {
    // TODO: Finish
    String answer = "";
    int middle = letters.length() / 2;

    if (letters.length() == 3)
      return letters;

    answer += letters.substring(middle - 1, middle + 2);
    return answer;
  }

  /**
   * Given a string, return a version without the first 2 chars. Except keep the
   * first char if it is 'a' and keep the second char if it is 'b'. The string
   * may be any length. Harder than it looks.
   * 
   * <pre>
   * PRECONDITION: str will be lowercase and length will be at least two
   * deFront("Hello") -> "llo" 
   * deFront("java") -> "va" 
   * deFront("away") -> "aay"
   * </pre>
   * 
   * @param str
   * @return
   */
  public static String chopFront(String str)
  {
    // TODO: Finish
    String answer = "";
    if (str.length() >= 2)
    {
      if (str.substring(0, 1).equals("a"))
        answer += str.substring(0, 1);

      if (str.substring(1, 2).equals("b"))
        answer += str.substring(1, 2);

      answer += str.substring(2);
    }

    return answer;
  }

  /**
   * 
   * Given a string, if one or both of the first 2 chars is 'x', return the
   * string without those 'x' chars, and otherwise return the string unchanged.
   * This is a little harder than it looks.
   * 
   * <pre>
   * withoutX2("xHi") -> "Hi" 
   * withoutX2("Hxi") -> "Hi" 
   * withoutX2("Hi") -> "Hi"
   * </pre>
   * 
   * @param str
   * @return
   */
  public static String hateX(String str)
  {
    // TODO: Finish
    String answer = "";
    if (str.substring(0, 1).equals("x"))
    {
      if (str.substring(1, 2).equals("x"))
      {
        answer += str.substring(2);
      }
      else
      {
        answer = str.substring(1);
      }
    }
    else if (str.substring(1, 2).equals("x"))
    {
      answer += str.substring(0, 1) + str.substring(2);
    }
    else
    {
      answer = str;
    }
    return answer;

  }

  /**
   * Swaps all values in the specified 2 rows of mat.
   * 
   * @param mat
   *          the array
   * @param rowAIndex
   *          the index of a row to be swapped
   * @param rowBIndex
   *          the index of a row to be swapped
   */
  public static void swapRows(int[][] mat, int rowAIndex, int rowBIndex)
  {
    // TODO: Finish
    int[] temp = mat[rowAIndex];
    mat[rowAIndex] = mat[rowBIndex];
    mat[rowBIndex] = temp;
  }

  /**
   * Swaps all values in the specified 2 columns of mat.
   * 
   * @param mat
   *          the array
   * @param colAIndex
   *          the index of a column to be swapped
   * @param colBIndex
   *          the index of a column to be swapped
   */
  public static void swapColumns(int[][] mat, int colAIndex, int colBIndex)
  {
    int[] temp = new int[mat[0].length];
    for (int r = 0; r < mat.length; r++)
    {
      temp[r] = mat[r][colAIndex];
      mat[r][colAIndex] = mat[r][colBIndex];
      mat[r][colBIndex] = temp[r];
    }

    // TODO: Finish
  }

  /**
   * Returns an array with the specified number of rows and columns containing
   * the characters from str in row-major order. If str.length() is greater than
   * rows * cols, extra characters are ignored. If str.length() is less than
   * rows * cols, the remaining elements in the returned array contain null.
   * 
   * @param str
   *          the string to be placed in an array
   * @param rows
   *          the number of rows in the array to be returned
   * @param cols
   *          the number of columns in the array to be returned
   * @return an array containing the characters from str in row-major order
   */
  public static String[][] fill2DWithLetters(String str, int rows, int cols)
  {
    // TODO: Finish
    String[][] answer = new String[rows][cols];
    int helper = 0;
    for (int r = 0; r < answer.length; r++)
    {
      for (int c = 0; c < answer[0].length; c++)
      {
        if (helper < str.length())
        {
          answer[r][c] = str.substring(helper, helper + 1);
          helper++;
        }
      }
    }
    return answer;
  }

  /**
   * Returns an array with the specified number of rows and columns that
   * contains the elements of vals in the order specified below. Elements from
   * vals are placed in the array by moving down the first column, up the second
   * column and so on.
   * 
   * <pre>
   * For example, if vals was:
   * {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}
   * 
   * rows was 3 and cols was 4,
   * the returned array would be:
   * { {1, 6, 7, 12},
   *   {2, 5, 8, 11},
   *   {3, 4, 9, 10} }
   * 
   * Precondition: vals.length == rows * cols
   * </pre>
   * 
   * @param vals
   *          the elements
   * @param rows
   *          the number of rows in the array to be returned
   * @param cols
   *          the number of columns in the array to be returned
   * @return an array containing the elements from vals in the specified order
   */
  public static int[][] fillDownAndUp(int[] vals, int rows, int cols)
  {
    // TODO: Finish
    int[][] answer = new int[rows][cols];
    int counter = 0;
    for (int c = 0; c < answer[0].length; c++)
    {
      for (int r = 0; r < answer.length; r++)
      {
        if (c % 2 == 0) // only even numbered columns are going to be going down
                        // normal
          answer[r][c] = vals[counter];
        else // odd numbered columns are going to be the weird ones that we need
             // to go up instead of down.
          answer[answer.length - r - 1][c] = vals[counter];
        // answer.length - 1
        // keeps the index
        // in check and
        // subtracting r
        // lets the rows
        // change down by
        // one
        counter++;
      }
    }
    return answer;
  }

  /**
   * Returns a smaller array containing the elements in the specified range of
   * the mat.
   * 
   * For example,
   * 
   * <pre>
   * mat: { {10, 9, 8, 7}, 
   *        {6, 5, 4, 3}, 
   *        {2, 1, -1, 0} }
   * 
   * startRow: 0, startCol: 1, endRow: 1, endCol: 2
   * 
   * would yield: { {9, 8},
   *                {5, 4} }
   * </pre>
   * 
   * @param mat
   *          the 2D array containing the original elements
   * @param startRow
   *          the first row to be kept
   * @param startCol
   *          the first column to be kept
   * @param endRow
   *          the last row to be kept
   * @param endCol
   *          the last column to be kept
   * @return a smaller array containing the specified elements
   */
  public static int[][] crop2D(int[][] mat, int startRow, int startCol,
    int endRow, int endCol)
  {
    int totalRows = endRow - startRow + 1; // + 1 to keep right amount of rows.
    int totalCols = endCol - startCol + 1;  // + 1 to keep right amount of columns.
    int [][] answer = new int [totalRows][totalCols]; // only has the necessary rows and columns.
    
    for (int r = 0; r < answer.length; r++)
    {
      for (int c = 0; c < answer[0].length; c++)
      {
        answer[r][c] = mat[startRow + r][startCol + c];
      }
    }
    return answer;
  }

}