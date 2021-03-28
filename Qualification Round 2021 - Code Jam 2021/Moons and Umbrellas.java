import java.io.*;
import java.util.*;

public class MoonsAndUmbrellas {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int T = readInt();
		
		for (int t = 1; t <= T; t ++) {
			int x = readInt(), y = readInt();
			char[] ch = next().toCharArray();
			int n = ch.length;
			
			int prev = -1, cost = 0;
			for (int i = 0; i < n; i ++) {
				if (ch[i] != '?') {
					if (prev != -1 && i - prev > 1) {
						if (ch[prev] == 'C' &&  ch[i] == 'J') cost += x;
						else if (ch[prev] == 'J' && ch[i] == 'C') cost += y;
						prev = i;
					} else if (prev != -1 && i - prev == 1) {
						if (ch[prev] == 'C' && ch[i] == 'J') cost += x;
						else if (ch[prev] == 'J' && ch[i] == 'C') cost += y;
					} 
					prev = i;
				}
			}
			System.out.println("Case #" + t + ": " + cost);
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
