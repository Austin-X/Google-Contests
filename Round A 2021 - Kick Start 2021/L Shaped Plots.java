import java.io.*;
import java.util.*;

public class LShapedPlots {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int T = readInt();
		
		for (int t = 1; t <= T; t ++) {
			int r = readInt(), c = readInt();
			
			int[][] grid = new int[r][c];
			for (int i = 0; i < r; i ++)
				for (int j = 0; j < c; j ++)
					grid[i][j] = readInt();
			
			int[][] psaRow = new int[r][c], b_psaRow = new int[r][c], psaCol = new int[r][c], b_psaCol = new int[r][c];
			
			for (int i = 0; i < c; i ++) {
				b_psaCol[r - 1][i] = grid[r - 1][i] == 1 ? 1 : 0;
				for (int j = r - 2; j >= 0; j --) {
					b_psaCol[j][i] = grid[j][i] == 1 ? b_psaCol[j + 1][i] + 1 : 0;
				}
				
				psaCol[0][i] = grid[0][i] == 1 ? 1 : 0;
				for (int j = 1; j < r; j ++) {
					psaCol[j][i] = grid[j][i] == 1 ? psaCol[j - 1][i] + 1 : 0;
				}
			}
			
			for (int i = 0; i < r; i ++) {
				b_psaRow[i][c - 1] = grid[i][c - 1] == 1 ? 1 : 0;
				for (int j = c - 2; j >= 0; j --) {
					b_psaRow[i][j] = grid[i][j] == 1 ? b_psaRow[i][j + 1] + 1 : 0;
				}
				
				psaRow[i][0] = grid[i][0] == 1 ? 1 : 0;
				for (int j = 1; j < c; j ++) {
					psaRow[i][j] = grid[i][j] == 1 ? psaRow[i][j - 1] + 1 : 0;
				}
			}
			
			int ans = 0;
			for (int i = 0; i < r; i ++) {
				for (int j = 0; j < c; j ++) {
					if (grid[i][j] == 0) continue;
										
					int row = psaRow[i][j], col = psaCol[i][j];
					int bRow = b_psaRow[i][j], bCol = b_psaCol[i][j];
					
					for (int k = 2; k <= col; k ++) {
						if (2 * k > row) break;
						ans ++;
					}
					for (int k = 2; k <= row; k ++) {
						if (2 * k > col) break;
						ans ++;
					}
					
					for (int k = 2; k <= bCol; k ++) {
						if (2 * k > row) break;
						ans ++;
					}
					for (int k = 2; k <= row; k ++) {
						if (2 * k > bCol) break;
						ans ++;
					}
					
					for (int k = 2; k <= col; k ++) {
						if (2 * k > bRow) break;
						ans ++;
					}
					for (int k = 2; k <= bRow; k ++) {
						if (2 * k > col) break;
						ans ++;
					}
					
					for (int k = 2; k <= bCol; k ++) {
						if (2 * k > bRow) break;
						ans ++;
					}
					for (int k = 2; k <= bRow; k ++) {
						if (2 * k > bCol) break;
						ans ++;
					}
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
