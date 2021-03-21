import java.io.*;
import java.util.*;

public class K_GoodnessString {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int T = readInt();
		
		for (int t = 1; t <= T; t ++) {
			int n = readInt(), k = readInt();
			char[] ch = readLine().toCharArray();
			int goodness = 0;
			for (int i = 0; i < n / 2; i ++) if (ch[i] != ch[n - i - 1]) goodness ++;
			System.out.println("Case #" + t + ": " + Math.abs(k - goodness));
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
