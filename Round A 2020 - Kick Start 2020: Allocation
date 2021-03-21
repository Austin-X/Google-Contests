import java.io.*;
import java.util.*;

public class Allocation {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int T = readInt();
		
		for (int t = 1; t <= T; t ++) {
			int n = readInt(), b = readInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i ++) arr[i] = readInt();
			
			Arrays.sort(arr);
			int ans = 0;
			for (int i = 0; i < n; i ++) {
				if (b - arr[i] >= 0) {
					ans ++;
					b -= arr[i];
				} else break;
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
