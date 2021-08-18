package SWEA.ssafy0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution4012_배문규 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	static int T, N, R[], C[], total, _min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++){
			N = Integer.parseInt(br.readLine());
			R = new int[N];
			C = new int[N];
			total = 0;
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					int taste = Integer.parseInt(st.nextToken());
					total += taste;
					R[i] += taste; // 행값 저장
					C[j] += taste; // 열값 저장
				}
			}
			
			_min = Integer.MAX_VALUE;
			cook(1, 1, total-R[0]-C[0]);
			sb.append("#").append(tc).append(" ").append(_min).append("\n");
		}
		System.out.println(sb);
	}
	
	// idx = A음식 조합 인덱스, cnt = N/2까지 도달하면 각 조합의 요리 완성, gap = 조합이 완성되었을 때 A와 B의 맛의 차
	// gap에서 n/2번 idx 값들을 빼면 자동적으로 A음식(음수) + B음식(양수)로 A와 B의 맛의 차가 됨
	public static void cook(int idx, int cnt, int gap) {
		// 조합이 만들어 지면 최솟값 찾고 종료
		if(cnt == N/2) {
			_min = Math.min(_min, Math.abs(gap)); // 차이가 음수가 될 수 있으므로 절대값
			return;
		}
		// 모든 조합을 다 찾으면 종료
		if(idx == N) return;
		// 음식 조합의 맛의 차이 구하기
		cook(idx+1, cnt+1, gap-R[idx]-C[idx]);
		// 다른 재료 조합 찾기
		cook(idx+1, cnt, gap);
	}
}