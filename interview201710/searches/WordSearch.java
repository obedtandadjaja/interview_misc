/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent"
cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
 */

class WordSearch {
    public static void main(String[] args) {
        char[][] board = new char[][] {
            new char[] { 'A', 'B', 'C', 'E' },
            new char[] { 'S', 'F', 'C', 'S' },
            new char[] { 'A', 'D', 'E', 'E' }
        };
        System.out.println(exist(board, "ASADFBCCEESE"));
    }

    public static boolean exist(char[][] board, String word) {

        // iterate the board search for first word
        for(int y = 0; y < board.length; y++) {
            for(int x = 0; x < board[y].length; x++) {
                if(word.charAt(0) == board[y][x]) {

                    // dfs the character
                    boolean result = iterateDFS(board, word, y, x, 0);
                    if(result) return true;
                }
            }
        }

        return false;
    }

    public static boolean iterateDFS(char[][] board, String word, int y, int x, int index) {
        if(index >= word.length()) return true;
        else if(y < 0 || y >= board.length || x < 0 || x >= board[y].length) return false;
        else if(board[y][x] != word.charAt(index)) return false; // not a matching char

        char oldChar = board[y][x];
        board[y][x] = '-'; // set visited
        boolean result = iterateDFS(board, word, y-1, x, index+1) ||
                         iterateDFS(board, word, y, x+1, index+1) ||
                         iterateDFS(board, word, y+1, x, index+1) ||
                         iterateDFS(board, word, y, x-1, index+1);
        board[y][x] = oldChar;

        return result;
    }
}
