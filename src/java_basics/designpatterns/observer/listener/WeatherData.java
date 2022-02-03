package java_basics.designpatterns.observer.listener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;
import java.util.LinkedList;

public class WeatherData implements EventListener {
    public int orangesRotting(int[][] grid) {
        class Cell {
            int i, j;

            public Cell(int i, int j) {
                this.i = i;
                this.j = j;
            }

            @Override
            public String toString() {
                return "Cell{" +
                        "i=" + i +
                        ", j=" + j +
                        '}';
            }
        }

        LinkedList<Cell> list = new LinkedList<>();
        //add All rotten oranges
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2)
                    list.add(new Cell(i, j));
            }
        }
        int cnt = 0;
        while (!list.isEmpty()) {
            int size = list.size();
            System.out.println(list);
            for (int i = 0; i < size; i++) {
                Cell curr = list.poll();
                int row = curr.i;
                int col = curr.j;
                if (col + 1 < n && grid[row][col + 1] == 1) {
                    grid[row][col + 1] = 2;
                    list.add(new Cell(row, col + 1));
                }
                if (row + 1 < m && grid[row + 1][col] == 1) {
                    grid[row + 1][col] = 2;
                    list.add(new Cell(row + 1, col));
                }
                if (col - 1 >=0 && grid[row][col - 1] == 1) {
                    grid[row][col - 1] = 2;
                    list.add(new Cell(row, col - 1));
                }
                if (row - 1 >=0 && grid[row - 1][col] == 1) {
                    grid[row - 1][col] = 2;
                    list.add(new Cell(row - 1, col));
                }
            }
            cnt++;
        }
        return cnt;
    }
}
