/*
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate 
(i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and 
(i, 0). Find two lines, which together with x-axis forms a container, such that the container 
contains the most water.

Note: You may not slant the container and n is at least 2.
*/

class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = new int[] { 1,2,3,54,55 };
        System.out.println(maxArea(height));
    }

    // O(n)
    public static int maxArea(int[] height) {
        int start = 0, end = height.length-1, max = Integer.MIN_VALUE;
        while(start < end) {
            max = Math.max(max, Math.min(height[start], height[end]) * (end - start));
            if(height[start] > height[end]) end--;
            else start++;
        }
        
        return max;
    }
    
    // O(n^2)
    public static int maxAreaDP(int[] height) {
        int[][] grid = new int[height.length][height.length];
        return getArea(height, 0, height.length-1, grid);
    }
    
    public static int getArea(int[] height, int start, int end, int[][] grid) {
        if(start >= end || start >= height.length || end < 0) return 0;
        if(grid[start][end] != 0) return grid[start][end];
        
        int max = Math.max(getArea(height, start + 1, end, grid), getArea(height, start, end-1, grid));
        
        int minHeight = Math.min(height[start], height[end]);
        grid[start][end] = minHeight * (end - start);
        
        return Math.max(max, grid[start][end]);
    }
}
