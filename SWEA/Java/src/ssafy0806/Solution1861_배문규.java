package ssafy0806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1861_배문규 {

	static int N;
	static int[][] map;
	static int[][] dp;
	static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			dp = new int[N][N];
			int _min = Integer.MAX_VALUE;
			int[] _minIdx = new int[2];
			
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(_min < map[i][j]) {
						_min = map[i][j];
						_minIdx[0] = i;
						_minIdx[1] = j;
					}
				}
			}
			
			// 최종 출력에 필요한 시작지점과 최대값 
			int _max = Integer.MIN_VALUE;
	        int start = Integer.MAX_VALUE;
	        
	        for(int i = 0; i < N; i++) {
	        	for(int j = 0; j < N; j++) {
	        		//아직 방문을 1번도 안한곳이라면 DP 진입
	        		if(dp[i][j] == 0) DP(i, j);
	        		// DP후 dp[i][j]에 저장된 값이 max값이면 시작지점과 최대값 갱신
	        		if(_max < dp[i][j]) {
	        			_max = dp[i][j];
	        			start = map[i][j];
	        		}// dp[i][j]가 최대값과 같으면서, 시작지점이 더 앞이라면 시작지점 갱신
	        		else if(_max == dp[i][j] && start > map[i][j]) start = map[i][j];
	        	}
	        }
	        
	        System.out.println("#"+tc+" "+start+" "+_max);
		}
	}
	
	public static void DP(int i, int j) {
		// 1로 시작지점 초기화
		dp[i][j] = 1;
		// 4방 탐색
        for (int d = 0; d < 4; d++) {
            int ni = i + dx[d];
            int nj = j + dy[d];
            // 배열 경계를 벗어나면
            if(isBoundary(ni, nj)) continue;
            // 탐색한 위치가 기존 지점보다 1 큰 값이라면,
            if(map[ni][nj] == map[i][j] + 1) {
            	// 한번도 방문하지 않았다면 해당 위치에서 DP 시작
                if(dp[ni][nj] == 0) DP(ni, nj);
                // DP(ni, nj) 결과로 저장된  dp[ni][nj]의 값과 이전 위치였던 dp[i][j]값을 비교해서 최대값으로 갱신한다.
                if(dp[i][j] < dp[ni][nj]+1) dp[i][j] = dp[ni][nj]+1;
            }
        }
	}
	
	public static boolean isBoundary(int i, int j) {
		if(i < 0 || i > N-1 || j < 0 || j > N-1) return true;
		else return false;
	}
}