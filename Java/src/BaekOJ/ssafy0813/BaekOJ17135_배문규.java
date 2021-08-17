package BaekOJ.ssafy0813;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekOJ17135_배문규 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuffer sb = new StringBuffer();
	static StringTokenizer st = null;
	static int N, M, D;
	static int _max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int[] archer = new int[M];
		int idx = M;
		while(--idx >= M-3) archer[idx] = 9;  
			
		do {
			int cnt = 0;

			// 각 조합마다 원본 맵 복사
			int[][] copymap = new int[N][M];
			for(int i = 0; i < N; i++) for(int j = 0; j < M; j++) copymap[i][j] = map[i][j];
						
			// 궁수 위치를 입력받고 정렬 
			int aIdx = 0;
			int[] archerIdx = new int[3];
			for(int j = 0; j < M; j++) 
				if(archer[j] == 9) archerIdx[aIdx++] = j;
			Arrays.sort(archerIdx);
			
			
			// 궁수가 해당 턴에서 공격할 수 있는 거리
			// 턴이 늘어날수록 공격거리는 dist + turn 이 됨
			int dist = D;
			int turn = 0;
			// 턴이 N번 반복
			while(++turn <= N) {
				// 타겟 초기화
				int[][] del = {{-1, -1}, {-1, -1}, {-1, -1}};
				// 궁수 3명
				for(int a = 0; a < 3; a++) {
				// 공격 거리가 짧은 순부터 시작
				loop :for(int d = 1; d <= dist; d++) {
						// 왼쪽부터 적 탐색
						for(int j = 0; j < M; j++){
							// 적이 아래로 내려오는 걸 i = N-turn으로 표현함 N-turn 보다 큰 인덱스는 보지 않음.
							// 직선 최단 거리인 N-dist-turn 까지
							for(int i = N-turn; i >= N-dist-turn && i >= 0; i--) {
								// 가까운부터  왼쪽에서 탐색하는데 궁수가 공격할 수 있다면, 
								if((N-i) + Math.abs(archerIdx[a]-j) == d && copymap[i][j] == 1) {
									// 타겟 위치 저장
									del[a][0] = i;
									del[a][1] = j;
									// 다음 궁수
									break loop;
								}
							}
						}
					}
				}
				// 해당 턴에서 공격할 적 확인
				for(int[] d : del) {
					// 타겟이 설정되어 있고, 아직 공격받지 않으면
					if(d[0] != -1 && copymap[d[0]][d[1]] == 1) {
						// 공격하고 카운트
						copymap[d[0]][d[1]] = 0;
						cnt++;
					}
				}
				dist++;
			}
			_max = Math.max(_max, cnt);
		}while(np(archer));
		
		System.out.println(_max);
	}
	
	public static boolean np(int[] arr) {
		int N = arr.length;
		
		int i = N-1;
		while(i > 0 && arr[i-1] >= arr[i]) --i;
		
		if(i == 0) return false;
		
		int j = N-1;
		while(arr[i-1] >= arr[j]) --j;
		
		swap(arr, i-1, j);
		
		int k = N-1;
		while(i < k) swap(arr, i++, k--);
		
		return true;
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
