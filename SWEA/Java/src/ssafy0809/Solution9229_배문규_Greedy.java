package ssafy0809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution9229_배문규_Greedy {
	
	static int N, M;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			int[] snack = new int[N+1];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) snack[i] = Integer.parseInt(st.nextToken());
			
			int result = -1;
			// 2중 for문으로 2가지 최적의 조합찾기
			for(int i = 0; i < N; i++) {
				for(int j = i+1; j < N; j++) {
					if(snack[i] + snack[j] <= M) result = Math.max(result, snack[i] + snack[j]);
				}
			}
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}