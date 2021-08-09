package ssafy0809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution5215_배문규 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			
			int[][] burger = new int[N+1][2];
			for(int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				burger[i][0] = Integer.parseInt(st.nextToken());
				burger[i][1] = Integer.parseInt(st.nextToken());
			}
			
			int[][] DP = new int[2][L+1];
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= L; j++) {
					// i번째 재료 칼로리가 j보다 크다면
					if(burger[i][1] > j) 
					// i번째 재료 칼로리가 도달하기 전까지 이전까지 최고 점수를 그대로 갱신
						DP[i%2][j] = DP[(i-1)%2][j];
					// i번째 재료 칼로리가 j보다 같거나 작다면
					else 
					// 이전까지 해당 칼로리의 최대점수와 비교해서 갱신
					// 이전까지 해당 칼로리에서 최대점수 vs (이전까지 해당칼로리-현재 재료칼로리)의 점수+현재 재료 점수의 최대값 비교후 갱신
						DP[i%2][j] = Math.max(DP[(i-1)%2][j], DP[(i-1)%2][j-burger[i][1]] + burger[i][0]);
				}
			}
			
			sb.append("#"+tc+" "+DP[N%2][L]+"\n");
		}
		
		System.out.println(sb.toString());
	}

}