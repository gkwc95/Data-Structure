package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class Shortest_Path_In_Binary_Matrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[]{0, 0, 1});
        grid[0][0] = 1;
        int[][] dir = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] tmp = q.poll();
                if (tmp[0] == n-1 && tmp[1] == n-1){
                    return tmp[2];
                }
                for (int[] d : dir){
                    int row = d[0] + tmp[0];
                    int col = d[1] + tmp[1];
                    if (row >= 0 && col >= 0 && row < n && col<n && grid[row][col] == 0){
                        q.add(new int[]{ row , col, tmp[2]+1});
                        grid[row][col] = 1;
                    }
                }
            }
        }
        return -1;
    }
    /*
    BFS approach
     */
}
