package BaekOJ.ssafy0914;

import java.io.*;
import java.util.*;

public class BaekOJ1463_배문규 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	
	static int N, dp[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		for(int i = 2; i <= N; i++) {
			if(i%6 == 0) dp[i] = (dp[i-1] < dp[i/3] ? (dp[i-1] < dp[i/2] ? dp[i-1] : dp[i/2]) : (dp[i/3] < dp[i/2] ? dp[i/3] : dp[i/2]))+1;
			else if(i%3 == 0) dp[i] = Math.min(dp[i-1], dp[i/3])+1;
			else if(i%2 == 0) dp[i] = Math.min(dp[i-1], dp[i/2])+1;
			else dp[i] = dp[i-1]+1;
		}
		System.out.println(dp[N]);
	}
}