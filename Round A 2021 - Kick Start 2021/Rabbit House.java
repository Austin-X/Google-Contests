import java.io.*;
import java.util.*;

public class RabbitHouse {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static class Cell implements Comparable<Cell> {
		int row, col, val;
		
		Cell (int row, int col, int val) {
			this.row = row;
			this.col = col;
			this.val = val;
		}

		public int compareTo(Cell c) {
			if (val == c.val && row == c.row) return Integer.compare(col, c.col);
			else if (val == c.val) return Integer.compare(row, c.row);
					
			return -Integer.compare(val, c.val);
		}
	}
	
	public static void main(String[] args) throws IOException {
		int T = readInt();
		
		for (int t = 1; t <= T; t ++) {
			int r = readInt(), c = readInt();
			int[][] grid = new int[r][c];
			
			TreeSet<Cell> set = new TreeSet<Cell>();
			for (int i = 0; i < r; i ++) {
				for (int j = 0; j < c; j ++) {
					grid[i][j] = readInt();
					set.add(new Cell(i, j, grid[i][j]));
				}
			}

			long ans = 0;
			
			while (!set.isEmpty()) {
				Cell cell = set.pollFirst();
				int val = grid[cell.row][cell.col];
				
				if (cell.row > 0 && val - grid[cell.row - 1][cell.col] > 1) {
					ans += val - grid[cell.row - 1][cell.col] - 1;
					grid[cell.row - 1][cell.col] = val - 1;
					set.add(new Cell(cell.row - 1, cell.col, grid[cell.row - 1][cell.col]));
				}
				if (cell.row < r - 1 && val - grid[cell.row + 1][cell.col] > 1) {
					ans += val - grid[cell.row + 1][cell.col] - 1;
					grid[cell.row + 1][cell.col] = val - 1;
					set.add(new Cell(cell.row + 1, cell.col, grid[cell.row + 1][cell.col]));
				}
				if (cell.col > 0 && val - grid[cell.row][cell.col - 1] > 1) {
					ans += val - grid[cell.row][cell.col - 1] - 1;
					grid[cell.row][cell.col - 1] = val - 1;
					set.add(new Cell(cell.row, cell.col - 1, grid[cell.row][cell.col - 1]));
				}
				if (cell.col < c - 1 && val - grid[cell.row][cell.col + 1] > 1) {
					ans += val - grid[cell.row][cell.col + 1] - 1;
					grid[cell.row][cell.col + 1] = val - 1;
					set.add(new Cell(cell.row, cell.col + 1, grid[cell.row][cell.col + 1]));
				}
			}
			
			System.out.println("Case #" + t + ": " + ans);
		}
	}

	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens()) 
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong() throws IOException {
		return Long.parseLong(next());
	}
	static int readInt() throws IOException {
		return Integer.parseInt(next());
	}
	static double readDouble() throws IOException {
		return Double.parseDouble(next());
	}
	static char readCharacter() throws IOException {
		return next().charAt(0);
	}
	static String readLine() throws IOException {
		return br.readLine().trim();
	}
}
