import java.io.*;
import java.util.*;

public class Reversort {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int T = readInt();
		
		for (int t = 1; t <= T; t ++) {
			int n = readInt();
			int[] arr = new int[n + 1];
			for (int i = 1; i <= n; i ++) arr[i] = readInt();
			
			int cost = 0;
			for (int i = 1; i <= n - 1; i ++) {
				int min = i;
				for (int j = i + 1; j <= n; j ++) {
					if (arr[j] < arr[min]) {
						min = j;
					}
				}
				
				ArrayList<Integer> temp = new ArrayList<Integer>();
				for (int j = min; j >= i; j --) temp.add(arr[j]);
				for (int j = i; j <= min; j ++) arr[j] = temp.get(j - i);
				cost += min - i + 1;
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
