package BaekOJ.study.date0828;

import java.io.*;
import java.util.*;

public class BaekOJ14502_배문규 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	
	static int N, M, map[][], temp[][], _max= Integer.MIN_VALUE;
	static int delta[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

	public static void main(String[] args) throws NumberFormatException, IOException {

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M]; 
		temp = new int[N][M]; 
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		setBarricade(0, 0);
		System.out.println(_max);
	}
	
	public static void setBarricade(int idx, int cnt) {
		// 바리케이트를 3개 세우면
		if(cnt == 3) {
			_max = Math.max(_max, getResult()); // 안전지대 최대 수 구함
			return;
		}
		
		// DFS로 바리케이트 세우기
		for(int i = idx; i < N*M; i++) {
			int ni = i/M;
			int nj = i%M;
			if(map[ni][nj] == 0) {
				map[ni][nj] ^= 1; // 세우기
				setBarricade(idx+1, cnt+1); 
				map[ni][nj] ^= 1; // 허물기
			}
		}
	}
	
	public static int getResult() {
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++) temp[i][j] = map[i][j];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 2) spreadingVirus(temp, i, j);
			}
		}
		
		return getSafeZone(temp);
	}
	
	// 바이러스가 퍼지는 걸 DFS로 구현
	public static void spreadingVirus(int[][] map, int i, int j) {
		map[i][j] = 3;
		int di = 0, dj = 0;
		for(int d = 0; d < 4; d++) {
			di = i + delta[d][0];
			dj = j + delta[d][1];
			
			if(!isOOB(di, dj) && map[di][dj] == 0) spreadingVirus(map, di, dj);
		}
	}
	
	// 안전지대 카운트
	public static int getSafeZone(int[][] map) {
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) cnt += 1;
			}
		}
		return cnt;
	}
	
	// 경계 체크
	public static boolean isOOB(int i, int j) {
		if (i>=N || i<0 || j>=M || j<0) return true;
		else return false;
	}
}