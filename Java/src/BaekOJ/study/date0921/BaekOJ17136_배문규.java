package BaekOJ.study.date0921;

import java.io.*;
import java.util.*;

public class BaekOJ17136_배문규 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	
	static int result = Integer.MAX_VALUE;
	static int[] paper = {0,1,2,3,4,5};

	public static void main(String[] args) throws NumberFormatException, IOException {
		int[][] map = new int[10][10];
		int cnt = 0;
		for(int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) cnt++; 
			}
		}
		
		if(cnt == 0) System.out.println(cnt);
		else {
			int[] remain = {0,5,5,5,5,5};
			dfs(map, 0, 0, remain, cnt);
			System.out.println(result == Integer.MAX_VALUE ? -1 : result);
		}
	}
	
	public static void dfs(int[][] map, int startI, int startJ, int[] remain, int cnt) {
		if(cnt == 0) {
			int sum = 25;
			for(int r : remain) sum -= r;
			if(sum < result) result = sum;
			return;
		}
		
		for(int i = startI; i < 10; i++) {
			for(int j = startJ; j < 10; j++) {
				if(map[i][j] == 1) {
					for(int size = 1; size <= 5; size++) {
						if(remain[size] < 1) continue;
						if(check(map, i, j, size)) {
							int[][] temp = mark(map, i, j, size, size*-1);
							remain[size] += 1;
							dfs(temp, i, j+size, remain, cnt-(int)Math.pow(size,2));
							remain[size] -= 1;
						}
					}
				}
			}	
		}
	}
	
	public static boolean check(int[][] map, int si, int sj, int size) {
		if(isOOB(si+size, sj+size)) return false;
		for(int i = si; i < si+size; i++) {
			for(int j = sj; j < sj+size; j++) {
				if(map[i][j] != 1) return false;
			}
		}
		return true;
	}
	
	public static int[][] mark(int[][] map, int si, int sj, int size, int num) {
		int[][] temp = new int[10][10];
		for(int i = 0; i < 10; i++) System.arraycopy(map[i], 0, temp[i], 0, 10);
		
		for(int i = si; i < si+size; i++) {
			for(int j = sj; j < sj+size; j++) {
				temp[i][j] = num;
			}
		}
		return temp;
	}
	
	public static boolean isOOB(int i, int j) {
		if(i < 0 || i >= 10 || j < 0 || j >= 10) return true;
		else return false;
	}
}
