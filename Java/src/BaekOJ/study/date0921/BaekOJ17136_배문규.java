package BaekOJ.study.date0921;

import java.io.*;
import java.util.*;

public class BaekOJ17136_배문규 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st = null;
	
	static int map[][], cnt, result = Integer.MAX_VALUE, remain[] = {0,5,5,5,5,5};

	public static void main(String[] args) throws NumberFormatException, IOException {
		map = new int[10][10];
		for(int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 0);
		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
	}
	
	public static void dfs(int startI, int startJ) {
		if(startJ == 10) {
			dfs(startI+1, 0);
			return;
		}
		
		if(startI == 10) {
			result = result < cnt ? result : cnt;
			return;
		}

		if(map[startI][startJ] == 0) {
			dfs(startI, startJ+1);
			return;
		}
			
		for(int size = 5; size > 0; size--) {
			if(remain[size] == 0 || check(startI, startJ, size)) continue;
			
			mark(startI, startJ, size, 0);
			remain[size]--;
			cnt++;
			
			dfs(startI, startJ+size);
			
			mark(startI, startJ, size, 1);
			remain[size]++;
			cnt--;
		}	
	}
	
	public static boolean check(int si, int sj, int size) {
		if(isOOB(si+size, sj+size)) return true;
		for(int i = si; i < si+size; i++) {
			for(int j = sj; j < sj+size; j++) {
				if(map[i][j] == 0) return true;
			}
		}
		return false;
	}
	
	public static boolean isOOB(int i, int j) {
		if(i > 10 || j > 10) return true;
		else return false;
	}
	
	public static void mark(int si, int sj, int size, int num) {
		for(int i = si; i < si+size; i++) {
			for(int j = sj; j < sj+size; j++) {
				map[i][j] = num;
			}
		}
	}

}
