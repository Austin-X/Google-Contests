import java.io.*;
import java.util.*;

public class ReversortEngineering {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int T = readInt();
		
		for (int t = 1; t <= T; t ++) {
			int n = readInt(), c = readInt();
			int minPossible = n - 1, maxPossible = n * (n + 1) / 2 - 1;
			
			if (c < minPossible || c > maxPossible) {
				System.out.println("Case #" + t + ": IMPOSSIBLE");
				continue;
			}
			
			int[] steps = new int[n + 1];
			
			int val = 0, max = n;
			for (int i = 2; i <= n; i ++) {
				if (c - val - max <= n - i) {
					steps[i] = c - val - n + i;
					for (int j = i + 1; j <= n; j ++) steps[j] = 1;
					break;
				} else {
					steps[i] = max;
					val += max;
				}
				max --;
			}

			int[] pos = new int[n + 1];
			for (int i = 1; i < n; i ++) {
				int swap = steps[i + 1];
				int p = i + swap - 1;
				pos[i] = p;
			}
			
			int[] ans = new int[n + 1], indices = new int[n + 1];
			for (int i = 1; i <= n; i ++) indices[i] = i;
			
			ans[pos[1]] = 1;
			for (int i = 2; i < n; i ++) {
				int[] temp = new int[pos[i - 1] - i + 2];
				int cnt = 0;
				for (int j = pos[i - 1]; j >= i - 1; j --) {
					temp[cnt] = indices[j];
					cnt ++;
				}
				cnt = 0;
				for (int j = i - 1; j <= pos[i - 1]; j ++) {
					indices[j] = temp[cnt];
					cnt ++;
				}
				
				ans[indices[pos[i]]] = i;
			}
			
			System.out.print("Case #" + t + ": ");
			for (int i = 1; i < n; i ++) {
				if (ans[i] == 0) System.out.print(n + " ");
				else System.out.print(ans[i] + " ");
			}
			
			if (ans[n] == 0) System.out.println(n);
			else System.out.println(ans[n]);
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
