import java.io.*;
import java.util.*;

public class AppendSort {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int T = readInt();
		
		for (int t = 1; t <= T; t ++) {
			int n = readInt();
			String[] arr = new String[n];
			for (int i = 0; i < n; i ++) arr[i] = next();
			
			int ans = 0;
			for (int i = 1; i < n; i ++) {
				String str1 = arr[i - 1], str2 = arr[i];

				if (str1.length() > str2.length() || str1.length() == str2.length() && str1.compareTo(str2) >= 0) {
					int digits1 = str1.length(), digits2 = str2.length();
					int diff = digits1 - digits2;

					if (str1.substring(0, str2.length()).compareTo(str2) < 0) {
						ans += diff;
						for (int k = 0; k < diff; k ++) arr[i] += "0";
					} else if (str1.substring(0, str2.length()).equals(str2)) {
						
						char[] ch = str1.toCharArray();
						int[] temp = new int[ch.length];
						for (int k = 0; k < ch.length; k ++) temp[k] = Character.getNumericValue(ch[k]);
						
						boolean flag = false;
						temp[ch.length - 1] ++;
						for (int k = ch.length - 1; k >= 0; k --) {
							if (temp[k] == 10) {
								temp[k] = 0;
								if (k > 0) temp[k - 1] ++;
								else flag = true;
							}
						}
						
						String s = "";
						if (flag) s += "1";
						for (int k = 0; k < ch.length; k ++) s += temp[k];
						
						ans += diff;
						
						if (!s.substring(0, str2.length()).equals(str2)) {
							for (int k = 0; k < diff + 1; k ++) arr[i] += "0";
							ans ++;
						} else {
							arr[i] = s;
						}
					} else {
						for (int k = 0; k < diff + 1; k ++) arr[i] += "0";
						ans += diff + 1;
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
