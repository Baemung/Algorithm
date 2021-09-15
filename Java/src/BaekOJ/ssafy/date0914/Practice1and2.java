package BaekOJ.ssafy.date0914;

import java.io.*;
import java.util.*;

public class Practice1and2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		
		// 문제 1
		int dp[][] = new int[N+1][2];
		dp[1] = new int[] {1, 1};
		dp[2] = new int[] {2, 1};
		for(int i = 3; i <= N; i++)
			dp[i] = new int[] {dp[i-1][0] + dp[i-1][1], dp[i-1][0]}; // 노랑은 다 올라갈 수 있고, 파랑은 노랑위에만 올라갈 수 있음
		System.out.println(dp[N][0]+dp[N][1]);
		
		// 문제 2
//		int dp[] = new int[N+1];
//		dp[1] = 2;
//		dp[2] = 5;
//		for(int i = 3; i <= N; i++)
//			dp[i] = dp[i-1]*dp[1] + dp[i-2]; // 사이즈 1짧은거에서 막대 2개, 사이즈 2짧은거에서 막대 1개
//		System.out.println(dp[N]);
	}
}
