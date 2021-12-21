package BaekOJ.study.date1214;

import java.io.*;
import java.util.*;

/*
 * 백준 1799 비숍
 * 
 * 메모리 	시간
 * 15296	164
 */
public class BaekOJ1799_배문규 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	
	static int N, map[][], left[], right[], max[];
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		left = new int[N+N+1];
		right = new int[N+N+1];
		max = new int[2];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0, 0, 0, 0); // 첫 번째 칸
		dfs(0, 1, 0, 1); // 두 번째 칸
		
		System.out.println(max[0] + max[1]);
	}
	
	public static void dfs(int i, int j, int cnt, int loc) {
		max[loc] = Math.max(max[loc], cnt);	// 최대값 구하기
		
		if(j >= N) j = (++i%2+loc)%2;	// loc에 따라 다음 j 위치 조정
		if(i >= N) return;	
		
		if(map[i][j] == 1 && left[i+j] == 0 && right[i-j+N] == 0) { // 비숍을 놓을 수 있으면서 잡을 수 있는 말이 없다면
			left[i+j] = right[i-j+N] = 1;
			dfs(i, j+2, cnt+1, loc);
			left[i+j] = right[i-j+N] = 0;
		}
		
		dfs(i, j+2, cnt, loc);
	}
}
