package BaekOJ.ssafy0820;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BaekOJ15683_배문규 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	static int N, M, _min, CCTV[][][];
	static int delta[][] = {{0,1}, {1,0}, {0,-1}, {-1,0}};
	static List<int[]> cctvList;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// CCTV 탐색 정보
		CCTV = new int[6][][];
		CCTV[1] = new int[][] {{0}, {1}, {2}, {3}};
		CCTV[2] = new int[][] {{0,2}, {1,3}};
		CCTV[3] = new int[][] {{0,1}, {1,2}, {2,3}, {0,3}};
		CCTV[4] = new int[][] {{0,1,2}, {1,2,3}, {0,1,3}, {0,2,3}};
		CCTV[5] = new int[][] {{0,1,2,3}};
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 지도와 cctv 정보를 저장
		int[][] map = new int[N][M];
		cctvList = new ArrayList<int[]>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0 || map[i][j] == 6) continue;
				cctvList.add(new int[] {map[i][j], i, j});
			}
		}
		
		_min = Integer.MAX_VALUE;
		search(0, map);
		System.out.println(_min);
	}
	
	public static void search(int depth, int[][] arr) {
		// 기저조건
		if(depth == cctvList.size()) {
			// 사각지대를 세고 최솟값 갱신
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) if(arr[i][j] == 0) cnt++;
			}
			_min = Math.min(_min, cnt);
			return;
		}
		
		// 현재 depth의 CCTV 객체를 꺼냄
		for(int[] dt : CCTV[cctvList.get(depth)[0]]) {
			int[][] copy = copyArr(arr); // 마킹을 할 복제배열 생성
			
			for(int d : dt) { // 해당 CCTV의 델타 탐색 방향
				int di = cctvList.get(depth)[1] + delta[d][0];
				int dj = cctvList.get(depth)[2] + delta[d][1];
				// 나가거나 벽을 만날 때 까지
				while(!oob(di, dj) && copy[di][dj] != 6) {
					if(copy[di][dj] == 0) copy[di][dj] = 9; // CCTV가 탐색이 된 부분은 마킹
					
					di += delta[d][0]; // 해당 델타 방향으로 탐색 진행
					dj += delta[d][1]; // 해당 델타 방향으로 탐색 진행
				}
			}
			// 다음 CCTV로 DFS
			// 하나의 줄기가 기저조건 까지 닿으면 다음 dt로 넘어감
			search(depth+1,  copy); 
		}
	}
	
	// 바운더리 체크
	public static boolean oob(int i, int j) {
		if(i>N-1 || i<0 || j>M-1 || j<0) return true;
		else return false;
	}
	
	// 배열 복사
	public static int[][] copyArr(int[][] arr){
		int[][] temp = new int[N][M];
		for(int i = 0; i < N; i++) System.arraycopy(arr[i], 0, temp[i], 0, M);
		return temp;
	}

}
