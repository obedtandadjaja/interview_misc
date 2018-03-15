/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
*/

import java.util.*;

class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[] { new int[] { 2,3 } };
        System.out.println(spiralOrder(matrix).toString());
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if(matrix.length == 0) return result;
        
        int i = 0;
        int iteration = Math.min(matrix[0].length, matrix.length);
        for(; i < iteration/2; i++) {
            int start_x = i;
            int end_x = matrix[i].length-i-1;
            int start_y = i;
            int end_y = matrix.length-i-1;
            
            // right
            for(int x = start_x; x < end_x; x++) result.add(matrix[start_y][x]);
            // down
            for(int y = start_y; y < end_y; y++) result.add(matrix[y][end_x]);
            // left
            for(int x = end_x; x > i; x--) result.add(matrix[end_y][x]);
            // up
            for(int y = end_y; y > i; y--) result.add(matrix[y][start_x]);
        }
        
        if(iteration % 2 == 1) {
            if(iteration != matrix[0].length) {
                for(int x = i; x < matrix[i].length-i; x++) result.add(matrix[matrix.length/2][x]);
            } else {
                for(int y = i; y < matrix.length-i; y++) result.add(matrix[y][matrix[0].length/2]);
            }
        }
        
        return result;
    }
    
    public static List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if(matrix.length == 0) return result;
        
        int start_x = 0; int end_x = matrix[0].length-1;
        int start_y = 0; int end_y = matrix.length-1;
        
        while(start_x <= end_x && start_y <= end_y) {
            
            // right
            for(int x = start_x; x <= end_x; x++) result.add(matrix[start_y][x]);
            start_y++;
            
            // down
            for(int y = start_y; y <= end_y; y++) result.add(matrix[y][end_x]);
            end_x--;
            
            // left
            if(start_y <= end_y) {
                for(int x = end_x; x >= start_x; x--) result.add(matrix[end_y][x]);
            }
            end_y--;
            
            // up
            if(start_x <= end_x) {
                for(int y = end_y; y >= start_y; y--) result.add(matrix[y][start_x]);
            }
            start_x++;
        }
        
        return result;
    }
}
