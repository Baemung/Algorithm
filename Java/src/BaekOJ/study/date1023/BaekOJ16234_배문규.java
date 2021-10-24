package BaekOJ.study.date1023;

import java.io.*;
import java.util.*;

/*
 * 백준 16234 인구 이동
 * 
 * 1. 하루동안 인구 이동이 진행
 * 	- L <= 인구 차이 <= R 면 국경선이 열림
 * 	- 서로 국경선이 열려 이동할 수 있으면 연합이 됨
 * 2. 더 이상 인구 이동이 없을 때까지 반복
 * 3. 인구 이동이 언제까지 진행되는지 날짜 구하기
 * 
 * 시행착오 : 유니온파인드로 연합을 만들어줬는데 이거 쉽지않다...
 * 
 * 메모리 	시간
 * 
 */

public class BaekOJ16234_배문규 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	
	static int N, L, R, map[][], union[], day = 0;
	static int delta[][] = {{0,1}, {1,0}, {0,-1}, {-1,0}};
	static boolean check[];
	static Set<Integer> set = new HashSet<Integer>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		union = new int[N*N];
		check = new boolean[N*N];
		while(day <= 2000) {
			for(int i = 0; i < N*N; i++) union[i] = i;
			Arrays.fill(check, false);
			boolean open = false;
			for(int i = 0; i < N*N; i++) {
				check[i] = true;
				int cI = i/N;
				int cJ = i%N;
				for(int[] d : delta) {
					int dI = cI + d[0];
					int dJ = cJ + d[1];
					if(isOOB(dI, dJ)) continue;
					int gap = Math.abs(map[cI][cJ] - map[dI][dJ]);
					if(L <= gap && gap <= R) {
						open = true;
						if(check[dI*N + dJ]) union_country(i, dI*N + dJ);
						else union_country(dI*N + dJ, i);
						check[dI*N + dJ] = true;
					}
				}
			}
			if(!open) break;
			
			set.clear();
			for(int i = 0; i < N*N; i++) set.add(union[i]);
			for(int u : set) {
				int cnt = 0;
				int sum = 0;
				for(int i = 0; i < N*N; i++) {
					if(union[i] == u) {
						cnt++;
						sum += map[i/N][i%N];
					}
				}
				for(int i = 0; i < N*N; i++) {
					if(union[i] == u) map[i/N][i%N] = sum/cnt;
				}
			}
			day++;
			debug();
		}
		System.out.println(day);
	}
	
	public static boolean union_country(int a, int b) {
		int unionA = find_union(a);
		int unionB = find_union(b);
		
		if(unionA == unionB) return false;
		
		union[unionA] = unionB;
		return true;
	}
	
	public static int find_union(int i) {
		if(union[i] == i) return i;
		return union[i] = find_union(union[i]);
	}
	
	public static boolean isOOB(int i, int j) {
		return i > N - 1 || i < 0 || j > N - 1 || j < 0;
	}
	
	public static void debug() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
