package BaekOJ.study.date0921;

import java.io.*;
import java.util.*;

public class BaekOJ11066_배문규 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	static int T, K, file[], sum[], dp[][], knuth[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			K = Integer.parseInt(br.readLine());
			file = new int[K];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < K; i++) file[i] = Integer.parseInt(st.nextToken());
			
			sum = new int[K+1];
			for(int i = 0; i < K; i++) sum[i+1] = sum[i]+file[i];
			
			dp = new int[K][K];
			knuth = new int[K][K];
			for(int i = 0; i < K; i++) knuth[i][i] = i;
			
			for(int x = 1; x < K; x++) {
				for(int i = 0; i < K-x; i++) {
					int j = i+x;
					dp[i][j] = Integer.MAX_VALUE;
					for(int div = knuth[i][j-1]; div <= knuth[i+1][j]; div++) {
						if(div < K-1 && dp[i][j] > dp[i][div]+dp[div+1][j]+sum[j+1]-sum[i]) {
							dp[i][j] = dp[i][div]+dp[div+1][j]+sum[j+1]-sum[i];
							knuth[i][j] = div;
						}
					}
				}
			}
			sb.append(dp[0][K - 1]).append("\n");
		}
		System.out.println(sb);
	}
}