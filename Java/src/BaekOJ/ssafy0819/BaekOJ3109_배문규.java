package BaekOJ.ssafy0819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekOJ3109_배문규 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	static int R, C, result;
	static char[][] map;
	static boolean flag;

	public static void main(String[] args) throws NumberFormatException, IOException {

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		// 위아래 패딩하고 입력
		map = new char[R+2][];
		map[0] = new char[C];
		map[R+1] = new char[C];
		for(int i = 1; i <= R; i++) map[i] = br.readLine().toCharArray();
		
		// 플래그로 도착설정 하고 행별로 DFS
		for(int i = 1; i <= R; i++) {
			flag = false;
			DFS(i,1,i);
		}
		
		System.out.println(result);
	}
	
	// idx = 행, depth = 열, mark = 시작점
	public static void DFS(int idx, int depth, int mark) {
		// 도착하면 카운트하고 도착했다고 알림
		if(depth == C) {
			result += 1;
			flag = true;
			return;
		}
		
		// 우상 우 우하 탐색
		for(int i = idx-1; i <= idx+1; i++) {
			if(map[i][depth] == '.') {
				// 이미 도착했다면 리턴
				if(flag) return;
				map[i][depth] = Character.forDigit(mark , 10); // 마킹
				DFS(i, depth+1, mark); // DFS
			}
		}	
	}
}
