/*
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X

After running your function, the board should be:
X X X X
X X X X
X X X X
X O X X
*/

import java.util.*;

class SurroundedRegions {
    public static void main(String[] args) {
        char[][] board = new char[] {
            new char[] { 'X', 'X', 'X', 'X' },
            new char[] { 'X', 'O', 'O', 'X' },
            new char[] { 'X', 'X', 'O', 'X' },
            new char[] { 'X', 'O', 'X', 'X' }
        };
        solve(board);
    }

    public static void solve(char[][] board) {
        if(board.length == 0) return;
        
        for(int i = 0; i < board.length; i++) {
            if(board[i][0] == 'O') markUncaptured(board, i, 0);
            if(board[i][board[i].length-1] == 'O') markUncaptured(board, i, board[i].length-1);
        }
        
        for(int i = 1; i < board[0].length-1; i++) {
            if(board[0][i] == 'O') markUncaptured(board, 0, i);
            if(board[board.length-1][i] == 'O') markUncaptured(board, board.length-1, i);
        }
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == 'O') board[i][j] = 'X';
                else if(board[i][j] == 'U') board[i][j] = 'O';
            }
        }
    }
    
    public static void markUncaptured(char[][] board, int x, int y) {
        Stack<int[]> s = new Stack<>();
        s.push(new int[] { x, y });
        
        while(!s.empty()) {
            int[] coor = s.pop();
            x = coor[0];
            y = coor[1];
            board[x][y] = 'U';
            
            if(x > 0 && board[x-1][y] == 'O') s.push(new int[] { x-1, y });
            if(x < board.length-1 && board[x+1][y] == 'O') s.push(new int[] { x+1, y });
            if(y > 0 && board[x][y-1] == 'O') s.push(new int[] { x, y-1 });
            if(y < board[x].length-1 && board[x][y+1] == 'O') s.push(new int[] { x, y+1 });
        }
    }
}
