package SWEA.ssafy.date0916;

import java.io.*;
import java.util.*;

public class SWEA3307_배문규 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	static int T, N, seq[], dp[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			seq = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) seq[i] = Integer.parseInt(st.nextToken());
			
			// LIS를 저장 할 DP배열
			dp = new int[N];
			Arrays.fill(dp, 1);
			for(int i = 1; i < N; i++) { // 2번째 인덱스부터 N-1까지
				int _max = 1;
				for(int j = i-1; j >= 0; j--) { // 자기보다 앞의 인덱스값을 비교하여 LIS 갱신
					if(seq[i] > seq[j] && _max < dp[j]+1) _max = dp[j]+1; // 기준 인덱스값이 더 크면서, DP값이 더 작으면 갱신
				}
				dp[i] = _max;
			}
			int _max = -1;
			for(int i = 0; i < N; i++) {
				if(_max < dp[i]) _max = dp[i];
			}
			sb.append("#").append(tc).append(" ").append(_max).append("\n");
		}
		System.out.println(sb);
	}
}